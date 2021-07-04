package xyz.invisraidinq.rocketapi.api.database.flatfile;

import xyz.invisraidinq.rocketapi.api.config.YamlConfig;

import java.io.File;

public class RocketFlatFile {

    private final String name;
    private final File path;

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
    public YamlConfig connect() {
        return new YamlConfig(this.name, this.path);
    }
}
