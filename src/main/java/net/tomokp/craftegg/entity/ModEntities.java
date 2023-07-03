package net.tomokp.craftegg.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tomokp.craftegg.CraftEgg;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CraftEgg.MOD_ID);


    public static void register(IEventBus eventbus) {
        ENTITY_TYPES.register(eventbus);
    }
}
