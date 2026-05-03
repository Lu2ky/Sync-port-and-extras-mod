package com.luky.syncextra.block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class CapsuleBlock extends Block {
    public static final BooleanProperty FORMED = BooleanProperty.create("formed");
    public static final BooleanProperty TOP = BooleanProperty.create("top");
    public static final BooleanProperty MIDDLE = BooleanProperty.create("middle");
    public static final BooleanProperty BOTTOM = BooleanProperty.create("bottom");
    public CapsuleBlock(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any().setValue(FORMED, false));
    }
}
