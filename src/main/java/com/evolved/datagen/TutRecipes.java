package com.evolved.datagen;

import com.evolved.setup.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class TutRecipes extends RecipeProvider {

    public TutRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(Registration.GENERATOR.get())
                .pattern("mmm")
                .pattern("xzx")
                .pattern("mmm")
                .define('z', Registration.COBALT_DUST_ITEM.get())
                .define('x', Tags.Items.STONE)
                .define('m', Tags.Items.INGOTS_IRON)
                .group("evolved")
                .unlockedBy("cool_generator", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.COBALT_DUST_ITEM.get()))
                .save(consumer);
    }
}


