package com.evolved.datagen;

import com.evolved.mainEvolved;
import com.evolved.setup.ModSetup;
import com.evolved.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class TutLanguageProvider extends LanguageProvider {
    public TutLanguageProvider(DataGenerator gen, String locale) {
        super(gen, mainEvolved.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("item group." + ModSetup.TAB_NAME, "mainEvolved");
        //items
        add(Registration.SEA_SALT_ITEM.get(), "Salt water");
        add(Registration.ELECTRICAL_CONDUIT_ITEM.get(), "Electrical conduit");
        add(Registration.WIRE_ITEM.get(), "Copper wire");
        add(Registration.BUCKET_OF_SALT_WATER.get(), "Bucket of Saltwater");
        //items/ores
        add(Registration.OBSIDIAN_ORE_ITEM.get(), "Obsidian Ore");
        add(Registration.NICKEL_ORE_ITEM.get(), "Nickel ore");
        add(Registration.ENDER_ORE_ITEM.get(), "Ender Ore");
        //items/ingots
        add(Registration.COBALT_SHARD_ITEM.get(), "Cobalt shard");
        add(Registration.LITHIUM_INGOT.get(), "Lithium ingot");
        add(Registration.NICKEL_INGOT.get(), "Nickel ingot");
        add(Registration.OBSIDIAN_INGOT_ITEM.get(), "Obsidian ingot");
        //items/dust
        add(Registration.OBSIDIAN_DUST_ITEM.get(), "Obsidian dust");
        add(Registration.COAL_DUST_ITEM.get(), "Coal dust");
        add(Registration.COBALT_DUST_ITEM.get(), "Cobalt dust");
        //items/money
        add(Registration.ONE_COIN.get(), "$1" );
        add(Registration.TWO_COIN.get(), "$2" );
        add(Registration.FIVE_BUCKS.get(), "$5" );
        add(Registration.TEN_BUCKS.get(), "$10" );
        add(Registration.TWENTY_BUCKS.get(), "$20" );
        add(Registration.FIFTY_BUCKS.get(), "$50" );
        add(Registration.HUNDERD_BUCKS.get(), "$100" );
        add(Registration.TWOHUNDERD_BUCKS.get(), "$200" );
        //generator
        add(Registration.GENERATOR.get(),"Power Generator");
    }
}
