package com.luky.syncextra.custom.block;

import com.luky.syncextra.custom.block.entity.TestBlockEntity;
import com.luky.syncextra.custom.item.util.ModTags;
import com.luky.syncextra.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.core.BlockPos;
import com.luky.syncextra.registry.ModItems;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.MenuProvider;
import com.luky.syncextra.registry.ModBlockEntities;

import java.util.List;
import java.util.Random;
import java.lang.reflect.Array;

public class TestBlock extends Block implements EntityBlock {



    public TestBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected InteractionResult useWithoutItem(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            BlockHitResult hitResult) {

        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (blockEntity instanceof TestBlockEntity testBlockEntity) {
                player.openMenu((MenuProvider) blockEntity,buf -> buf.writeBlockPos(pos));
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity){
        if(entity instanceof ItemEntity itemEntity){
            if(isValidItem(itemEntity.getItem())){
                itemEntity.setItem(new ItemStack(Items.NETHER_STAR, itemEntity.getItem().getCount()));
            }
        }
        super.stepOn(level,pos,state,entity);

    }

    private boolean isValidItem(ItemStack item) {

        return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TestBlockEntity(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level,
            BlockState state,
            BlockEntityType<T> type) {

        return type == ModBlockEntities.TEST_BLOCK_ENTITY.get()
                ? (lvl, pos, blockState, blockEntity) ->
                TestBlockEntity.tick(
                        lvl,
                        pos,
                        blockState,
                        (TestBlockEntity) blockEntity
                )
                : null;
    }
}
