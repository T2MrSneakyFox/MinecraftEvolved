package com.evolved.blocks;

import com.evolved.energy.CustomEnergy;
import com.evolved.setup.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneratorBE extends BlockEntity {

    public static final int GENERATOR_MAX = 5000;
    public static final int GENERATOR_PRODUCE = 60;
    public static final int GENERATOR_SEND = 200;

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    private final CustomEnergy energyStorage = createEnergy();
    private final LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);

    private int counter;

    public GeneratorBE(BlockPos pos, BlockState state) {
        super(Registration.GENERATOR_BE.get(), pos, state);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        handler.invalidate();
        energy.invalidate();
    }

    public void tickServer() {
        if (counter > 0) {
            energyStorage.addEnergy(GENERATOR_PRODUCE);
            counter--;
            setChanged();
        }

        if (counter <= 0) {
            ItemStack stack = itemHandler.getStackInSlot(0);
            int burntime = ForgeHooks.getBurnTime(stack, RecipeType.SMELTING);
            if (burntime > 0) {
                itemHandler.extractItem(0, 1, false);
                counter = burntime;
                setChanged();
            }
        }

        BlockState blockState = level.getBlockState(worldPosition);
        if (blockState.getValue(BlockStateProperties.POWERED) != counter > 0) {

            level.setBlock(worldPosition, blockState.setValue(BlockStateProperties.POWERED, counter > 0),Block.UPDATE_ALL);
        }

    }

    private void sendOutPower() {
        AtomicInteger capacity = new AtomicInteger(energyStorage.getEnergyStored());
        if (capacity.get() > 0) {
            for (Direction direction : Direction.values()) {
                BlockEntity be = level.getBlockEntity(worldPosition.relative(direction));
                if (be != null) {
                    boolean doContinue = be.getCapability(CapabilityEnergy.ENERGY, direction.getOpposite()).map(handler -> {
                                if (handler.canReceive()) {
                                    int recived = handler.receiveEnergy(Math.min(capacity.get(), GENERATOR_SEND), false);
                                    capacity.addAndGet(-recived);
                                    energyStorage.consumeEnergy(recived);
                                    setChanged();
                                    return capacity.get() > 0;
                                } else {
                                    return true;
                                }
                            }
                    ).orElse(true);
                    if (!doContinue) {
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void load(CompoundTag tag) {
        if (tag.contains("inventory")){
            itemHandler.deserializeNBT(tag.getCompound("inventory"));
        }
        if (tag.contains("Energy")){
            energyStorage.deserializeNBT(tag.get("Energy"));
        }
        if (tag.contains("info")){
            counter = tag.getCompound("info").getInt("counter");
        }
        super.load(tag);
    }


    public void saveAdditional(CompoundTag tag){
        tag.put("inventory",itemHandler.serializeNBT());
        tag.put("Energy", energyStorage.serializeNBT());

        CompoundTag infoTag = new CompoundTag();
        infoTag.putInt("counter",counter);
        tag.put("info", infoTag);
    }

    private CustomEnergy createEnergy(){
        return new CustomEnergy(GENERATOR_MAX,0){
            @Override
            protected void onEnergyChanged() {
                setChanged();
            }
        };
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }
        if (cap == CapabilityEnergy.ENERGY){
            return energy.cast();
        }
        return super.getCapability(cap,side);
    }

   private ItemStackHandler createHandler(){
        return new ItemStackHandler(1) {

            @Override
            protected void onContentsChanged(int slot) {
               setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) >0;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) <=0){
                    return stack;
                }
                return super.insertItem(slot,stack,simulate);
            }

        };
   }
}
