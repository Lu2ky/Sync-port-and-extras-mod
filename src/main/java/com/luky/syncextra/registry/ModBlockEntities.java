package com.luky.syncextra.registry;

import com.luky.syncextra.SyncExtra;
import com.luky.syncextra.block.entity.TestBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(
                    net.minecraft.core.registries.Registries.BLOCK_ENTITY_TYPE,
                    SyncExtra.MOD_ID
            );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TestBlockEntity>>
            TEST_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            "test_block_entity",

            () -> BlockEntityType.Builder.of(
                    TestBlockEntity::new,
                    ModBlocks.TEST_BLOCK.get()
            ).build(null)
    );
}