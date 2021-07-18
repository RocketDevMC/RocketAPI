package xyz.invisraidinq.rocketapi.plugin.commands;

import xyz.invisraidinq.rocketapi.api.command.CommandData;
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
    public void handleCommand(CommandData commandData) {
        if (commandData.isPlayer()) {
            commandData.getPlayer().sendMessage(CC.colour("&eThis server is running &cRocketAPI &eby &cInvisRaidinq"));
        } else {
            commandData.getSender().sendMessage(new String[] {
                    CC.colour("&eThis server is running &cRocketAPI &eby &cInvisRaidinq"),
                    CC.colour("&eCurrent Version: STABLE")
            });
        }
    }
}
