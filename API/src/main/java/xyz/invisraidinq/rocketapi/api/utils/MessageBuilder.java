package xyz.invisraidinq.rocketapi.api.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageBuilder {

    private String message;

    public MessageBuilder(String message) {
        this.message = message;
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
}
