package com.evolved.datagen;

import com.evolved.mainEvolved;
import com.evolved.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TutBlockTags extends BlockTagsProvider {
    public TutBlockTags(DataGenerator generator, ExistingFileHelper helper){
        super(generator, mainEvolved.MODID, helper);
    }
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Registration.NICKEL_ORE_OVERWORLD.get())
                .add(Registration.OBSIDIAN_ORE_OVERWORLD.get())
                .add(Registration.ENDER_ORE_END.get())
                .add(Registration.GENERATOR.get())
        ;
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(Registration.NICKEL_ORE_OVERWORLD.get())

        ;
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Registration.GENERATOR.get())
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
        tag(Registration.TAG_NICKEL_ORE)
                .add(Registration.NICKEL_ORE_OVERWORLD.get())
        ;
        tag(Registration.TAG_ELECTRICAL_PILLAR)
                .add(Registration.ELECTRICAL_PILLAR.get());
    }
    @Override
    public String getName() {
        return "mainEvolved";
    }
}
