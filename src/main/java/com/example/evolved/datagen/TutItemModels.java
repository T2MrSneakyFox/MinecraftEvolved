package com.example.evolved.datagen;

import com.example.evolved.Evolved;
import com.example.evolved.Setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TutItemModels extends ItemModelProvider {

    public TutItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper){
        super(generator, Evolved.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(Registration.Test_ORE_OVERWORLD_ITEM.get().getRegistryName().getPath(), modLoc("block/test_ore_overworld"));
        withExistingParent(Registration.Test_ORE_NETHER_ITEM.get().getRegistryName().getPath(), modLoc("block/test_ore_nether"));
        withExistingParent(Registration.Test_ORE_END_ITEM.get().getRegistryName().getPath(), modLoc("block/test_ore_end"));
        withExistingParent(Registration.Test_ORE_DEEPSLATE_ITEM.get().getRegistryName().getPath(), modLoc("block/test_ore_deepslate"));

    }
}
