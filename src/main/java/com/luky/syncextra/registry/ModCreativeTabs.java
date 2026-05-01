package com.luky.syncextra.registry;

// imports acá
import com.luky.syncextra.registry.ModItems;
import com.luky.syncextra.SyncExtra;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SyncExtra.MOD_ID);
    // completá

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SYNC_TAB =
            TABS.register("sync_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.syncextra"))
                    .icon(() -> Items.GLASS_PANE.getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.SYNC_CAPSULE);
                        output.accept(ModItems.SYNC_CORE);
                    })
                    .build()
            );
}