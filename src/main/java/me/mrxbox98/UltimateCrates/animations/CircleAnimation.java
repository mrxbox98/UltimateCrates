package me.mrxbox98.UltimateCrates.animations;

import me.mrxbox98.UltimateCrates.crates.Crate;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CircleAnimation {

    private Crate crate;

    private Player player;

    public CircleAnimation(Crate crate, Player player)
    {
        this.crate=crate;
        this.player=player;

        animate();
    }

    public void animate()
    {
        ArrayList<ArmorStand> stands = new ArrayList<>();

        for(int i=0;i<crate.rewards.size();i++)
        {
            ArmorStand armorStand = player.getWorld().spawn(player.getLocation().add(Math.sin(i/crate.rewards.size()),0,Math.cos(i/crate.rewards.size())),ArmorStand.class);

            armorStand.setGravity(false);
            armorStand.setArms(false);
            armorStand.setBasePlate(false);
            armorStand.setCanPickupItems(false);
            armorStand.setItemInHand(crate.rewards.get(i).getItemStack());

            stands.add(armorStand);
        }

    }

}
