package net.phi.testmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.phi.testmod.TestMod;
import net.phi.testmod.item.Moditems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(Moditems.COIN);
        simpleItem(Moditems.RAW_COIN);

    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return  withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TestMod.MODID,"item/" + item.getId().getPath()));
    }
}
