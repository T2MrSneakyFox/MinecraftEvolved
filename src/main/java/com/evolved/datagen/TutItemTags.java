package com.evolved.datagen;

import com.evolved.mainEvolved;
import com.evolved.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TutItemTags extends ItemTagsProvider {


    public TutItemTags(DataGenerator generator, BlockTagsProvider blocktags, ExistingFileHelper helper) {
        super(generator, blocktags, mainEvolved.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.ORES)
                .add(Registration.NICKEL_ORE_ITEM.get())
                .add(Registration.OBSIDIAN_ORE_ITEM.get())
                .add(Registration.ENDER_ORE_ITEM.get());
        tag(Tags.Items.INGOTS)
                .add(Registration.COBALT_SHARD_ITEM.get())
                .add(Registration.NICKEL_INGOT.get());
        tag(Tags.Items.DUSTS)
                .add(Registration.COAL_DUST_ITEM.get())
                .add(Registration.COBALT_DUST_ITEM.get())
                .add(Registration.OBSIDIAN_DUST_ITEM.get())
                .add(Registration.LITHIUM_DUST_ITEM.get())
        ;
//        tag(Registration.EVOLVED_ITEMS)
//                .add(Registration.WIRE_ITEM.get())
//                .add(Registration.SALT_WATER_ITEM.get())
//                .add(Registration.ELECTRICAL_CONDUIT_ITEM.get())
//                .add(Registration.BUCKET_OF_SEA_WATER.get())
//        ;

        tag(Registration.TAG_NICKEL_ORE_ITEM)
                .add(Registration.NICKEL_ORE_ITEM.get())
        ;
        tag(Registration.TAG_LITHIUM_DUST_ITEM)
                .add(Registration.LITHIUM_DUST_ITEM.get())
        ;
        tag(Registration.TAG_LITHIUM_SHARD_ITEM)
                .add(Registration.LITHIUM_SHARD_ITEM.get())
        ;
        tag(Registration.MONEY)
                .add(Registration.ONE_COIN.get())
                .add(Registration.TWO_COIN.get())
                .add(Registration.FIVE_BUCKS.get())
                .add(Registration.TEN_BUCKS.get())
                .add(Registration.TWENTY_BUCKS.get())
                .add(Registration.FIFTY_BUCKS.get())
                .add(Registration.HUNDERD_BUCKS.get())
                .add(Registration.TWOHUNDERD_BUCKS.get())
        ;
    }

    @Override
    public String getName() {return "evolved tags"; }
}
