package me.mrxbox98.UltimateCrates.crates;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CrateReward {

    double chance;

    int amount;

    Material type;

    ItemMeta meta;

    public CrateReward(ItemStack itemStack)
    {
        amount=itemStack.getAmount();
        type=itemStack.getType();
        meta=itemStack.getItemMeta();
    }



    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public ItemStack getItemStack() {
        ItemStack itemStack = new ItemStack(type, amount);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
}
