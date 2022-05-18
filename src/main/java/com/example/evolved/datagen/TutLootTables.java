package com.example.evolved.datagen;


import com.example.evolved.Setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TutLootTables extends com.example.evolved.datagen.BaseLootTableProvider implements DataProvider {

    public TutLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(Registration.GENERATOR.get(), createStandardTable("generator",Registration.GENERATOR.get(),Registration.GENERATOR_BE.get()));
    }



}
