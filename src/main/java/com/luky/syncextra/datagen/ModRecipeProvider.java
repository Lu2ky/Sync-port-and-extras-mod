package com.luky.syncextra.datagen;

import com.luky.syncextra.registry.ModBlocks;
import com.luky.syncextra.registry.ModItems;
import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> CLONEODITA_SMELTTABLES =List.of(ModItems.RAW_CLONEODITA,
                ModBlocks.CLONEODITA_ORE);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_CLONEODITA_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_CLONEODITA.get())
                .unlockedBy("has_cloneodita",has(ModItems.CLONEODITA_INGOT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_CLONEODITA, 9)
                .requires(ModBlocks.RAW_CLONEODITA_BLOCK)
                .unlockedBy("has_cloneodita", has(ModItems.CLONEODITA_INGOT)).save(recipeOutput);
        oreSmelting(recipeOutput, CLONEODITA_SMELTTABLES, RecipeCategory.MISC,ModItems.CLONEODITA_INGOT,0.25f,200,"cloneodita");
        oreBlasting(recipeOutput, CLONEODITA_SMELTTABLES, RecipeCategory.MISC,ModItems.CLONEODITA_INGOT,0.25f,100,"cloneodita");
        stairBuilder(ModBlocks.RAW_CLONEODITA_STAIRS.get(), Ingredient.of(ModBlocks.RAW_CLONEODITA_BLOCK)).group("cloneodita")
                .unlockedBy("has_cloneodita", has(ModItems.CLONEODITA_INGOT)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_CLONEODITA_SLAB.get(),ModBlocks.RAW_CLONEODITA_BLOCK.get());

        buttonBuilder(ModBlocks.RAW_CLONEODITA_BUTTON.get(), Ingredient.of(ModItems.RAW_CLONEODITA_BLOCK.get())).group("cloneodita")
                .unlockedBy("has_cloneodita", has(ModItems.CLONEODITA_INGOT.get())).save(recipeOutput);

        pressurePlate(recipeOutput, ModBlocks.RAW_CLONEODITA_PRESSURE_PLATE.get(), ModItems.RAW_CLONEODITA_BLOCK.get());

        fenceBuilder(ModBlocks.RAW_CLONEODITA_FENCE.get(), Ingredient.of(ModItems.RAW_CLONEODITA_BLOCK.get())).group("cloneodita")
                .unlockedBy("has_cloneodita", has(ModItems.CLONEODITA_INGOT.get())).save(recipeOutput);

        fenceGateBuilder(ModBlocks.RAW_CLONEODITA_FENCE_GATE.get(), Ingredient.of(ModItems.RAW_CLONEODITA_BLOCK.get())).group("cloneodita")
                .unlockedBy("has_cloneodita", has(ModItems.CLONEODITA_INGOT.get())).save(recipeOutput);

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_CLONEODITA_WALL.get(), ModItems.RAW_CLONEODITA_BLOCK.get());

        doorBuilder(ModBlocks.RAW_CLONEODITA_DOOR.get(), Ingredient.of(ModItems.RAW_CLONEODITA_BLOCK.get())).group("cloneodita")
                .unlockedBy("has_cloneodita", has(ModItems.CLONEODITA_INGOT.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.RAW_CLONEODITA_TRAPDOOR.get(), Ingredient.of(ModItems.RAW_CLONEODITA_BLOCK.get())).group("cloneodita")
                .unlockedBy("has_cloneodita", has(ModItems.CLONEODITA_INGOT.get())).save(recipeOutput);

    }
}
