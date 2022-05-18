package com.evolved.datagen;

import com.evolved.mainEvolved;
import com.evolved.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TutItemModels extends ItemModelProvider {

    public TutItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper){
        super(generator, mainEvolved.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // items/ores
        withExistingParent(Registration.NICKEL_ORE_ITEM.get().getRegistryName().getPath(), modLoc("block/nickel_ore_overworld"));

        // items/dusts
        singleTexture(Registration.COBALT_DUST_ITEM.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/cobalt_dust_item"));
        singleTexture(Registration.COAL_DUST_ITEM.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/coal_dust_item"));
        singleTexture(Registration.OBSIDIAN_DUST_ITEM.get().getRegistryName().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/obsidian_dust_item"));

        // items/ingots
        singleTexture(Registration.NICKEL_INGOT.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/nickel_ingot_item"));
        singleTexture(Registration.OBSIDIAN_INGOT_ITEM.get().getRegistryName().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/obsidian_ingot_item"));

        // items/shards
        singleTexture(Registration.COBALT_SHARD_ITEM.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/cobalt_shard_item"));
        // items/money
        singleTexture(Registration.ONE_COIN.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/1_coin"));
        singleTexture(Registration.TWO_COIN.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/2_coin"));

        singleTexture(Registration.FIVE_BUCKS.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/5_bucks"));
        singleTexture(Registration.TEN_BUCKS.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/10_bucks"));
        singleTexture(Registration.TWENTY_BUCKS.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/20_bucks"));
        singleTexture(Registration.FIFTY_BUCKS.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/50_bucks"));
        singleTexture(Registration.HUNDERD_BUCKS.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/100_bucks"));
        singleTexture(Registration.TWOHUNDERD_BUCKS.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/200_bucks"));
        //generator/item
        singleTexture(Registration.GENERATOR_ITEM.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/generator_front"));

        //items
        singleTexture(Registration.SALT_WATER_ITEM.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/sea_salt_item"));
        singleTexture(Registration.BUCKET_OF_SEA_WATER.get().getRegistryName().getPath(),mcLoc("item/generated"), "layer0", modLoc("item/bucket_of_sea_water"));



    }
}
