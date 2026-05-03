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
                    .icon(() -> ModItems.CLONEODITA_INGOT.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.SYNC_CAPSULE_MODULE);
                        output.accept(ModItems.SYNC_CORE);
                        output.accept(ModItems.TEST_BLOCK);
                        output.accept(ModItems.CLONEODITA_ORE);
                        output.accept(ModItems.RAW_CLONEODITA);
                        output.accept(ModItems.RAW_CLONEODITA_BLOCK);
                        output.accept(ModItems.CLONEODITA_INGOT);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModBlocks.RAW_CLONEODITA_FENCE_GATE);
                        output.accept(ModBlocks.RAW_CLONEODITA_BUTTON);
                        output.accept(ModBlocks.RAW_CLONEODITA_DOOR);
                        output.accept(ModBlocks.RAW_CLONEODITA_SLAB);
                        output.accept(ModBlocks.RAW_CLONEODITA_WALL);
                        output.accept(ModBlocks.RAW_CLONEODITA_TRAPDOOR);
                        output.accept(ModBlocks.RAW_CLONEODITA_STAIRS);
                        output.accept(ModBlocks.RAW_CLONEODITA_PRESSURE_PLATE);
                        output.accept(ModBlocks.RAW_CLONEODITA_FENCE);


                    })
                    .build()
            );
}