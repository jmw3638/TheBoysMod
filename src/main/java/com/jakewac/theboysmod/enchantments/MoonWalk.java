package com.jakewac.theboysmod.enchantments;

import com.jakewac.theboysmod.init.EnchantmentInit;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class MoonWalk extends Enchantment {

    public MoonWalk(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slot) {
        super(rarity, category, slot);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean checkCompatibility(Enchantment other) {
        return super.checkCompatibility(other) && other != Enchantments.FALL_PROTECTION;
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class MoonWalkEnchantmentHandler {

        @SubscribeEvent
        public static void onTick(TickEvent.PlayerTickEvent event) {
            if (event.phase == TickEvent.Phase.END || event.player.level.isClientSide())
                return;

            int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.MOON_WALK.get(), event.player);

            if (level > 0) {
                event.player.resetFallDistance();
                if (!event.player.hasEffect(MobEffects.JUMP)) {
                    event.player.addEffect(new MobEffectInstance(MobEffects.JUMP, 20, level * 2, true, false));
                }
            }
        }
    }
}
