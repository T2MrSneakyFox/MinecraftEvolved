package com.example.evolved.datagen;

import com.example.evolved.Evolved;
import com.example.evolved.Setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TutBlockTags extends BlockTagsProvider {
    public TutBlockTags(DataGenerator generator, ExistingFileHelper helper){
        super(generator, Evolved.MODID, helper);
    }
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Registration.Test_ORE_OVERWORLD.get())
                .add(Registration.Test_ORE_NETHER.get())
                .add(Registration.Test_ORE_END.get())
                .add(Registration.Test_ORE_DEEPSLATE.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Registration.Test_ORE_OVERWORLD.get())
                .add(Registration.Test_ORE_NETHER.get())
                .add(Registration.Test_ORE_END.get())
                .add(Registration.Test_ORE_DEEPSLATE.get());
        tag(Tags.Blocks.ORES)
                .add(Registration.Test_ORE_OVERWORLD.get())
                .add(Registration.Test_ORE_NETHER.get())
                .add(Registration.Test_ORE_END.get())
                .add(Registration.Test_ORE_DEEPSLATE.get());
    }

    @Override
    public String getName() {
        return "Test ore tutorial tag";
    }
}
