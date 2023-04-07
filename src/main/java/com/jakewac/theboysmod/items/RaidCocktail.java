package com.jakewac.theboysmod.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class RaidCocktail extends Item {
    private static final int DRINK_DURATION = 32;

    public RaidCocktail(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return DRINK_DURATION;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(world, player, hand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level world, LivingEntity livingEntity) {
        if (!world.isClientSide()) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 3600, 0));
        }

        if (livingEntity instanceof Player && !((Player) livingEntity).getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        return super.finishUsingItem(itemStack, world, livingEntity);
    }

}
