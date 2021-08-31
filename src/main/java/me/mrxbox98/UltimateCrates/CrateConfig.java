package me.mrxbox98.UltimateCrates;

import org.bukkit.configuration.file.FileConfiguration;

import java.lang.reflect.Field;

public class CrateConfig {

    public static String helpMessage="/crate create <name> - Create a new crate";

    public static String crateCreateConfirm="You have created a new crate!";

    public static String createCreateCancel="You have canceled creating a crate!";

    public static String editBadChance="You chance cannot be below 0.1 and cannot be higher than 100!";

    public static String crateCreateNameError="You must specify a name";

    public static void setup()
    {
        FileConfiguration config = UltimateCrates.instance.getConfig();

        Class clzz = CrateConfig.class;

        for(Field field: clzz.getFields())
        {
            if(field.getClass().equals(String.class))
            {
                String name = field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);

                if(!config.contains(name))
                {
                    try {
                        config.addDefault(name, field.get(null));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    field.set(null, config.getString(name));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        config.options().copyDefaults(true);
        UltimateCrates.instance.saveConfig();
    }

}
