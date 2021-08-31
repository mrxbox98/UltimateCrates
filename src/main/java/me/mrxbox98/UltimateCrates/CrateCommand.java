package me.mrxbox98.UltimateCrates;

import me.mrxbox98.UltimateCrates.crates.Crate;
import me.mrxbox98.UltimateCrates.crates.CrateItem;
import me.mrxbox98.UltimateCrates.guis.CrateCreateGui;
import me.mrxbox98.UltimateCrates.guis.CrateEditGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CrateCommand implements CommandExecutor {

    /**
     * Executes the given command, returning its success
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof ConsoleCommandSender)
        {
            sender.sendMessage("You can only send crate commands as a player!");
            return true;
        }

        Player player = (Player) sender;

        if(args.length==1)
        {
            sender.sendMessage(CrateConfig.helpMessage);
            return true;
        }

        if(args[0].equals("create"))
        {
            if(args.length==1)
            {
                player.sendMessage(CrateConfig.crateCreateNameError);
            }
            else
            {
                UltimateCrates.instance.getServer().getPluginManager().registerEvents(new CrateCreateGui(player, args[1]), UltimateCrates.instance);
            }
            return true;
        }
        if(args[0].equals("edit"))
        {
            for(Crate crate: Crate.crates) {
                if (crate.equals(args[1])) {
                    UltimateCrates.instance.getServer().getPluginManager().registerEvents(new CrateEditGui(crate, player), UltimateCrates.instance);
                    return true;
                }
            }
            player.sendMessage(CrateConfig.crateNotFoundError);
            return true;
        }
        if(args[0].equals("give"))
        {
            for(Crate crate: Crate.crates)
            {
                if(crate.name.equals(args[2]))
                {
                    UltimateCrates.instance.getServer().getPlayer(args[1]).getInventory().addItem(new CrateItem(crate));
                    return true;
                }
            }
            player.sendMessage(CrateConfig.crateNotFoundError);
            return true;
        }



        return true;
    }

}
