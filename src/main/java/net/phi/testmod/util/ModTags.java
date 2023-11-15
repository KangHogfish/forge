package net.phi.testmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.phi.testmod.TestMod;

import static net.minecraft.tags.TagEntry.tag;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> TEST_ITEM = tag("test_item");
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(TestMod.MODID, name));
        }
    }
}
