package net.tomokp.craftegg.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.Giant;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomokp.craftegg.CraftEgg;

import static net.tomokp.craftegg.item.ModCreativeModeTabs.addToTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CraftEgg.MOD_ID);

    public static final RegistryObject<Item> GOLDEN_BEEF = addToTab(ITEMS.register("golden_beef",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(20)
                            .saturationMod(20f)
                            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 4), 1f)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 50), 1f)
                            .build()
                    )
            )));
    public static final RegistryObject<Item> DIAMOND_BEEF = addToTab(ITEMS.register("diamond_beef",
            () -> new Item(new Item.Properties())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
