package com.example.evolved.datagen;

import com.example.evolved.Evolved;
import com.example.evolved.Setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;

import javax.annotation.Nullable;

import static com.example.evolved.Setup.ModSetup.TAB_NAME;

public class TutLanguageProvider extends LanguageProvider {
    public TutLanguageProvider(DataGenerator gen, String locale) {
        super(gen, Evolved.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemgroup." + TAB_NAME, "Tutorial");

        add(Registration.Test_ORE_OVERWORLD_ITEM.get(), "Test ore");
        add(Registration.COBALT_ITEM.get(), "Cobalt");
        add(Registration.WIRE_ITEM.get(), "Copper wire");
        add(Registration.LITHIUM_ITEM.get(), "Lithium");
        add(Registration.OBSIDIAN_DUST_ITEM.get(), "Obsidian dust");
        add(Registration.SALT_WATER_ITEM.get(), "Salt water");
        add(Registration.ELECTRICAL_CONDUIT_ITEM.get(), "Electrical conduit");
        add(Registration.NICKEL_ORE_ITEM.get(), "Nickel ore");
        add(Registration.COPPER_ORE_ITEM.get(), "Copper ore");
        add(Registration.OBSIDIAN_ORE_ITEM.get(), "Obsidian Ore");
        add(Registration.ENDER_ORE_ITEM.get(), "Ender Ore");
    }
}
