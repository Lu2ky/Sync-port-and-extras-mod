package com.luky.syncextra.registry;

import com.luky.syncextra.SyncExtra;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems{
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(SyncExtra.MOD_ID);
    public static final DeferredItem<BlockItem> SYNC_CAPSULE =
            ITEMS.registerSimpleBlockItem("sync_capsule",ModBlocks.SYNC_CAPSULE);
    public static final DeferredItem<Item> SYNC_CORE =
            ITEMS.registerSimpleItem("sync_core",
                    new Item.Properties().stacksTo(16)
            );
}