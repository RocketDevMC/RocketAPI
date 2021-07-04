package xyz.invisraidinq.rocketapi.api.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.invisraidinq.rocketapi.api.RocketPlugin;
import xyz.invisraidinq.rocketapi.api.enums.Severity;

public class BukkitLogger {

    /**
     * Log a raw message to the console
     *
     * @param rawText The text to log
     */
    public static void logRaw(String rawText) {
        Bukkit.getConsoleSender().sendMessage(rawText);
    }

    /**
     * Log a message to the console
     *
     * @param text The text to log
     */
    public static void log(String text) {
        logRaw(CC.colour("[" + JavaPlugin.getPlugin(RocketPlugin.class).getDescription().getName() + "] " + text));
    }

    /**
     * Log a message to the console with an {@link Severity}
     *
     * @param severity The severity of the log
     * @param text The text to log
     */
    public static void log(Severity severity, String text) {
        log("[" + severity.getFormat() + "]" + text);
    }
}
