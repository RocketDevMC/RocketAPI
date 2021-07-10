package xyz.invisraidinq.rocketapi.api.database.flatfile;

import org.bukkit.plugin.Plugin;
import xyz.invisraidinq.rocketapi.api.config.YamlConfig;
import xyz.invisraidinq.rocketapi.api.database.IDatabase;

import java.io.File;

public class RocketFlatFile implements IDatabase {

    private final Plugin plugin;
    private final String name;
    private final File path;

    private YamlConfig yamlConfig;

    /**
     * Instantiate an {@link RocketFlatFile} class
     *
     * @param plugin The {@link Plugin} object
     * @param name The name of the file
     * @param path The path of the file
     */
    public RocketFlatFile(Plugin plugin, String name, File path) {
        this.plugin = plugin;
        this.name = name;
        this.path = path;
    }

    /**
     * Connect (create) to a yaml config database
     *
     * @return The {@link YamlConfig} file/database
     */
    @Override
    public YamlConfig connect() {
        this.yamlConfig = new YamlConfig(this.plugin, this.name, this.path);
        return this.yamlConfig;
    }

    /**
     * Disconnect a flatfile
     */
    @Override
    public void disconnect() {
        this.yamlConfig.save();
    }
}
