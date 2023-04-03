package com.jakewac.theboysmod.init;

import com.jakewac.theboysmod.TheBoysMod;
import com.jakewac.theboysmod.items.TeleportItem;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    // Create a Deferred Register to hold Items which will all be registered under
    // the "theboysmod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheBoysMod.MODID);

    // Creates a new BlockItem with the id "theboysmod:mario", combining the
    // namespace and path
    public static final RegistryObject<Item> MARIO_ITEM = ITEMS.register("mario",
            () -> new Item(new Item.Properties().tab(TheBoysModCreativeTab.instance)
                    .food(new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(1)
                            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 100, 3), 1.0F)
                            .build())));

    public static final RegistryObject<Item> TELEPORT_ITEM = ITEMS.register("teleport_staff",
            () -> new TeleportItem(new Item.Properties().tab(TheBoysModCreativeTab.instance)));

}
