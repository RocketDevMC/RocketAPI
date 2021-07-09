package xyz.invisraidinq.rocketapi.api.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class JsonConfig {

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private final File jsonFile;
    private Map<String, Object> entries;

    /**
     * Constructor to instantiate an {@link JsonConfig}
     *
     * @param name The name of the file
     * @param path The path of the file
     */
    public JsonConfig(String name, File path) {
        if (!path.exists()) {
            path.mkdirs();
        }

        this.jsonFile = new File(path, name.contains(".json") ? name : name + ".json");
        if (!this.jsonFile.exists()) {
            try {
                this.jsonFile.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            this.entries = this.gson.fromJson(new FileReader(this.jsonFile), HashMap.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reload the file
     */
    public void reload() {
        try {
            this.entries = this.gson.fromJson(new FileReader(this.jsonFile), HashMap.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Save the file
     */
    public void save() {
        try {
            this.jsonFile.delete();
            Files.write(this.jsonFile.toPath(), this.gson.toJson(this.entries).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getString(String path) {
        return (String) this.entries.get(path);
    }

    public int getInt(String path) {
        return (int) this.entries.get(path);
    }
}
