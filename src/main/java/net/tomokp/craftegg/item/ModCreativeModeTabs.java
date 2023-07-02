package net.tomokp.craftegg.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static net.tomokp.craftegg.CraftEgg.MOD_ID;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final List<Supplier<? extends ItemLike>> CRAFTEGG_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> CRAFTEGG_TAB = TABS.register("craftegg_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.craftegg_tab"))
                    .icon(ModItems.GOLDEN_BEEF.get()::getDefaultInstance)
                    .displayItems((displayParams, output) ->
                        CRAFTEGG_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
                    .build()
    );

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemlike) {
        CRAFTEGG_TAB_ITEMS.add(itemlike);
        return itemlike;
    }
//    public static CreativeModeTab TUTORIAL_TAB;
//    private static final boolean ENABLED = true;
//    private static final ResourceKey<CreativeModeTab> LOGS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(MOD_ID, "logs"));
//    public static void onCreativeModeTabRegister(RegisterEvent event) {
//        event.register(Registries.CREATIVE_MODE_TAB, helper -> {
//            helper.register(LOGS, CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.ACACIA_LOG))
//                    .title(Component.literal("Logs"))
//                    .build());
//    });
//}
}
