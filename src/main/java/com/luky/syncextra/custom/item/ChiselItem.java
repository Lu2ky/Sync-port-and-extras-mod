package com.luky.syncextra.custom.item;


import com.luky.syncextra.component.ModDataComponents;
import com.luky.syncextra.registry.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.DIAMOND_BLOCK, Blocks.NETHERITE_BLOCK,
                    Blocks.NETHERITE_BLOCK, ModBlocks.RAW_CLONEODITA_BLOCK.get()
            );


    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        if(CHISEL_MAP.containsKey(clickedBlock)){
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());
                context.getItemInHand().hurtAndBreak(1,((ServerLevel) level), context.getPlayer(),
                        item -> {
                            assert context.getPlayer() != null;
                            context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND);
                        });
                level.playSound(null,context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
                context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
            }
        }
        else{
            if(context.getItemInHand().get(ModDataComponents.COORDINATES) != null){
                BlockPos coords = context.getItemInHand().get(ModDataComponents.COORDINATES);
                if(coords != null){
                    context.getPlayer().setPos(coords.getX(), coords.getY() + 1, coords.getZ());
                    level.playSound(context.getPlayer(), context.getClickedPos(), SoundEvents.PORTAL_TRAVEL,SoundSource.AMBIENT);
                }
            }

        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.syncextra.chisel.tooltip.shift"));
        }else{
            tooltipComponents.add(Component.translatable("tooltip.syncextra.chisel.tooltip.noshift"));
        }
        if(stack.get(ModDataComponents.COORDINATES) != null){
            tooltipComponents.add(Component.literal("El ultimo bloque cambiado fue: " + stack.get(ModDataComponents.COORDINATES)));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
