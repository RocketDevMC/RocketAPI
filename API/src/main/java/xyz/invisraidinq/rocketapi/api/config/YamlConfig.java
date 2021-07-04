package xyz.invisraidinq.rocketapi.api.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YamlConfig extends YamlConfiguration {

    private final File configFile;

    public YamlConfig(String name, File path) {
        if (!path.exists()) {
            path.mkdirs();
        }

        this.configFile = new File(path, name.contains(".yml") ? name : name + ".yml");
        if (!this.configFile.exists()) {
            try {
                this.configFile.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void reload() {
        try {
            this.load(this.configFile);
        } catch (InvalidConfigurationException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public void save() {
        try {
            this.save(this.configFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
