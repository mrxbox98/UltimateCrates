package me.mrxbox98.UltimateCrates.guis;

import me.mrxbox98.UltimateCrates.CrateConfig;
import me.mrxbox98.UltimateCrates.crates.Crate;
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

    private String name;

    public CrateCreateGui(Player player, String name)
    {
        this.player = player;

        this.name=name;

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

    /**
     * Called when someone clicks on inventory
     * @param event the event
     */
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        if(!event.getInventory().equals(inventory))
        {
            return;
        }
        event.setCancelled(true);
        if(event.getSlot()==12)
        {
            player.sendMessage(CrateConfig.crateCreateConfirm);
            Crate.crates.add(new Crate(name));
        }
        if(event.getSlot()==14)
        {
            player.sendMessage(CrateConfig.createCreateCancel);
            player.closeInventory();
        }

    }

    /**
     * Called when inventory is closed
     * @param event the inventory close event
     */
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
