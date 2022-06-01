package com.evolved.datagen;

import com.evolved.mainEvolved;
import com.evolved.setup.Registration;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class TutBlockStates extends BlockStateProvider {
    public TutBlockStates(DataGenerator gen, ExistingFileHelper helper) {super(gen, mainEvolved.MODID, helper);}

    @Override
    protected void registerStatesAndModels() {
        registerGeneratorBlock();
        electricalPillarBlock();
        simpleBlock(Registration.NICKEL_ORE_OVERWORLD.get());
        simpleBlock(Registration.ELECTRICAL_PILLAR.get());

    }

    private void registerGeneratorBlock(){
        ResourceLocation txt = new ResourceLocation(mainEvolved.MODID,"block/generator_side_a");
        BlockModelBuilder modelFirstBlock = models().cube("coolgenerator"
                ,txt,txt,new ResourceLocation(mainEvolved.MODID,"block/generator_front"),txt,txt,txt);
        BlockModelBuilder modelFirstBlockPowered = models().cube("coolgenerator_powered"
                ,txt,txt,new ResourceLocation(mainEvolved.MODID,"block/generator_front_on"),txt,txt,txt);
        orientedBlock(Registration.GENERATOR.get(),state -> {
            if (state.getValue(BlockStateProperties.POWERED)){
                return modelFirstBlockPowered;
            }else {
                return modelFirstBlock;
            }
        });
    }

    private void electricalPillarBlock(){

    }


    private void orientedBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    Direction dir = state.getValue(BlockStateProperties.FACING);
                    return ConfiguredModel.builder()
                            .modelFile(modelFunc.apply(state))
                            .rotationX(dir.getAxis() == Direction.Axis.Y ?  dir.getAxisDirection().getStep() * -90 : 0)
                            .rotationY(dir.getAxis() != Direction.Axis.Y ? ((dir.get2DDataValue() + 2) % 4) * 90 : 0)
                            .build();
                });
    }

}
