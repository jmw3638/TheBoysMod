package com.jakewac.theboysmod.init;

import java.util.function.Supplier;

import com.jakewac.theboysmod.TheBoysMod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    // Create a Deferred Register to hold Blocks which will all be registered under
    // the "theboysmod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            TheBoysMod.MODID);

    // Creates a new Block with the id "theboysmod:amongus", combining the
    // namespace and path
    public static final RegistryObject<Block> AMONGUS = BLOCKS.register("amongus",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));

    @SubscribeEvent
    public static void onRegisterItems(final RegisterEvent event) {
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)) {
            BLOCKS.getEntries().forEach((blockRegistryObject) -> {
                Supplier<Item> blockItemFactory = () -> new BlockItem(blockRegistryObject.get(),
                        new Item.Properties().tab(TheBoysModCreativeTab.instance));

                event.register(ForgeRegistries.Keys.ITEMS, blockRegistryObject.getId(), blockItemFactory);
            });
        }
    }
}
