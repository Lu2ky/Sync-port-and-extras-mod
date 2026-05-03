package com.luky.syncextra.custom.block.entity;

import com.luky.syncextra.custom.block.TestBlock;
import com.luky.syncextra.menu.TestMenu;
import com.luky.syncextra.registry.ModBlockEntities;
import com.luky.syncextra.registry.ModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TestBlockEntity extends RandomizableContainerBlockEntity {

    private NonNullList<ItemStack> items =
            NonNullList.withSize(63, ItemStack.EMPTY);

    public TestBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TEST_BLOCK_ENTITY.get(), pos, state);
    }

    public static void tick(Level level,
                            BlockPos pos,
                            BlockState state,
                            TestBlockEntity entity) {

        if (level.isClientSide) {
            return;
        }
        /*
        Test block para probar funcionalidades y experimentación con metodo tick de blockentity


        Convierte lo que este en el primer slot del inventario si y solo si es un sync_core a una nether_star, correspondencia
        1:1

        ItemStack stack = entity.items.get(0);
        if (!stack.isEmpty()) {
            if (stack.is(ModItems.SYNC_CORE.get())) {
                int count = stack.getCount();
                entity.items.set(0, new ItemStack(Items.NETHER_STAR, count));
                entity.setChanged();
            }
        }

        Convierte items instancias de cloneodita_ingot si y solo si estan en un rango de 2 bloques de test_block, correspondencia
        1:2 con netherite_ingot

        level.getEntitiesOfClass(ItemEntity.class,
                new AABB(pos).inflate(2.0)
        ).forEach(itemEntity -> {
            if (itemEntity.getItem().is(ModItems.CLONEODITA_INGOT.get())) {
                itemEntity.setItem(new ItemStack(
                        Items.NETHERITE_INGOT,
                        itemEntity.getItem().getCount() * 2
                ));
            }
        });

         */
    }

    @Override
    protected Component getDefaultName() {
        return Component.literal("Test Block");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    public int getContainerSize() {
        return 63;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        return true;
    }

    @Override
    public void loadAdditional(net.minecraft.nbt.CompoundTag tag,
                               net.minecraft.core.HolderLookup.Provider provider) {

        super.loadAdditional(tag, provider);

        items = NonNullList.withSize(
                getContainerSize(),
                ItemStack.EMPTY
        );

        ContainerHelper.loadAllItems(tag, items, provider);
    }

    @Override
    protected void saveAdditional(net.minecraft.nbt.CompoundTag tag,
                                  net.minecraft.core.HolderLookup.Provider provider) {

        super.saveAdditional(tag, provider);

        ContainerHelper.saveAllItems(tag, items, provider);
    }

    @Override
    protected AbstractContainerMenu createMenu(int id,
                                               Inventory inventory) {
        return new TestMenu(id, inventory, this);
    }
}