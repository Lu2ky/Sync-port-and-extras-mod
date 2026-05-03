package com.luky.syncextra.registry;

import com.luky.syncextra.SyncExtra;
import com.luky.syncextra.menu.TestMenu;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;

import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenus {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, SyncExtra.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<TestMenu>>
            TEST_MENU = MENUS.register(
            "test_menu",
            () -> IMenuTypeExtension.create(TestMenu::new)
    );
}