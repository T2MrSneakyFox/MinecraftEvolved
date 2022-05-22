package com.evolved.datagen;

import com.evolved.setup.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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


        ShapedRecipeBuilder.shaped(Registration.BUCKET_OF_SALT_WATER.get())
                .pattern("S")
                .pattern("B")
                .define('S', Registration.SEA_SALT_ITEM.get())
                .define('B', Items.WATER_BUCKET)
                .group("evolved")
                .unlockedBy("sea_salt_item", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SEA_SALT_ITEM.get()))
                .save(consumer);
                ;

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.TAG_NICKEL_ORE_ITEM),
                Registration.NICKEL_INGOT.get(), 1.0f, 100)
                .unlockedBy("has_ore", has(Registration.TAG_NICKEL_ORE_ITEM))
                .save(consumer, "nickel_ingot1");
    }

}


