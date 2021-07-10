package xyz.invisraidinq.rocketapi.bungee.utils;

import net.md_5.bungee.api.ProxyServer;

public class BungeeLogger {

    public static void log(String text) {
        ProxyServer.getInstance().getConsole().sendMessage(text);
    }
}
