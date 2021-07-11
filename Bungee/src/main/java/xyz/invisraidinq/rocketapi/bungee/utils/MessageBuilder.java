package xyz.invisraidinq.rocketapi.bungee.utils;

import net.md_5.bungee.api.ProxyServer;

public class MessageBuilder {

    public static void sendGlobalMessage(String message) {
        ProxyServer.getInstance().getPlayers().forEach(player -> player.sendMessage(CC.colour(message)));
    }

    public static void sendGlobalMessage(String message, String permission) {
        ProxyServer.getInstance().getPlayers().forEach(player -> {
            if (player.hasPermission(permission)) {
                player.sendMessage(CC.colour(message));
            }
        });
    }
}
