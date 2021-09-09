package me.mrxbox98.UltimateCrates;

import me.mrxbox98.UltimateCrates.crates.Crate;
import me.mrxbox98.UltimateCrates.listeners.ItemListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class UltimateCrates extends JavaPlugin {

    public static JavaPlugin instance;

    public static String mcVersion;

    public static String version="1.0.3";

    @Override
    public void onEnable()
    {
        instance=this;
        setupMcVersion();
        getCommand("crate").setExecutor(new CrateCommand());

        int pluginId = 12659;
        new Metrics(this, pluginId);

        CrateConfig.setup();

        getServer().getPluginManager().registerEvents(new ItemListener(),this);

        loadCrates();
    }

    @Override
    public void onDisable()
    {

    }

    public void loadCrates()
    {
        File folder = new File(getDataFolder()+"/crates/");

        folder.mkdir();

        for(File file: folder.listFiles())
        {
            Crate.crates.add(Crate.fromJson(file));
        }
    }

    public void setupMcVersion()
    {
        if(getServer().getVersion().contains("1.17")) {mcVersion="1.17";}
        if(getServer().getVersion().contains("1.16")) {mcVersion="1.16";}
        if(getServer().getVersion().contains("1.15")) {mcVersion="1.15";}
        if(getServer().getVersion().contains("1.14")) {mcVersion="1.14";}
        if(getServer().getVersion().contains("1.13")) {mcVersion="1.13";}
        if(getServer().getVersion().contains("1.12")) {mcVersion="1.12";}
        if(getServer().getVersion().contains("1.11")) {mcVersion="1.11";}
        if(getServer().getVersion().contains("1.10")) {mcVersion="1.10";}
        if(getServer().getVersion().contains("1.9")) {mcVersion="1.9";}
        if(getServer().getVersion().contains("1.8")) {mcVersion="1.8";}
    }

}
