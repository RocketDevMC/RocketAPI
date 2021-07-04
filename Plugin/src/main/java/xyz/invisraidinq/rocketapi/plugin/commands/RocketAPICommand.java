package xyz.invisraidinq.rocketapi.plugin.commands;

import org.bukkit.command.CommandSender;
import xyz.invisraidinq.rocketapi.api.command.impl.SimpleCommand;
import xyz.invisraidinq.rocketapi.api.utils.CC;

import java.util.Collections;

public class RocketAPICommand extends SimpleCommand {

    /**
     * Instantiate an {@link SimpleCommand} command
     */
    public RocketAPICommand() {
        super("rocketapi");

        this.setDescription("See information about RocketAPI");
        this.setAliases(Collections.singletonList("rapi"));
    }

    @Override
    public void handleCommand(CommandSender sender, String label, String[] args) {
        sender.sendMessage(CC.colour("&eThis server is running &cRocketAPI &eby &cInvisRaidinq"));
    }
}
