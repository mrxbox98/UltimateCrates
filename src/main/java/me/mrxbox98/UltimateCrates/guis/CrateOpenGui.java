package me.mrxbox98.UltimateCrates.guis;

import me.mrxbox98.UltimateCrates.UltimateCrates;
import me.mrxbox98.UltimateCrates.crates.Crate;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
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

        player.openInventory(inventory);

        animate();
    }

    public void animate()
    {
        ItemStack reward = crate.roll().getItemStack();
        if(reward!=null)
        {
            player.getInventory().addItem(reward);
        }
        for(int i=0;i<22;i++)
        {
            int finalI = i;
            Bukkit.getScheduler().runTaskLater(UltimateCrates.instance, () -> {
                inventory.setItem(finalI,generateRandomGlass());
                inventory.setItem(44 - finalI,generateRandomGlass());
            },i*4);
        }

        if(reward!=null)
        {
            Bukkit.getScheduler().runTaskLater(UltimateCrates.instance, () -> inventory.setItem(22,reward),22*4);
        }


    }

    public ItemStack generateRandomGlass()
    {
        ItemStack itemStack = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"),1,(byte)new Random().nextInt(14));

        itemStack.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE+"...");

        return itemStack;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event)
    {
        if(event.getInventory().equals(inventory))
        {
            HandlerList.unregisterAll(this);
        }
    }

    @EventHandler
    public void onDragClick(InventoryDragEvent event)
    {
        if(event.getInventory().equals(inventory))
        {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        if(event.getInventory().equals(inventory))
        {
            event.setCancelled(true);
        }
    }
}
