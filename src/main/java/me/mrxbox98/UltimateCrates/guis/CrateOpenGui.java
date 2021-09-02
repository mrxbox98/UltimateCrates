package me.mrxbox98.UltimateCrates.guis;

import me.mrxbox98.UltimateCrates.crates.Crate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class CrateOpenGui implements Listener {

    private Inventory inventory;

    private Player player;

    private Crate crate;

    public CrateOpenGui(Player player, Crate crate)
    {
        this.player=player;
        this.crate=crate;

        inventory= Bukkit.createInventory(null,54,"Opening a crate!");

        animate();
    }

    public void animate()
    {

    }
}
