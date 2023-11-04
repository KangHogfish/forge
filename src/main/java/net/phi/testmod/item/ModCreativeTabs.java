package net.phi.testmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.phi.testmod.TestMod;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
    public static final RegistryObject<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TAB.register("test_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.COIN.get()))
                    .title(Component.translatable("creative.test_mod"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Moditems.COIN.get());
                        pOutput.accept(Items.DIAMOND);
                    })
                    .build());
}
