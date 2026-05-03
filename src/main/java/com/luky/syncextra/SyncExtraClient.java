package com.luky.syncextra;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = SyncExtra.MOD_ID, value = Dist.CLIENT)
public class SyncExtraClient {

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        SyncExtra.LOGGER.info("SyncExtra cliente inicializado");
    }
}