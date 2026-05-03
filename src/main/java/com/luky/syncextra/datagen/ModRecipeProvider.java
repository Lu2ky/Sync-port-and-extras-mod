package com.luky.syncextra.datagen;

import com.luky.syncextra.registry.ModBlocks;
import com.luky.syncextra.registry.ModItems;
import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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
    }
}
