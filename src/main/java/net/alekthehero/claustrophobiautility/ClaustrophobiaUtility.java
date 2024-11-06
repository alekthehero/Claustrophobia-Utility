package net.alekthehero.claustrophobiautility;

import com.mojang.logging.LogUtils;
import net.alekthehero.claustrophobiautility.core.Registries;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ClaustrophobiaUtility.MOD_ID)
public class ClaustrophobiaUtility
{
    public static final String MOD_ID = "claustrophobia_utility";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ClaustrophobiaUtility(FMLJavaModLoadingContext context)
    {
        doRegistration(context);
    }

    private static void doRegistration(FMLJavaModLoadingContext context) {
        var bus = context.getModEventBus();

        Registries.TABS.register(bus);
        Registries.ITEMS.register(bus);
    }
}
