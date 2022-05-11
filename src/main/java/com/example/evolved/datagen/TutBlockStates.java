package com.example.evolved.datagen;

import com.example.evolved.Evolved;
import com.example.evolved.Setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TutBlockStates extends BlockStateProvider {
    public TutBlockStates(DataGenerator gen, ExistingFileHelper helper) {super(gen, Evolved.MODID, helper);}
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(Registration.Test_ORE_OVERWORLD.get());
        simpleBlock(Registration.Test_ORE_NETHER.get());
        simpleBlock(Registration.Test_ORE_END.get());
        simpleBlock(Registration.Test_ORE_DEEPSLATE.get());
    }
}
