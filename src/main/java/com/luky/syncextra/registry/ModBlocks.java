package com.luky.syncextra.registry;

import com.luky.syncextra.SyncExtra;
import com.luky.syncextra.custom.block.CloneoditaLamp;
import com.luky.syncextra.custom.block.TestBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

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


    // CLONEODITA RAW NON BLOCKS
    public static final DeferredBlock<StairBlock> RAW_CLONEODITA_STAIRS = registerBlock("raw_cloneodita_stairs",
            () -> new StairBlock(ModBlocks.RAW_CLONEODITA_BLOCK.get().defaultBlockState(),BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> RAW_CLONEODITA_SLAB = registerBlock("raw_cloneodita_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));


    public static final DeferredBlock<PressurePlateBlock> RAW_CLONEODITA_PRESSURE_PLATE = registerBlock("raw_cloneodita_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON,BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<ButtonBlock> RAW_CLONEODITA_BUTTON = registerBlock("raw_cloneodita_button",
            () -> new ButtonBlock(BlockSetType.IRON,20,BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<FenceBlock> RAW_CLONEODITA_FENCE = registerBlock("raw_cloneodita_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<FenceGateBlock> RAW_CLONEODITA_FENCE_GATE = registerBlock("raw_cloneodita_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<WallBlock> RAW_CLONEODITA_WALL = registerBlock("raw_cloneodita_fence_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));


    public static final DeferredBlock<DoorBlock> RAW_CLONEODITA_DOOR = registerBlock("raw_cloneodita_door",
            () -> new DoorBlock(BlockSetType.IRON,BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<TrapDoorBlock> RAW_CLONEODITA_TRAPDOOR = registerBlock("raw_cloneodita_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON,BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    public static final DeferredBlock<Block> CLONEODITA_LAMP = registerBlock("cloneodita_lamp",() -> new CloneoditaLamp(BlockBehaviour.
            Properties.
            of().
            strength(2f).
            requiresCorrectToolForDrops().
            lightLevel(state -> state.getValue(CloneoditaLamp.CLICKED) ? 15 : 0)));

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}