package xyz.invisraidinq.rocketapi.api;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.invisraidinq.rocketapi.api.utils.Scheduler;

public abstract class RocketPlugin extends JavaPlugin {

    private Scheduler scheduler;

    @Override
    public void onEnable() {
        this.scheduler = new Scheduler(this);
        this.onServerStart();
    }

    @Override
    public void onDisable() {
        this.onServerStop();
    }

    public abstract void onServerStart();
    public abstract void onServerStop();

    /**
     * Get the {@link Scheduler}
     *
     * @return The {@link Scheduler} for the plugin
     */
    public Scheduler getScheduler() {
        return this.scheduler;
    }
}
