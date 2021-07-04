package xyz.invisraidinq.rocketapi.api.database.flatfile;

import xyz.invisraidinq.rocketapi.api.config.YamlConfig;
import xyz.invisraidinq.rocketapi.api.database.IDatabase;

import java.io.File;

public class RocketFlatFile implements IDatabase {

    private final String name;
    private final File path;

    private YamlConfig yamlConfig;

    /**
     * Instantiate an {@link RocketFlatFile} class
     *
     * @param name The name of the file
     * @param path The path of the file
     */
    public RocketFlatFile(String name, File path) {
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
        this.yamlConfig = new YamlConfig(this.name, this.path);
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
