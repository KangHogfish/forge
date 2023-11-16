package net.phi.testmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.phi.testmod.TestMod;
import net.phi.testmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.COIN_BLOCK);
        blockWithItem(ModBlocks.RAW_COIN_BLOCK);
        stairsBlock((((StairBlock) ModBlocks.COIN_STAIRS.get())), blockTexture(ModBlocks.COIN_BLOCK.get()));
        doorBlockWithRenderType(((DoorBlock)ModBlocks.COIN_DOOR.get()), modLoc("block/coin_door_bottom"), modLoc("block/coin_door_top"),"cutout");
        buttonBlock(((ButtonBlock)ModBlocks.COIN_BUTTON.get()), blockTexture(ModBlocks.COIN_BLOCK.get()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
