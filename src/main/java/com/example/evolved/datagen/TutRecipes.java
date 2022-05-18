package com.example.evolved.datagen;

import com.example.evolved.Evolved;
import com.example.evolved.Setup.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class TutRecipes extends RecipeProvider {

    public TutRecipes(DataGenerator generatorIn){super(generatorIn);}

    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(Registration.GENERATOR.get())
                .pattern("mmm")
                .pattern("xzx")
                .pattern("mmm")
                .define('z',Registration.COBALT_DUST_ITEM.get())
                .define('x', Tags.Items.STONE)
                .define('m', Tags.Items.INGOTS_IRON)
                .group("evolved")
                .save(consumer);


    }
}


