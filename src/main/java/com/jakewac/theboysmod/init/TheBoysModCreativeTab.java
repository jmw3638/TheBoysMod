package com.jakewac.theboysmod.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TheBoysModCreativeTab extends CreativeModeTab {

    public static final TheBoysModCreativeTab instance = new TheBoysModCreativeTab(CreativeModeTab.TABS.length,
            "theboysmod");

    private TheBoysModCreativeTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.SLIME_BALL);
    }

}