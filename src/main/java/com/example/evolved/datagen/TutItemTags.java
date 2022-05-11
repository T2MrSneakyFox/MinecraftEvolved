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
                .add(Registration.Test_ORE_OVERWORLD_ITEM.get())
                .add(Registration.Test_ORE_NETHER_ITEM.get())
                .add(Registration.Test_ORE_END_ITEM.get())
                .add(Registration.Test_ORE_DEEPSLATE_ITEM.get());
    }

    @Override
    public String getName() {return "Tutorial tags"; }
}
