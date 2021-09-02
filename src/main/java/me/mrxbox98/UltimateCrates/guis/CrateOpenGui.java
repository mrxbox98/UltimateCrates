package me.mrxbox98.UltimateCrates.guis;

import me.mrxbox98.UltimateCrates.UltimateCrates;
import me.mrxbox98.UltimateCrates.crates.Crate;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class CrateOpenGui implements Listener {

    private Inventory inventory;

    private Player player;

    private Crate crate;

    public CrateOpenGui(Player player, Crate crate)
    {
        this.player=player;
        this.crate=crate;

        inventory= Bukkit.createInventory(null,45,"Opening a crate!");

        animate();
    }

    public void animate()
    {
        for(int i=0;i<22;i++)
        {
            int finalI = i;
            Bukkit.getScheduler().runTaskLater(UltimateCrates.instance, new Runnable() {
                @Override
                public void run() {
                    inventory.setItem(finalI,generateRandomGlass());
                    inventory.setItem(45- finalI,generateRandomGlass());
                }
            },i*4);
        }

        Bukkit.getScheduler().runTaskLater(UltimateCrates.instance, new Runnable() {
            @Override
            public void run() {
                inventory.setItem(22,crate.roll().getItemStack());
            }
        },22*4);
    }

    public ItemStack generateRandomGlass()
    {
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE,1,(byte)new Random().nextInt(14));

        itemStack.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE+"...");

        return itemStack;
    }
}
