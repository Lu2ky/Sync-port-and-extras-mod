package com.luky.syncextra.custom.item;

import com.luky.syncextra.custom.item.util.ModTags;
import com.luky.syncextra.registry.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier CLONEODITA = new SimpleTier(ModTags.Blocks.NEEDS_CLONEODITA_TOOL,
            5000,4f,3f,67,() -> Ingredient.of(ModItems.CLONEODITA_INGOT));
}
