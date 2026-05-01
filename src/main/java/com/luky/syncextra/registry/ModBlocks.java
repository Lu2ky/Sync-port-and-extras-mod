package com.luky.syncextra.registry;

import com.luky.syncextra.SyncExtra;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks{
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(SyncExtra.MOD_ID);

    public static final DeferredBlock<Block> SYNC_CAPSULE =
            BLOCKS.registerSimpleBlock("sync_capsule",
                    BlockBehaviour.Properties.of()
                            .strength(3.0f,6.0f)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                            .requiresCorrectToolForDrops()

                    );

}