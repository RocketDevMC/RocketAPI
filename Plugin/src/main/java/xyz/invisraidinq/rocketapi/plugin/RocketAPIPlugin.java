package xyz.invisraidinq.rocketapi.plugin;

import xyz.invisraidinq.rocketapi.api.RocketPlugin;
import xyz.invisraidinq.rocketapi.api.command.CommandHandler;
import xyz.invisraidinq.rocketapi.api.utils.BukkitLogger;
import xyz.invisraidinq.rocketapi.plugin.commands.RocketAPICommand;

public class RocketAPIPlugin extends RocketPlugin {

    @Override
    public void onServerStart() {
        CommandHandler commandHandler = new CommandHandler(this);
        commandHandler.setNoPermissionMessage("&cNo Permission");
        commandHandler.registerSimpleCommand(new RocketAPICommand());
        BukkitLogger.log("RocketAPI has been enabled");
    }

    @Override
    public void onServerStop() {
        BukkitLogger.log("RocketAPI has been disabled");
    }
}
