package com.example.evolved.blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

import javax.annotation.Nullable;
import javax.swing.*;
import java.util.List;

public class Generator extends Block implements EntityBlock {

    public static final String TUTORIAL_GEN ="tutorial GEN";
    public static final String MESSAGE_GEN ="message";
    private static final VoxelShape RENDER_SHAPE = Shapes.box(0.1,0.1,0.1,0.9,0.9,0.9);

    public Generator() {
        super(Properties.of(Material.METAL)
                .sound(SoundType.METAL)
                .noOcclusion()
                .lightLevel(state-> state.getValue(BlockStateProperties.POWERED)? 14:0)
                .strength(2f));
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos){
        return RENDER_SHAPE;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter reader ,List<Component> list, TooltipFlag flag) {
        list.add(new TranslatableComponent(MESSAGE_GEN,Integer.toString(GeneratorBE.GENERATOR_PRODUCE))
                .withStyle(ChatFormatting.BLUE));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState){
        return new GeneratorBE(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends  BlockEntity>BlockEntityTicker<T> getTicker(Level level , BlockState state, BlockEntityType<T> type){
        if (level.isClientSide()){
            return null;
        }
        return (lvl,pos,blockState, t)->{
            if(t instanceof GeneratorBE tile){
                tile.tickServer();
            }
        };
    }

        @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder){
        builder.add(BlockStateProperties.FACING, BlockStateProperties.POWERED);
        }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context){
        return super.getStateForPlacement(context).setValue(BlockStateProperties.POWERED, false);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
        if(!level.isClientSide){
            BlockEntity be = level.getBlockEntity(pos);
            if(be instanceof GeneratorBE){
                MenuProvider containerProvider = new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return new TranslatableComponent(TUTORIAL_GEN);}

                    @Override
                    public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity) {
                        return new GeneratorContainer(windowId, pos, playerInventory, playerEntity);
                    }
                };
                NetworkHooks.openGui((ServerPlayer) player, containerProvider,be.getBlockPos());
            }else{
                throw new IllegalStateException("missing named containerprovider");
            }
        }
        return InteractionResult.SUCCESS;
    }
}
