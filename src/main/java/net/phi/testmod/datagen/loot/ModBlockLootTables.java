package net.phi.testmod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.phi.testmod.block.ModBlocks;
import net.phi.testmod.item.Moditems;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf((ModBlocks.COIN_BLOCK.get()));
        add(ModBlocks.RAW_COIN_BLOCK.get(),
                block -> createOreDrop(ModBlocks.RAW_COIN_BLOCK.get(), Moditems.RAW_COIN.get())
                );
    }

    @Override
    @NotNull
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
