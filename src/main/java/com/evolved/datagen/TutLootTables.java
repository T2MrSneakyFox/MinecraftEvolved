package com.evolved.datagen;


import com.evolved.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;


public class TutLootTables extends BaseLootTableProvider implements DataProvider {

    public TutLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(Registration.GENERATOR.get(), createStandardTable("generator",Registration.GENERATOR.get(),Registration.GENERATOR_BE.get()));
        lootTables.put(Registration.NICKEL_ORE_OVERWORLD.get(), createSilkTouchTable("nickel_ore_overworld", Registration.NICKEL_ORE_OVERWORLD.get(), Registration.NICKEL_ORE_ITEM.get(), 1, 3));
    }



}
