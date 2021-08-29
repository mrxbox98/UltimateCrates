package me.mrxbox98.UltimateCrates;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

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

        if(args.length==1)
        {
            sender.sendMessage(CrateConfig.helpMessage);
            return true;
        }





        return true;
    }

}
