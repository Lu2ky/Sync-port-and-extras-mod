package com.luky.syncextra.datagen;

import com.luky.syncextra.SyncExtra;
import com.luky.syncextra.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
        basicItem(ModItems.SYNC_CORE.get());
    }



}
