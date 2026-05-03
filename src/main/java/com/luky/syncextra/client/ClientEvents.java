package com.luky.syncextra.client;

import com.luky.syncextra.registry.ModMenus;
import com.luky.syncextra.screen.TestScreen;

import net.minecraft.client.gui.screens.MenuScreens;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

public class ClientEvents {

    public static void registerScreens(RegisterMenuScreensEvent event) {

        event.register(
                ModMenus.TEST_MENU.get(),
                TestScreen::new
        );
    }
}