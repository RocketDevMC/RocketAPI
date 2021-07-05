package xyz.invisraidinq.rocketapi.api.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YamlConfig extends YamlConfiguration {

    private final File yamlFile;

    /**
     * Constructor to instantiate an {@link YamlConfig}
     *
     * @param name The name of the file
     * @param path The path of the file
     */
    public YamlConfig(String name, File path) {
        if (!path.exists()) {
            path.mkdirs();
        }

        this.yamlFile = new File(path, name.contains(".yml") ? name : name + ".yml");
        if (!this.yamlFile.exists()) {
            try {
                this.yamlFile.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Reload the file
     */
    public void reload() {
        try {
            this.load(this.yamlFile);
        } catch (InvalidConfigurationException | IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Save the file
     */
    public void save() {
        try {
            this.save(this.yamlFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
