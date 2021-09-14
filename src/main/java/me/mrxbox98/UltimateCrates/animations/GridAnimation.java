package me.mrxbox98.UltimateCrates.animations;

import me.mrxbox98.UltimateCrates.crates.Crate;
import me.mrxbox98.UltimateCrates.crates.CrateReward;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GridAnimation {

    private Crate crate;

    private Player player;

    public GridAnimation(Crate crate, Player player)
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
            ArmorStand armorStand = player.getWorld().spawn(player.getLocation().add(i,0,0),ArmorStand.class);

            armorStand.setGravity(false);
            armorStand.setArms(false);
            armorStand.setBasePlate(false);
            armorStand.setItemInHand(crate.rewards.get(i).getItemStack());

            stands.add(armorStand);
        }


    }

}
