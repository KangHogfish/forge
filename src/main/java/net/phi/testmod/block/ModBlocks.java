package net.phi.testmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.phi.testmod.TestMod;
import net.phi.testmod.item.Moditems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);
    public static final RegistryObject<Block> COIN_BLOCK = registerBlock("coin_block",
            () -> new Block(BlockBehaviour
                    .Properties.copy(Blocks.IRON_BLOCK)
                    .sound(SoundType.AMETHYST)
                    .lightLevel(value -> 15)
            ));
    public static final RegistryObject<Block> RAW_COIN_BLOCK = registerBlock("raw_coin_block",
            () -> new Block(BlockBehaviour
                    .Properties.copy(Blocks.IRON_BLOCK)
                    .sound(SoundType.SAND)
            ));
    public static final RegistryObject<Block> RAW_POLISHING_STATION = registerBlock("raw_polishing_station",
            () -> new Block(BlockBehaviour
                    .Properties.copy(Blocks.IRON_BLOCK)
                    .sound(SoundType.SAND)
                    .noOcclusion()
            ));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
