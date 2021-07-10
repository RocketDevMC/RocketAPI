package xyz.invisraidinq.rocketapi.bungee.config;

import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;

public class BungeeConfig {

    private final File file;
    private Configuration configuration;

    public BungeeConfig(Plugin plugin, File directory, String name) {
        this.file = new File(directory, name.contains(".yml") ? name : name + ".yml");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
                InputStream inputStream = plugin.getResourceAsStream(this.file.getName());
                OutputStream outputStream = new FileOutputStream(this.file);
                ByteStreams.copy(inputStream, outputStream);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        try {
            ConfigurationProvider configurationProvider = ConfigurationProvider.getProvider(YamlConfiguration.class);
            this.configuration = configurationProvider.load(this.file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public BungeeConfig(Plugin plugin, String name) {
        this(plugin, plugin.getDataFolder(), name);
    }

    public void save() {
        try {
            ConfigurationProvider configurationProvider = ConfigurationProvider.getProvider(YamlConfiguration.class);
            configurationProvider.save(this.configuration, this.file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }
}
