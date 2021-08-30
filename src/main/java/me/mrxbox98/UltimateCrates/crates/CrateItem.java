package me.mrxbox98.UltimateCrates.crates;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CrateItem extends ItemStack {

    public CrateItem(Crate crate)
    {
        super(Material.ENDER_CHEST);

        ItemMeta meta = getItemMeta();

        String id = String.valueOf(crate.id);

        id=id.replace(""," §");

        List<String> lore = meta.getLore();

        lore.add(id);

        meta.setLore(lore);

        setItemMeta(meta);
    }

}
