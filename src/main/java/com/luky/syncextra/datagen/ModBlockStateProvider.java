package com.luky.syncextra.datagen;

import com.luky.syncextra.SyncExtra;
import com.luky.syncextra.custom.block.CloneoditaLamp;
import com.luky.syncextra.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SyncExtra.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //blockWithItem(ModBlocks.CLONEODITA_ORE);
        blockWithItem(ModBlocks.RAW_CLONEODITA_BLOCK);
        //blockWithItem(ModBlocks.TEST_BLOCK);
        addNonCloneoditaBlocks();
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(),cubeAll(deferredBlock.get()));
    }
    private void addNonCloneoditaBlocks(){
        ResourceLocation texture = blockTexture(ModBlocks.RAW_CLONEODITA_BLOCK.get());
        stairsBlock(ModBlocks.RAW_CLONEODITA_STAIRS.get(),texture);
        slabBlock(ModBlocks.RAW_CLONEODITA_SLAB.get(), texture, texture, texture, texture);
        buttonBlock(ModBlocks.RAW_CLONEODITA_BUTTON.get(),texture);
        pressurePlateBlock(ModBlocks.RAW_CLONEODITA_PRESSURE_PLATE.get(),texture);
        fenceBlock(ModBlocks.RAW_CLONEODITA_FENCE.get(),texture);
        fenceGateBlock(ModBlocks.RAW_CLONEODITA_FENCE_GATE.get(),texture);

        doorBlockWithRenderType(ModBlocks.RAW_CLONEODITA_DOOR.get(),modLoc("block/raw_cloneodita_door_bottom"), modLoc("block/raw_cloneodita_door_top"),"cutout");
        trapdoorBlockWithRenderType(ModBlocks.RAW_CLONEODITA_TRAPDOOR.get(),modLoc("block/raw_cloneodita_trapdoor"), true,"cutout");
        wallBlock(ModBlocks.RAW_CLONEODITA_WALL.get(),texture);
        blockItem(ModBlocks.RAW_CLONEODITA_STAIRS);
        blockItem(ModBlocks.RAW_CLONEODITA_SLAB);
        blockItem(ModBlocks.RAW_CLONEODITA_PRESSURE_PLATE);
        blockItem(ModBlocks.RAW_CLONEODITA_FENCE_GATE);
        blockItem(ModBlocks.RAW_CLONEODITA_TRAPDOOR, "_bottom");
        customLamp();


    }
    private void customLamp() {
        getVariantBuilder(ModBlocks.CLONEODITA_LAMP.get()).forAllStates(state -> {
            if(state.getValue(CloneoditaLamp.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("cloneodita_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(SyncExtra.MOD_ID, "block/" + "cloneodita_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("cloneodita_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(SyncExtra.MOD_ID, "block/" + "cloneodita_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.CLONEODITA_LAMP.get(), models().cubeAll("cloneodita_lamp_on",
                ResourceLocation.fromNamespaceAndPath(SyncExtra.MOD_ID, "block/" + "cloneodita_lamp_on")));
    }
    private void blockItem(DeferredBlock<?> deferredBlock){
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("syncextra:block/"+deferredBlock.getId().getPath()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock, String appendix){
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("syncextra:block/"+deferredBlock.getId().getPath() + appendix));
    }
}
