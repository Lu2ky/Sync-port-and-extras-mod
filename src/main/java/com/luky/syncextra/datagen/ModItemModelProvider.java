package com.luky.syncextra.datagen;

import com.luky.syncextra.SyncExtra;
import com.luky.syncextra.registry.ModBlocks;
import com.luky.syncextra.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SyncExtra.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CLONEODITA_INGOT.get());
        //basicItem(ModItems.CHISEL.get());
        //basicItem(ModItems.RAW_CLONEODITA_BLOCK.get());
        //basicItem(ModItems.CLONEODITA_ORE.get());
        //basicItem(ModItems.SYNC_CORE.get());
        basicItem(ModItems.RAW_CLONEODITA.get());

        buttonItem(ModBlocks.RAW_CLONEODITA_BUTTON, ModBlocks.RAW_CLONEODITA_BLOCK);
        fenceItem(ModBlocks.RAW_CLONEODITA_FENCE, ModBlocks.RAW_CLONEODITA_BLOCK);
        wallItem(ModBlocks.RAW_CLONEODITA_WALL, ModBlocks.RAW_CLONEODITA_BLOCK);
    }
    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(SyncExtra.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(SyncExtra.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(SyncExtra.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }


}
