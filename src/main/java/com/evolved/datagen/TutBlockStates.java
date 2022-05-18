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
        simpleBlock(Registration.NICKEL_ORE_OVERWORLD.get());

    }

//    private void registerPowergen(){
//        BlockModelBuilder frame = models().getBuilder("block/generator/main");
//        frame.parent(models().getExistingFile(mcLoc("cube")));
//
//        floatingCube(frame,0f,0f,0f,1f,16f,1f);
//        floatingCube(frame,15f,0f,0f,16f,16f,1f);
//        floatingCube(frame,0f,0f,15f,1f,16f,16f);
//        floatingCube(frame,15f,0f,15f,16f,16f,16f);
//
//        floatingCube(frame,1f,0f,0f,15f,1f,15f);
//        floatingCube(frame,1f,15f,0f,15f,16f,15f);
//        floatingCube(frame,1f,0f,15f,15f,1f,15f);
//        floatingCube(frame,1f,15f,15f,15f,16f,15f);
//
//        floatingCube(frame,0f,0f,1f,1f,16f,15f);
//        floatingCube(frame,15f,0f,1f,16f,16f,15f);
//        floatingCube(frame,0f,15f,1f,1f,16f,15f);
//        floatingCube(frame,15f,15f,1f,16f,16f,15f);
//
//        floatingCube(frame,1f,1f,1f,15f,15f,15f);
//
//        frame.texture("side",modLoc("block/generator_side_A"));
//        frame.texture("particle",modLoc("block/generator_front"));
//
//
//    }
//
//    private void floatingCube(BlockModelBuilder builder,float fx,float fy,float fz,float tx,float ty,float tz){
//        builder.element()
//                .from(fx,fy,fz)
//                .to(tx,ty,tz)
//                .allFaces((direction, faceBuilder) -> faceBuilder.texture("#side"))
//                .end();
//    }
//
//    private void createGeneratorModel(Block block, BlockModelBuilder frame){
//        BlockModelBuilder singleOff = models().getBuilder("block/generator/singleoff")
//                .element().from(3,3,3).to(13,13,13).face(Direction.DOWN).texture("#single").end().end()
//                .texture("single",modLoc("block/generator_front"));
//        BlockModelBuilder singleOn = models().getBuilder("block/generator/singleon")
//                .element().from(3,3,3).to(13,13,13).face(Direction.DOWN).texture("#single").end().end()
//                .texture("single",modLoc("block/generator_front_on"));
//
//        MultiPartBlockStateBuilder bld =getMultipartBuilder(block);
//
//        bld.part().modelFile(frame).addModel();
//
//        BlockModelBuilder [] models = new BlockModelBuilder[]{singleOff,singleOn};
//        for (int i = 0; i < 2; i++){
//            boolean powered = i ==1;
//            bld.part().modelFile(models[i]).addModel().condition(BlockStateProperties.POWERED,powered);
//            bld.part().modelFile(models[i]).rotationX(180).addModel().condition(BlockStateProperties.POWERED, powered);
//            bld.part().modelFile(models[i]).rotationX(90).addModel().condition(BlockStateProperties.POWERED, powered);
//            bld.part().modelFile(models[i]).rotationX(270).addModel().condition(BlockStateProperties.POWERED, powered);
//            bld.part().modelFile(models[i]).rotationY(90).rotationX(90).addModel().condition(BlockStateProperties.POWERED, powered);
//            bld.part().modelFile(models[i]).rotationY(270).rotationX(90).addModel().condition(BlockStateProperties.POWERED, powered);
//        }
//
//    }

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
