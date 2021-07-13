package xyz.invisraidinq.rocketapi.api.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class MessageBuilder {

    private String message;

    public MessageBuilder(String message) {
        this.message = message;
    }
    
    public MessageBuilder(List<String> messages) {
        for (String message : messages) {
            if (this.message == null) {
                this.message = message;
            } else {
                this.message += "\n" + message;
            }
        }
    }

    public MessageBuilder colour() {
        this.message = CC.colour(this.message);
        return this;
    }

    public MessageBuilder replace(String toReplace, String replacement) {
        this.message = this.message.replace(toReplace, replacement);
        return this;
    }

    public MessageBuilder send(Player player) {
        player.sendMessage(this.message);
        return this;
    }

    public MessageBuilder send(CommandSender sender) {
        sender.sendMessage(this.message);
        return this;
    }

    public static void sendGlobalMessage(String message) {
        Bukkit.broadcastMessage(CC.colour(message));
    }

    public static void sendGlobalMessage(String message, String permission) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (player.hasPermission(permission)) {
                new MessageBuilder(message).colour().send(player);
            }
        });
    }
}
