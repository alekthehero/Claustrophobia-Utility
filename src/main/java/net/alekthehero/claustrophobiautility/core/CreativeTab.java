package net.alekthehero.claustrophobiautility.core;

import net.alekthehero.claustrophobiautility.poop.PoopRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;

import static net.alekthehero.claustrophobiautility.ClaustrophobiaUtility.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTab {
    public static final RegistryObject<CreativeModeTab> MAIN_TAB = Registries.TABS.register("main_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> PoopRegistration.POOP.get().getDefaultInstance())
                    .displayItems(CreativeTab::fillItems)
                    .title(Component.translatableWithFallback("itemGroup.compactmachines.main", "Compact Machines"))
                    .build()
    );

    private static void fillItems(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output) {

        final var items = Arrays
                .stream(new Item[]{
                        PoopRegistration.POOP.get(),
                        PoopRegistration.POOP_FUEL.get()
                })
                .map(Item::getDefaultInstance)
                .toList();
        output.acceptAll(items, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}
