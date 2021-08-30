package me.mrxbox98.UltimateCrates.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CrateCreateGui implements Listener {

    private Inventory inventory;

    private Player player;

    public CrateCreateGui(Player player)
    {
        this.player = player;

        inventory=Bukkit.createInventory(null, 27, "Create Confirmation");

        ItemStack confirm = new ItemStack(Material.WOOL, 1, (byte)5);

        ItemMeta confirmMeta = confirm.getItemMeta();

        confirmMeta.setDisplayName("Confirm");

        confirm.setItemMeta(confirmMeta);

        ItemStack cancel = new ItemStack(Material.WOOL, 1, (byte)14);

        ItemMeta cancelMeta = confirm.getItemMeta();

        cancelMeta.setDisplayName("Confirm");

        cancel.setItemMeta(confirmMeta);

        inventory.setItem(12, confirm);

        inventory.setItem(14, cancel);

        player.openInventory(inventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        if(!event.getInventory().equals(inventory))
        {
            return;
        }

        if(event.getSlot()==12)
        {

        }
        if(event.getSlot()==14)
        {

        }

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event)
    {
        if(!event.getInventory().equals(inventory))
        {
            return;
        }
        HandlerList.unregisterAll(this);
    }

}
