package com.jakewac.theboysmod.init;

import java.util.function.Supplier;

import com.jakewac.theboysmod.TheBoysMod;
import com.jakewac.theboysmod.blocks.ZacksBalls;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
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
    // Register
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            TheBoysMod.MODID);

    // Blocks

    public static final RegistryObject<Block> ZACKS_BALLS = BLOCKS.register("zacks_balls",
            () -> new ZacksBalls(
                    BlockBehaviour.Properties.of(Material.STONE).strength(0.3F).sound(SoundType.SLIME_BLOCK)));

    // Block Items

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
