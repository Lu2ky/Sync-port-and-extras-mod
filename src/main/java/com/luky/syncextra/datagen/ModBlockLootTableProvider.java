package com.luky.syncextra.datagen;

import com.luky.syncextra.registry.ModBlocks;
import com.luky.syncextra.registry.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.fml.common.Mod;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.RAW_CLONEODITA_BLOCK.get());
        dropSelf(ModBlocks.TEST_BLOCK.get());
        dropSelf(ModBlocks.SYNC_CAPSULE_MODULE.get());
        addNonCloneoditaBlocks();

        /*
        Metodo default para LootTableProvider (ver clase para ver variedad)

        add(ModBlocks.CLONEODITA_ORE.get(),
                block -> createOreDrop(ModBlocks.CLONEODITA_ORE.get(), ModItems.RAW_CLONEODITA.get()));

         */
        add(ModBlocks.CLONEODITA_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.CLONEODITA_ORE.get(),ModItems.RAW_CLONEODITA.get(),2,10));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops){
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops,maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
    private void addNonCloneoditaBlocks(){
        dropSelf(ModBlocks.RAW_CLONEODITA_BUTTON.get());

        dropSelf(ModBlocks.RAW_CLONEODITA_FENCE_GATE.get());

        dropSelf(ModBlocks.RAW_CLONEODITA_FENCE.get());

        add(ModBlocks.RAW_CLONEODITA_DOOR.get(), block -> createDoorTable(ModBlocks.RAW_CLONEODITA_DOOR.get()));

        add(ModBlocks.RAW_CLONEODITA_SLAB.get(), block-> createSlabItemTable(ModBlocks.RAW_CLONEODITA_SLAB.get()));

        dropSelf(ModBlocks.RAW_CLONEODITA_WALL.get());

        dropSelf(ModBlocks.RAW_CLONEODITA_STAIRS.get());

        dropSelf(ModBlocks.RAW_CLONEODITA_PRESSURE_PLATE.get());

        dropSelf(ModBlocks.RAW_CLONEODITA_TRAPDOOR.get());
    }
}
