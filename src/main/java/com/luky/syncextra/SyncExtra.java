package com.luky.syncextra;

import com.luky.syncextra.client.ClientEvents;
import com.luky.syncextra.datagen.ModBlockLootTableProvider;
import com.luky.syncextra.registry.*;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

@Mod(SyncExtra.MOD_ID)
public class SyncExtra {

    public static final String MOD_ID = "syncextra";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SyncExtra(IEventBus modEventBus, ModContainer modContainer) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModMenus.MENUS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        if (FMLEnvironment.dist.isClient()) {
            modEventBus.addListener(ClientEvents::registerScreens);
        }

    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("SyncExtra cargado correctamente");
    }
}