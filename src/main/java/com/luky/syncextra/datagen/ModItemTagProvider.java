package com.luky.syncextra.datagen;

import com.luky.syncextra.SyncExtra;
import com.luky.syncextra.custom.item.util.ModTags;
import com.luky.syncextra.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, SyncExtra.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.CLONEODITA_INGOT.get())
                .add(ModItems.CHISEL.get())
                .add(Items.COAL);
        tag(ItemTags.SWORDS)
                .add(ModItems.CLONEODITA_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.CLONEODITA_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.CLONEODITA_AXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.CLONEODITA_HOE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.CLONEODITA_SHOVEL.get());
    }
}
