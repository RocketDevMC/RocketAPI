package xyz.invisraidinq.rocketapi.api.command.impl;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import xyz.invisraidinq.rocketapi.api.command.ICommand;

import java.util.List;

public abstract class SimpleCommand implements ICommand, CommandExecutor, TabCompleter {

    private final String name;
    private String description;
    private List<String> aliases;
    private String permission;

    /**
     * Instantiate an {@link SimpleCommand} command
     *
     * @param name The name of the command
     */
    public SimpleCommand(String name) {
        this.name = name;
    }

    /**
     * Handle the command
     *
     * @param sender The command sender
     * @param command The command
     * @param label The label sent by the sender
     * @param args The args sent by the sender
     * @return true
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        this.handleCommand(sender, label, args);
        return true;
    }

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
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }

    /**
     * Get the command name
     *
     * @return The name of the command
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Get the command description
     *
     * @return The description of the command
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the command description
     *
     * @param description The description of the command
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the command aliases
     *
     * @return The aliases of the command
     */
    @Override
    public List<String> getAliases() {
        return this.aliases;
    }

    /**
     * Set the command aliases
     *
     * @param aliases The aliases of the command
     */
    @Override
    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    /**
     * Get the command permission
     *
     * @return The permission of the command
     */
    @Override
    public String getPermission() {
        return this.permission;
    }

    /**
     * Set the command permission
     *
     * @param permission The aliases of the command
     */
    @Override
    public void setPermission(String permission) {
        this.permission = permission;
    }
}
