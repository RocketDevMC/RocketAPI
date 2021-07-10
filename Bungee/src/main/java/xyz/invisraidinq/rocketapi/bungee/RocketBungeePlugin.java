package xyz.invisraidinq.rocketapi.bungee;

import net.md_5.bungee.api.plugin.Plugin;

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
}
