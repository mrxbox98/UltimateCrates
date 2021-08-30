package me.mrxbox98.UltimateCrates.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CrateCreateGui implements Listener {

    private Inventory inventory;

    private Player player;

    public CrateCreateGui(Player player)
    {
        this.player = player;

        inventory=Bukkit.createInventory(null, 54, "Create Confirmation");

        ItemStack confirm = new ItemStack(Material.WOOL, 1, (byte)5);

        ItemMeta confirmMeta = confirm.getItemMeta();

        confirmMeta.setDisplayName("Confirm");

        confirm.setItemMeta(confirmMeta);

        inventory.setItem(4, confirm);

        player.openInventory(inventory);
    }

    public void onInventoryClick(InventoryClickEvent event)
    {
        if(!event.getInventory().equals(inventory))
        {
            return;
        }


    }

}
