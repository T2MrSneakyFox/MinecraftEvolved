package com.example.evolved.datagen;

import com.example.evolved.Evolved;
import com.example.evolved.Setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TutItemTags extends ItemTagsProvider {


    public TutItemTags(DataGenerator generator, BlockTagsProvider blocktags, ExistingFileHelper helper) {
        super(generator, blocktags, Evolved.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.ORES)
                .add(Registration.NICKEL_ORE_ITEM.get())
                .add(Registration.OBSIDIAN_ORE_ITEM.get())
                .add(Registration.ENDER_ORE_ITEM.get());
        tag(Tags.Items.INGOTS)
                .add(Registration.LITHIUM_INGOT.get())
                .add(Registration.COBALT_SHARD_ITEM.get())
                .add(Registration.NICKEL_INGOT.get());
        tag(Tags.Items.DUSTS)
                .add(Registration.COAL_DUST_ITEM.get())
                .add(Registration.COBALT_DUST_ITEM.get())
                .add(Registration.OBSIDIAN_DUST_ITEM.get())
        ;
        tag(Registration.EVOLVED_ITEMS)
                .add(Registration.WIRE_ITEM.get())
                .add(Registration.SALT_WATER_ITEM.get())
                .add(Registration.ELECTRICAL_CONDUIT_ITEM.get())
        ;
    }

    @Override
    public String getName() {return "evolved tags"; }
}
