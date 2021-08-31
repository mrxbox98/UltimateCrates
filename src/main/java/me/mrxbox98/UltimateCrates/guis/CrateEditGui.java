package me.mrxbox98.UltimateCrates.guis;

import me.mrxbox98.UltimateCrates.UltimateCrates;
import me.mrxbox98.UltimateCrates.crates.Crate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class CrateEditGui implements Listener {

    private Inventory inventory;

    private Player player;

    private Crate crate;

    public CrateEditGui(Crate crate, Player player)
    {
        this.crate=crate;

        this.player=player;

        inventory= Bukkit.createInventory(null,54,"Edit Crate");

        for(int i=0;i<crate.rewards.size();i++)
        {
            inventory.setItem(i,crate.rewards.get(i).getItemStack());
        }

        player.openInventory(inventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        if(!event.getInventory().equals(inventory))
        {
            return;
        }
        event.setCancelled(true);
        if(event.isRightClick())
        {
            crate.rewards.remove(event.getSlot());
            updateInventory();
        }
        if(event.isLeftClick())
        {
            Bukkit.getScheduler().runTask(UltimateCrates.instance, new Runnable() {
                @Override
                public void run() {
                    player.closeInventory();
                    UltimateCrates.instance.getServer().getPluginManager().registerEvents(new CrateChanceEditGui(player, crate, crate.rewards.get(event.getSlot())), UltimateCrates.instance);
                }
            });
        }
    }

    public void updateInventory()
    {
        inventory.clear();
        for(int i=0;i<crate.rewards.size();i++)
        {
            inventory.setItem(i,crate.rewards.get(i).getItemStack());
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event)
    {
        if(event.getInventory().equals(inventory))
        {
            HandlerList.unregisterAll(this);
        }
    }



}
