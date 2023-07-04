package net.tomokp.craftegg.block;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomokp.craftegg.CraftEgg;
import net.tomokp.craftegg.block.custom.CompressedWool;
import net.tomokp.craftegg.block.custom.WovenCompressedWool;
import net.tomokp.craftegg.item.custom.DiamondEggItem;

import static net.tomokp.craftegg.item.ModCreativeModeTabs.addToTab;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CraftEgg.MOD_ID);

//    public static final RegistryObject<Block> COMPRESSED_WOOL = BLOCKS.register("compressed_wool",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(6f)
//            ));
    public static final RegistryObject<Block> COMPRESSED_WOOL = BLOCKS.register("compressed_wool",
            () -> new CompressedWool(BlockBehaviour.Properties.of()
            ));

    public static final RegistryObject<Block> WOVEN_COMPRESSED_WOOL = BLOCKS.register("woven_compressed_wool",
            () -> new WovenCompressedWool(BlockBehaviour.Properties.of()
            ));
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
