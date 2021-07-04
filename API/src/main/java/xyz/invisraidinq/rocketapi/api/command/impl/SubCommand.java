package xyz.invisraidinq.rocketapi.api.command.impl;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public abstract class SubCommand {

    private final String name;

    private String description;
    private List<String> aliases = new ArrayList<>();

    /**
     * Instantiate an {@link SubCommand}
     *
     * @param name The name of the command
     */
    public SubCommand(String name) {
        this.name = name;
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
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }

    /**
     * Get the command name
     *
     * @return The name of the command
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the command description
     *
     * @return The description of the command
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description of a command
     *
     * @param description The description of the command
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the aliases of the command
     *
     * @return The aliases of the command
     */
    public List<String> getAliases() {
        return this.aliases;
    }

    /**
     * Set the aliases of the command
     *
     * @param aliases The aliases of the command
     */
    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }
}