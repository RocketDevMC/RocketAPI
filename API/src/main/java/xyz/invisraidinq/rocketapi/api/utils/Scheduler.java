package xyz.invisraidinq.rocketapi.api.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Scheduler {

    private final Plugin plugin;

    public Scheduler(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Run a task on the main thread
     *
     * @param runnable The {@link Runnable} to run
     */
    public void runSync(Runnable runnable) {
        Bukkit.getScheduler().runTask(this.plugin, runnable);
    }

    /**
     * Run a task later on the main thread
     *
     * @param runnable The {@link Runnable} to run
     * @param wait The time before running
     */
    public void runSyncLater(Runnable runnable, long wait) {
        Bukkit.getScheduler().runTaskLater(this.plugin, runnable, wait);
    }

    /**
     * Run a repeating task on the main thread
     *
     * @param runnable The {@link Runnable} to run
     * @param delay The delay between running the task
     */
    public void runSyncRepeating(Runnable runnable, long delay) {
        Bukkit.getScheduler().runTaskTimer(this.plugin, runnable, 0L, delay);
    }

    /**
     * Run a task on off main thread
     *
     * @param runnable The {@link Runnable} to run
     */
    public void runAsync(Runnable runnable) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, runnable);
    }

    /**
     * Run a task later off the main thread
     *
     * @param runnable The {@link Runnable} to run
     * @param wait The time before running
     */
    public void runAsyncLater(Runnable runnable, long wait) {
        Bukkit.getScheduler().runTaskLaterAsynchronously(this.plugin, runnable, wait);
    }

    /**
     * Run a repeating task off the main thread
     *
     * @param runnable The {@link Runnable} to run
     * @param delay The delay between running the task
     */
    public void runAsyncRepeatingTask(Runnable runnable, long delay) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(this.plugin, runnable, 0L, delay);
    }
}
