package net.tomokp.craftegg.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomokp.craftegg.CraftEgg;
import net.tomokp.craftegg.item.custom.GoldenEggItem;

import static net.tomokp.craftegg.item.ModCreativeModeTabs.addToTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CraftEgg.MOD_ID);

    //cow
    public static final RegistryObject<Item> GOLDEN_STEAK = addToTab(ITEMS.register("golden_steak",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(20)
                            .saturationMod(20f)
                            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 1), 1f)
                            .build()
                    )
            )));
    public static final RegistryObject<Item> DIAMOND_STEAK = addToTab(ITEMS.register("diamond_steak",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(80)
                            .saturationMod(80f)
                            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 2), 1f)
                            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 4), 1f)
                            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 2), 1f)
                            .build()
                    ))));

    //chicken
    public static final RegistryObject<Item> GOLDEN_EGG = addToTab(ITEMS.register("golden_egg",
            () -> new GoldenEggItem(new Item.Properties()
            )));
    public static final RegistryObject<Item> DIAMOND_EGG = addToTab(ITEMS.register("diamond_egg",
            () -> new GoldenEggItem(new Item.Properties()
            )));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
