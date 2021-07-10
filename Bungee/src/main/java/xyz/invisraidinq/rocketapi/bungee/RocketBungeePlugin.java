package xyz.invisraidinq.rocketapi.bungee;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.List;

public abstract class RocketBungeePlugin extends Plugin {

    @Override
    public void onEnable() {
        this.onServerStart();
    }

    @Override
    public void onDisable() {
        this.onServerStop();
    }

    public abstract void onServerStart();
    public abstract void onServerStop();

    public void registerListeners(List<Listener> listeners) {
        listeners.forEach(listener ->
                ProxyServer.getInstance().getPluginManager().registerListener(this, listener));
    }

    public void registerCommands(List<Command> commands) {
        commands.forEach(command ->
                ProxyServer.getInstance().getPluginManager().registerCommand(this, command));
    }
}
