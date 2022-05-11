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
        add(Registration.Test_ORE_NETHER_ITEM.get(), "Test ore");
        add(Registration.Test_ORE_END.get(), "Test ore");
        add(Registration.Test_ORE_DEEPSLATE_ITEM.get(), "Test ore");
    }
}
