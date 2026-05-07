package com.luky.syncextra.event;

import com.luky.syncextra.custom.item.Hammer;
import com.luky.syncextra.custom.item.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import com.luky.syncextra.SyncExtra;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = SyncExtra.MOD_ID)

public class ModEvents {
    private static final Set<BlockPos> BLOCK_TO_DESTROY = new HashSet<>();
    @SubscribeEvent
    public static void ohHammerUsage(BlockEvent.BreakEvent event){
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof Hammer hammer && player instanceof ServerPlayer serverPlayer && !player.isShiftKeyDown()){
            BlockPos blockPosinicial = event.getPos();
            if(BLOCK_TO_DESTROY.contains(blockPosinicial)){
                return;
            }
            for (BlockPos pos : hammer.getAreatobeDestroyed(1,blockPosinicial,serverPlayer)){
                if(pos == blockPosinicial || !hammer.isCorrectToolForDrops(mainHandItem,event.getLevel().getBlockState(pos))){
                    continue;
                }
                BLOCK_TO_DESTROY.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                BLOCK_TO_DESTROY.remove(pos);
            }
        }
    }

}
