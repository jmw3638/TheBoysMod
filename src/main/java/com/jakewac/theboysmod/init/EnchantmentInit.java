package com.jakewac.theboysmod.init;

import com.jakewac.theboysmod.TheBoysMod;
import com.jakewac.theboysmod.enchantments.MoonWalk;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentInit {
    // Register
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister
            .create(ForgeRegistries.ENCHANTMENTS, TheBoysMod.MODID);

    // Enchantments

    public static final RegistryObject<Enchantment> MOON_WALK = ENCHANTMENTS.register("moon_walk",
            () -> new MoonWalk(
                    Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_FEET,
                    new EquipmentSlot[] { EquipmentSlot.FEET }));

}