package com.luky.syncextra.menu;

import com.luky.syncextra.block.entity.TestBlockEntity;
import com.luky.syncextra.registry.ModMenus;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.block.entity.BlockEntity;

public class TestMenu extends AbstractContainerMenu {

    private final Container container;

    public TestMenu(int id,
                    Inventory playerInventory,
                    FriendlyByteBuf buf) {

        this(
                id,
                playerInventory,
                getContainer(playerInventory, buf)
        );
    }

    public TestMenu(int id,
                    Inventory playerInventory,
                    Container container) {

        super(ModMenus.TEST_MENU.get(), id);

        this.container = container;

        for (int row = 0; row < 7; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(
                        container,
                        col + row * 9,   // índice
                        8 + col * 18,    // x
                        18 + row * 18    // y
                ));
            }
        }


        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {

                this.addSlot(new Slot(
                        playerInventory,
                        col + row * 9 + 9,
                        8 + col * 18,
                        160 + row * 18
                ));
            }
        }

        for (int col = 0; col < 9; ++col) {

            this.addSlot(new Slot(
                    playerInventory,
                    col,
                    8 + col * 18,
                    218
            ));
        }
    }

    private static Container getContainer(Inventory inventory,
                                          FriendlyByteBuf buf) {

        BlockPos pos = buf.readBlockPos();

        BlockEntity blockEntity =
                inventory.player.level().getBlockEntity(pos);

        if (blockEntity instanceof TestBlockEntity testBlockEntity) {
            return testBlockEntity;
        }

        return new SimpleContainer(1);
    }

    @Override
    public boolean stillValid(Player player) {
        return container.stillValid(player);
    }
    @Override
    public net.minecraft.world.item.ItemStack quickMoveStack(
            Player player,
            int index) {

        return net.minecraft.world.item.ItemStack.EMPTY;
    }
}