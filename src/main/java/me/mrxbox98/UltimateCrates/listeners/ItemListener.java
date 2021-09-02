package me.mrxbox98.UltimateCrates.listeners;

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

        String str = event.getItem().getItemMeta().getLore().get(0).replace(" "+ ChatColor.COLOR_CHAR,"");

        int id = Integer.parseInt(str);
    }

}
