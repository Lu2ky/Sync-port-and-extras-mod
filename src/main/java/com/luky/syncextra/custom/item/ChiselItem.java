package com.luky.syncextra.custom.item;


import com.luky.syncextra.component.ModDataComponents;
import com.luky.syncextra.registry.ModBlocks;
import com.luky.syncextra.registry.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.entity.ChunkEntities;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

import static net.minecraft.world.entity.EntityType.CHICKEN;
import static net.minecraft.world.entity.EntityType.COW;

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
        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());
                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> {
                            if (context.getPlayer() != null) {
                                context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND);
                                level.playSound(null, context.getClickedPos(), SoundEvents.GLASS_BREAK, SoundSource.BLOCKS);
                            }
                        });
                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
                context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
            }
        }/*
        else{
            if(context.getItemInHand().get(ModDataComponents.COORDINATES) != null){
                BlockPos coords = context.getItemInHand().get(ModDataComponents.COORDINATES);
                if(coords != null){
                    if(context.getPlayer() != null){
                        context.getPlayer().setPos(coords.getX(), coords.getY() + 1, coords.getZ());
                        if(!level.isClientSide()){
                            context.getItemInHand().hurtAndBreak(1,((ServerLevel) level), context.getPlayer(),
                                    item -> {
                                        assert context.getPlayer() != null;
                                        context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND);
                                        level.playSound(null,context.getClickedPos(), SoundEvents.GLASS_BREAK, SoundSource.BLOCKS);
                                    });
                        }
                        level.playSound(context.getPlayer(), context.getClickedPos(), SoundEvents.PORTAL_TRAVEL,SoundSource.AMBIENT);
                    }
                }
            }


        }
        */

        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        Level level = player.level();
        if(interactionTarget instanceof Zombie){
            Zombie zombie = (Zombie) interactionTarget;
            if(zombie.isBaby() && !zombie.isPassenger()){
                Chicken chicken = new Chicken(EntityType.CHICKEN, level);
                chicken.moveTo(zombie.getX(),zombie.getY(),zombie.getZ());
                level.addFreshEntity(chicken);
                zombie.startRiding(chicken);
            }
            zombie.setBaby(true);
            boolean isABaby = zombie.isBaby();
            level.playSound(player, interactionTarget.blockPosition(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS);
        }
        if (interactionTarget instanceof Animal ) {
            ((Animal) interactionTarget).setBaby(true);
            level.playSound(player, interactionTarget.blockPosition(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS);
        }
        if (interactionTarget instanceof Villager) {
            ((Villager) interactionTarget).setBaby(true);
            level.playSound(player, interactionTarget.blockPosition(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS);
        }

        return super.interactLivingEntity(stack, player, interactionTarget, usedHand);
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

