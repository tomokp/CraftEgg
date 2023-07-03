package net.tomokp.craftegg.block;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomokp.craftegg.CraftEgg;
import static net.tomokp.craftegg.item.ModCreativeModeTabs.addToTab;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CraftEgg.MOD_ID);

    public static final RegistryObject<Block> COMPRESSED_WOOL = BLOCKS.register("compressed_wool",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(6f)
            ));
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
