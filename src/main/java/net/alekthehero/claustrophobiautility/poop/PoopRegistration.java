package net.alekthehero.claustrophobiautility.poop;

import net.alekthehero.claustrophobiautility.core.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static net.alekthehero.claustrophobiautility.ClaustrophobiaUtility.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PoopRegistration {
    public static final RegistryObject<Item> POOP = Registries.ITEMS.register("poop", () ->
            new PoopItem(new Item.Properties()));
    public static final RegistryObject<Item> POOP_FUEL = Registries.ITEMS.register("poop_fuel", () ->
            new PoopFuelItem(new Item.Properties()));
}
