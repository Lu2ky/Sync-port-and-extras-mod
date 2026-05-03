package com.luky.syncextra.component;

import com.luky.syncextra.SyncExtra;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.xml.crypto.Data;
import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPOPONENT_TYPES =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, SyncExtra.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockPos>> COORDINATES = register("coordinates",
            builder -> builder.persistent(BlockPos.CODEC));

    private static <T>DeferredHolder<DataComponentType<?>,DataComponentType<T> > register(String name,
                                                                                          UnaryOperator<DataComponentType.Builder<T>> builderUnaryOperator){
    return DATA_COMPOPONENT_TYPES.register(name,() -> builderUnaryOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus){
        DATA_COMPOPONENT_TYPES.register(eventBus);
    }
}
