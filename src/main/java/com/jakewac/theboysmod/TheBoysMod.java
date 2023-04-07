package com.jakewac.theboysmod;

import org.slf4j.Logger;

import com.jakewac.theboysmod.init.BlockInit;
import com.jakewac.theboysmod.init.EnchantmentInit;
import com.jakewac.theboysmod.init.ItemInit;
import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TheBoysMod.MODID)
public class TheBoysMod {
    public static final String MODID = "theboysmod";

    private static final Logger LOGGER = LogUtils.getLogger();

    public TheBoysMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register blocks to the mod event bus
        BlockInit.BLOCKS.register(modEventBus);
        // Register items to the mod event bus
        ItemInit.ITEMS.register(modEventBus);
        // Register enchantments to the mod event bus
        EnchantmentInit.ENCHANTMENTS.register(modEventBus);

        // Register this for server and other game events
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Server startup
        LOGGER.info("HELLO FROM SERVER START");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
