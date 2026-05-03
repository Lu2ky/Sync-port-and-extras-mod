package com.luky.syncextra.registry;


import com.jcraft.jorbis.Block;
import com.luky.syncextra.SyncExtra;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems{
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(SyncExtra.MOD_ID);
    public static final DeferredItem<BlockItem> SYNC_CAPSULE_MODULE =
            ITEMS.registerSimpleBlockItem("sync_capsule_module",ModBlocks.SYNC_CAPSULE_MODULE);
    public static final DeferredItem<Item> SYNC_CORE =
            ITEMS.registerSimpleItem("sync_core",
                    new Item.Properties().stacksTo(16)
            );
    public static final DeferredItem<BlockItem> TEST_BLOCK =
            ITEMS.registerSimpleBlockItem("test_block",ModBlocks.TEST_BLOCK);
    public static final DeferredItem<BlockItem> CLONEODITA_ORE = ITEMS.registerSimpleBlockItem("cloneodita_ore",ModBlocks.CLONEODITA_ORE);
    public static final DeferredItem<Item> RAW_CLONEODITA = ITEMS.registerSimpleItem("raw_cloneodita", new Item.Properties().fireResistant());
    public static final DeferredItem<BlockItem> RAW_CLONEODITA_BLOCK =
            ITEMS.registerSimpleBlockItem("raw_cloneodita_block",ModBlocks.RAW_CLONEODITA_BLOCK);
    public static final DeferredItem<Item> CLONEODITA_INGOT = ITEMS.registerSimpleItem("cloneodita_ingot", new Item.Properties().fireResistant());
}