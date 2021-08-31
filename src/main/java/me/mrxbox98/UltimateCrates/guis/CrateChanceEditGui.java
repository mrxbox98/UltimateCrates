package me.mrxbox98.UltimateCrates.guis;

import me.mrxbox98.UltimateCrates.crates.Crate;
import me.mrxbox98.UltimateCrates.crates.CrateReward;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CrateChanceEditGui implements Listener {

    private Inventory inventory;

    private Player player;

    private Crate crate;

    private CrateReward crateReward;

    public CrateChanceEditGui(Player player, Crate crate, CrateReward crateReward)
    {
        this.player=player;
        this.crate=crate;
        this.crateReward=crateReward;

        inventory= Bukkit.createInventory(null, 9, "Set Reward Chance");

        loadChances();

    }


    public void loadChances()
    {
        inventory.clear();

        ItemStack chance10 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);

        ItemMeta chance10Meta = chance10.getItemMeta();

        chance10Meta.setDisplayName("Add 10% chance");

        chance10.setItemMeta(chance10Meta);

        inventory.addItem(chance10);

        ItemStack chance1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);

        ItemMeta chance1Meta = chance1.getItemMeta();

        chance10Meta.setDisplayName("Add 1% chance");

        chance10.setItemMeta(chance1Meta);

        inventory.addItem(chance1);

        ItemStack chance01 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);

        ItemMeta chance01Meta = chance01.getItemMeta();

        chance10Meta.setDisplayName("Add 0.1% chance");

        chance10.setItemMeta(chance01Meta);

        inventory.addItem(chance01);

        ItemStack minusChance10 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);

        ItemMeta minusChance10Meta = minusChance10.getItemMeta();

        minusChance10Meta.setDisplayName("Add 10% chance");

        minusChance10.setItemMeta(minusChance10Meta);

        inventory.addItem(minusChance10);

        ItemStack minusChance1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);

        ItemMeta minusChance1Meta = minusChance1.getItemMeta();

        minusChance10Meta.setDisplayName("Add 1% chance");

        minusChance10.setItemMeta(minusChance1Meta);

        inventory.addItem(minusChance1);

        ItemStack minusChance01 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);

        ItemMeta minusChance01Meta = minusChance01.getItemMeta();

        minusChance10Meta.setDisplayName("Add 0.1% chance");

        minusChance10.setItemMeta(minusChance01Meta);

        inventory.addItem(minusChance01);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        
    }

}
