package xyz.invisraidinq.rocketapi.api.command.impl;

import com.google.common.base.Preconditions;
import org.bukkit.command.*;
import xyz.invisraidinq.rocketapi.api.command.ICommand;
import xyz.invisraidinq.rocketapi.api.utils.CC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdvancedCommand implements CommandExecutor, TabCompleter, ICommand {

    private final String name;
    private String description;
    private List<String> aliases;
    private String permission;

    private List<SubCommand> subCommands = new ArrayList<>();
    private BaseCommand baseCommand;

    /**
     * Instantiate an {@link AdvancedCommand} command
     *
     * @param name The name of the command
     */
    public AdvancedCommand(String name) {
        this.name = name;
    }

    /**
     * Handle the main command
     *
     * @param sender The command sender
     * @param command The command sent
     * @param label The label sent by the sender
     * @param args The args sent by the sender
     * @return true/false depending on the outcome
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            if (this.baseCommand != null) {
                this.baseCommand.handleCommand(sender, label, args);
                return true;
            }
            
            sender.sendMessage(CC.colour(
                    "&cInvalid Usage! Available sub-commands for &7" + label + " &care &7" +
                            this.subCommands.stream().map(SubCommand::getName).collect(Collectors.joining("&7, "))));
            return false;
        }

        SubCommand argument = this.getSubCommand(args[0]);

        if (argument == null) {
            sender.sendMessage(CC.colour("&cSub-command &7" + args[0] + " &cdoes not exist in command &7" + this.name));
            return false;
        }

        argument.handleCommand(sender, label, args);
        return true;
    }

    /**
     * Handle the command tab completion
     *
     * @param sender The sender of the command
     * @param command The command sent
     * @param label The label sent by the sender
     * @param args The args of the command
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args){
        List<String> results = new ArrayList<>();

        if(args.length < 2) {
            for (SubCommand subCommand : this.subCommands) {
                results.add(subCommand.getName());
            }

            if (results.isEmpty()) {
                return null;
            }

        } else {
            SubCommand argument = this.getSubCommand(args[0]);

            if (argument == null) {
                return results;
            }

            results = argument.onTabComplete(sender, command, label, args);

            if (results == null) {
                return null;
            }
        }

        return this.getCompletions(args, results);
    }

    /**
     * Get a sub command
     *
     * @param name The name of the command
     * @return The {@link SubCommand} if found
     */
    public SubCommand getSubCommand(String name) {
        for (SubCommand subCommand : this.subCommands) {
            if (subCommand.getName().equalsIgnoreCase(name) || subCommand.getAliases().contains(name.toLowerCase())) {
                return subCommand;
            }
        }

        return null;
    }

    /**
     * Get the completions of a command
     *
     * @param arguments The amount of arguments
     * @param input The input
     * @return A list of matches
     */
    private List<String> getCompletions(String[] arguments, List<String> input) {
        Preconditions.checkNotNull(arguments);
        Preconditions.checkArgument(arguments.length != 0);
        String argument = arguments[arguments.length - 1];
        return input.stream().filter(string -> string.regionMatches(true, 0, argument, 0, argument.length())).limit(80).collect(Collectors.toList());
    }

    /**
     * Set sub commands
     *
     * @param subCommands The array of {@link SubCommand} to set in the command
     */
    public void setSubCommands(List<SubCommand> subCommands) {
        this.subCommands.addAll(subCommands);
    }

    /**
     * Set the {@link BaseCommand} of the command
     *
     * @param baseCommand The {@link BaseCommand} to set
     */
    public void setBaseCommand(BaseCommand baseCommand) {
        this.baseCommand = baseCommand;
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

