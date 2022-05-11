package com.example.evolved.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class TutRecipes extends RecipeProvider {

    public TutRecipes(DataGenerator generatorIn){super(generatorIn);}

    protected void BuildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
    }
}


