package me.mrxbox98.UltimateCrates.crates;

import org.bukkit.inventory.ItemStack;

public class CrateReward {

    double chance;

    ItemStack itemStack;

    public CrateReward(ItemStack itemStack)
    {
        this.itemStack=itemStack;
    }

    public CrateReward(ItemStack itemStack, double chance)
    {
        this.itemStack=itemStack;
        this.chance=chance;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }
}
