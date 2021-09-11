package me.mrxbox98.UltimateCrates.guis;

import me.mrxbox98.UltimateCrates.CrateConfig;
import me.mrxbox98.UltimateCrates.UltimateCrates;
import me.mrxbox98.UltimateCrates.crates.Crate;
import me.mrxbox98.UltimateCrates.crates.CrateReward;
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

        player.openInventory(inventory);

    }


    public void loadChances()
    {
        inventory.clear();

        ItemStack chance10 = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (byte)5);

        ItemMeta chance10Meta = chance10.getItemMeta();

        chance10Meta.setDisplayName(ChatColor.GREEN+ChatColor.BOLD.toString()+"Add 10% chance");

        chance10.setItemMeta(chance10Meta);

        inventory.setItem(1,chance10);

        ItemStack chance1 = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (byte)5);

        ItemMeta chance1Meta = chance1.getItemMeta();

        chance1Meta.setDisplayName(ChatColor.GREEN+ChatColor.BOLD.toString()+"Add 1% chance");

        chance1.setItemMeta(chance1Meta);

        inventory.setItem(2,chance1);

        ItemStack chance01 = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (byte)5);

        ItemMeta chance01Meta = chance01.getItemMeta();

        chance01Meta.setDisplayName(ChatColor.GREEN+ChatColor.BOLD.toString()+"Add 0.1% chance");

        chance01.setItemMeta(chance01Meta);

        inventory.setItem(3,chance01);

        ItemStack minusChance10 = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (byte)14);

        ItemMeta minusChance10Meta = minusChance10.getItemMeta();

        minusChance10Meta.setDisplayName(ChatColor.RED+ChatColor.BOLD.toString()+"Remove 10% chance");

        minusChance10.setItemMeta(minusChance10Meta);

        inventory.setItem(5,minusChance10);

        ItemStack minusChance1 = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (byte)14);

        ItemMeta minusChance1Meta = minusChance1.getItemMeta();

        minusChance1Meta.setDisplayName(ChatColor.RED+ChatColor.BOLD.toString()+"Remove 1% chance");

        minusChance1.setItemMeta(minusChance1Meta);

        inventory.setItem(6,minusChance1);

        ItemStack minusChance01 = new ItemStack(Material.getMaterial("STAINED_GLASS_PANE"), 1, (byte)14);

        ItemMeta minusChance01Meta = minusChance01.getItemMeta();

        minusChance01Meta.setDisplayName(ChatColor.RED+ChatColor.BOLD.toString()+"Remove 0.1% chance");

        minusChance01.setItemMeta(minusChance01Meta);

        inventory.setItem(7,minusChance01);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        if(!event.getInventory().equals(inventory))
        {
            return;
        }

        event.setCancelled(true);

        switch(event.getSlot())
        {
            case 1:
                changeCrateRewardChance(10);
                break;
            case 2:
                changeCrateRewardChance(1);
                break;
            case 3:
                changeCrateRewardChance(0.1d);
                break;
            case 5:
                changeCrateRewardChance(-10);
                break;
            case 6:
                changeCrateRewardChance(-1);
                break;
            case 7:
                changeCrateRewardChance(-0.1);
                break;

        }
    }

    /**
     * Changes the chance of a reward
     * @param chance the chance to change
     */
    public void changeCrateRewardChance(double chance)
    {
        if(crateReward.getChance()+chance<0.1 || crateReward.getChance()+chance>100)
        {
            player.sendMessage(CrateConfig.editBadChance);
        }
        else
        {
            crateReward.setChance(crateReward.getChance()+chance);
        }

        crate.save();
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event)
    {
        if(inventory.equals(event.getInventory()))
        {
            HandlerList.unregisterAll(this);
            UltimateCrates.instance.getServer().getPluginManager().registerEvents(new CrateEditGui(crate, player), UltimateCrates.instance);
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

}
