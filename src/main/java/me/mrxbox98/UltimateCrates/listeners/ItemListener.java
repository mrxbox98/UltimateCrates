package me.mrxbox98.UltimateCrates.listeners;

import me.mrxbox98.UltimateCrates.UltimateCrates;
import me.mrxbox98.UltimateCrates.crates.Crate;
import me.mrxbox98.UltimateCrates.guis.CrateOpenGui;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event)
    {
        if(event.getItem()==null)
        {
            return;
        }

        if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK))
        {
            return;
        }

        if(!event.getItem().getType().equals(Material.ENDER_CHEST))
        {
            return;
        }

        if(event.getItem().getItemMeta().getLore()==null)
        {
            return;
        }

        String str = event.getItem().getItemMeta().getLore().get(event.getItem().getItemMeta().getLore().size()-1).replace(" "+ ChatColor.COLOR_CHAR,"");

        int id;

        try
        {
            id = Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            return;
        }

        for(Crate crate: Crate.crates)
        {
            if(crate.id==id)
            {
                UltimateCrates.instance.getServer().getPluginManager().registerEvents(new CrateOpenGui(event.getPlayer(), crate), UltimateCrates.instance);
                return;
            }
        }
    }

}
