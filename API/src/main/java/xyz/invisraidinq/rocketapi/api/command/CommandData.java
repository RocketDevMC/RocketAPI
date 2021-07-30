package xyz.invisraidinq.rocketapi.api.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandData {

    private final CommandSender sender;
    private final Command command;
    private final String label;
    private final String[] args;

    public CommandData(CommandSender sender, Command command, String label, String[] args) {
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;
    }

    public CommandSender getSender() {
        return this.sender;
    }

    public Command getCommand() {
        return this.command;
    }

    public String getLabel() {
        return this.label;
    }

    public String[] getArgs() {
        return this.args;
    }

    public boolean isPlayer() {
        return this.sender instanceof Player;
    }

    public Player getPlayer() {
        return this.sender instanceof Player ? (Player) this.sender : null;
    }

    public int getArgLength() {
        return this.args.length;
    }

    public String getArg(int index) {
        return this.args[index];
    }
}
