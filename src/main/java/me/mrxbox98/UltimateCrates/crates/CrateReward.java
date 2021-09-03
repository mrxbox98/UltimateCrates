package me.mrxbox98.UltimateCrates.crates;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CrateReward {

    double chance;

    int amount;

    Material type;

    String displayName;

    List<String> lore;

    public CrateReward(ItemStack itemStack)
    {
        amount=itemStack.getAmount();
        type=itemStack.getType();
        displayName=itemStack.getItemMeta().getDisplayName();
        lore=itemStack.getItemMeta().getLore();
    }



    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public ItemStack getItemStack() {
        ItemStack itemStack = new ItemStack(type, amount);

        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(displayName);

        itemMeta.setLore(lore);

        return itemStack;
    }
}
