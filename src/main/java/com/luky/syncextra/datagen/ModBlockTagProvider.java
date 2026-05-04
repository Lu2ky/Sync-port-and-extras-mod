package com.luky.syncextra.datagen;

import com.luky.syncextra.SyncExtra;
import com.luky.syncextra.custom.item.util.ModTags;
import com.luky.syncextra.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SyncExtra.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RAW_CLONEODITA_BLOCK.get())
                .add(ModBlocks.CLONEODITA_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_CLONEODITA_BLOCK.get())
                .add(ModBlocks.CLONEODITA_ORE.get());
        tag(BlockTags.FENCES).add(ModBlocks.RAW_CLONEODITA_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.RAW_CLONEODITA_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.RAW_CLONEODITA_WALL.get());
        tag(ModTags.Blocks.NEEDS_CLONEODITA_TOOL)
                .add(ModBlocks.RAW_CLONEODITA_BLOCK.get())
                .add(ModBlocks.TEST_BLOCK.get());
        tag(ModTags.Blocks.INCORRECT_FOR_CLONEODITA_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_CLONEODITA_TOOL);
    }
}
