package com.example.evolved.datagen;

import com.example.evolved.Evolved;
import com.example.evolved.Setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Calendar;

public class TutBlockTags extends BlockTagsProvider {
    public TutBlockTags(DataGenerator generator, ExistingFileHelper helper){
        super(generator, Evolved.MODID, helper);
    }
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Registration.NICKEL_ORE_OVERWORLD.get())
                .add(Registration.OBSIDIAN_ORE_OVERWORLD.get())
                .add(Registration.ENDER_ORE_END.get())

        ;
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(Registration.NICKEL_ORE_OVERWORLD.get())

        ;
        tag(BlockTags.NEEDS_IRON_TOOL)

        ;

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Registration.OBSIDIAN_ORE_OVERWORLD.get())
                .add(Registration.ENDER_ORE_END.get())

        ;
        tag(Tags.Blocks.ORES)
                .add(Registration.NICKEL_ORE_OVERWORLD.get())
                .add(Registration.OBSIDIAN_ORE_OVERWORLD.get())
                .add(Registration.ENDER_ORE_END.get())

        ;
    }
    @Override
    public String getName() {
        return "Evolved";
    }
}
