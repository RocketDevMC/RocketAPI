package xyz.invisraidinq.rocketapi.api.command.impl;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class BaseCommand {

    /**
     * Handle the command
     *
     * @param sender The command sender
     * @param label The label sent by the player
     * @param args The args sent by the player
     */
    public abstract void handleCommand(CommandSender sender, String label, String[] args);

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
