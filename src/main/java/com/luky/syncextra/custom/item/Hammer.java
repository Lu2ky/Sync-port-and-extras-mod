package com.luky.syncextra.custom.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class Hammer extends DiggerItem {
    public Hammer(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }


    public static List<BlockPos> getAreatobeDestroyed(int range, BlockPos centerblock, ServerPlayer player){
        List<BlockPos> positionsToBeDestroyed = new ArrayList<>();
        BlockHitResult centerBlock = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER,ClipContext.Fluid.NONE,player));
        if(centerBlock.getType() == HitResult.Type.MISS){
            return positionsToBeDestroyed;
        }
        if(centerBlock.getDirection() == Direction.DOWN || centerBlock.getDirection() == Direction.UP){
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    positionsToBeDestroyed.add(new BlockPos(centerblock.getX() + x, centerblock.getY(), centerblock.getZ() + y));
                }
                
            }
        }
        if(centerBlock.getDirection() == Direction.NORTH || centerBlock.getDirection() == Direction.SOUTH){
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    positionsToBeDestroyed.add(new BlockPos(centerblock.getX() + x, centerblock.getY() + y, centerblock.getZ()));
                }

            }
        }
        if(centerBlock.getDirection() == Direction.EAST || centerBlock.getDirection() == Direction.WEST){
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    positionsToBeDestroyed.add(new BlockPos(centerblock.getX() , centerblock.getY() + y, centerblock.getZ() + x));
                }

            }
        }

        /*
            Esta sección de codigo lo que intenta hacer es listar los bloques a eliminar del item bajo un estandar que es el rango,
            digamos,
            [][][]
            [][][]
            [][][]
            donde el centro es el bloque que rompemos en primera instancia, con este metodo extraemos izquierda, derecha, arriba, abajo y diagonales incluyendo si se requiere la profundidad igualmente


         */

        return positionsToBeDestroyed;
    }

}
