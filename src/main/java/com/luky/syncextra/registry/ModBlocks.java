package com.luky.syncextra.registry;

import com.luky.syncextra.SyncExtra;
import com.luky.syncextra.block.TestBlock;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks{
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(SyncExtra.MOD_ID);

    public static final DeferredBlock<Block> SYNC_CAPSULE_MODULE =
            BLOCKS.registerSimpleBlock("sync_capsule_module",
                    BlockBehaviour.Properties.of()
                            .strength(3.0f,6.0f)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                            .requiresCorrectToolForDrops()

                    );
    public static final DeferredBlock<Block> TEST_BLOCK =
            BLOCKS.register(
                    "test_block",
                    () -> new TestBlock(
                            BlockBehaviour.Properties.of()
                                    .strength(2f)
                                    .requiresCorrectToolForDrops()
                    )
            );
    public static final DeferredBlock<Block> CLONEODITA_ORE =
            BLOCKS.registerSimpleBlock("cloneodita_ore",
                    BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                            .noOcclusion()
                            .sound(SoundType.HEAVY_CORE)


            );
    public static final DeferredBlock<Block> RAW_CLONEODITA_BLOCK =
            BLOCKS.registerSimpleBlock("raw_cloneodita_block",
                    BlockBehaviour.Properties.of()
                            .strength(1f)
                            .noOcclusion()
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERITE_BLOCK));
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}