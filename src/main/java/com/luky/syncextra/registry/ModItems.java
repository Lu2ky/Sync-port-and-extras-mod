package com.luky.syncextra.registry;


import com.jcraft.jorbis.Block;
import com.luky.syncextra.SyncExtra;
import com.luky.syncextra.custom.item.ChiselItem;
import com.luky.syncextra.custom.item.ModToolTiers;
import net.minecraft.world.item.*;
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
    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel", () -> new ChiselItem(new Item.Properties().fireResistant().durability(10)));


    public static final DeferredItem<SwordItem>  CLONEODITA_SWORD = ITEMS.register("cloneodita_sword",
            () -> new SwordItem(ModToolTiers.CLONEODITA, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.CLONEODITA,15,-2.4f))));

    public static final DeferredItem<PickaxeItem>  CLONEODITA_PICKAXE = ITEMS.register("cloneodita_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CLONEODITA, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CLONEODITA,9F,-2.8f))));

    public static final DeferredItem<AxeItem>  CLONEODITA_AXE = ITEMS.register("cloneodita_axe",
            () -> new AxeItem(ModToolTiers.CLONEODITA, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.CLONEODITA,20,-3.2f))));

    public static final DeferredItem<ShovelItem>  CLONEODITA_SHOVEL = ITEMS.register("cloneodita_shovel",
            () -> new ShovelItem(ModToolTiers.CLONEODITA, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.CLONEODITA,10F,-3.0f))));

    public static final DeferredItem<HoeItem>  CLONEODITA_HOE = ITEMS.register("cloneodita_hoe",
            () -> new HoeItem(ModToolTiers.CLONEODITA, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.CLONEODITA,34F,-3.0f))));
}