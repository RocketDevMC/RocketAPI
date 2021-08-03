package xyz.invisraidinq.rocketapi.api.command.impl;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import xyz.invisraidinq.rocketapi.api.command.CommandData;

import java.util.List;

public abstract class BaseCommand {

    /**
     * Handle the command
     *
     * @param commandData The command data
     */
    public abstract void handleCommand(CommandData commandData);

    /**
     * Handle the tab completion of a command
     *
     * @param sender The sender of the command
     * @param command The command
     * @param label The label sent by the sender
     * @param args The args sent by the sender
     */
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }

}
