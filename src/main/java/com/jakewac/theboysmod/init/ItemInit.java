package com.jakewac.theboysmod.init;

import com.jakewac.theboysmod.TheBoysMod;
import com.jakewac.theboysmod.items.Beefstick;
import com.jakewac.theboysmod.items.MattAttack;
import com.jakewac.theboysmod.items.RaidCocktail;
import com.jakewac.theboysmod.items.TeleportStaff;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    // Register
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheBoysMod.MODID);

    // Items

    public static final RegistryObject<Item> RAID_COCKTAIL = ITEMS.register("raid_cocktail",
            () -> new RaidCocktail(new Item.Properties().tab(TheBoysModCreativeTab.instance)));

    public static final RegistryObject<Item> MATT_ATTACK = ITEMS.register("matt_attack",
            () -> new MattAttack(new Item.Properties().tab(TheBoysModCreativeTab.instance)));

    public static final RegistryObject<Item> BEEFSTICK = ITEMS.register("beefstick",
            () -> new Beefstick(new Item.Properties().tab(TheBoysModCreativeTab.instance)
                    .food(new FoodProperties.Builder().nutrition(20).saturationMod(6)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1), 1.0F)
                            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 4), 1.0F).build())));

    public static final RegistryObject<Item> TELEPORT_STAFF = ITEMS.register("teleport_staff",
            () -> new TeleportStaff(new Item.Properties().tab(TheBoysModCreativeTab.instance)));

}
