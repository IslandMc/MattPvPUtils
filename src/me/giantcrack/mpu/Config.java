package me.giantcrack.mpu;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by shoot_000 on 6/13/2015.
 */
public class Config {

    private static Config instance = new Config();

    public static Config getInstance() {
        return instance;
    }

    private File config;

    private FileConfiguration cfg;

    private Config() {
    }

    public void setup(Plugin p) {
        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }
        config = new File(p.getDataFolder(), "config.yml");
        if (!config.exists()) {
            try {
                config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cfg = YamlConfiguration.loadConfiguration(config);
    }

    public void set(String path, Object value) {
        cfg.set(path, value);
        save();
    }

    public String getString(String path) {
        return cfg.getString(path);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String path) {
        return (T) cfg.get(path);
    }

    public double getDouble(String path) {
        return cfg.getDouble(path);
    }

    public boolean contains(String path) {
        return cfg.contains(path);
    }

    public ConfigurationSection createConfigurationSection(String path) {
        ConfigurationSection cs = cfg.createSection(path);
        save();
        return cs;
    }

    public FileConfiguration getConfig() {
        return cfg;
    }

    public int getInt(String path) {return cfg.getInt(path);}

    public List<String> getList(String path) {
        return cfg.getStringList(path);
    };

    public void save() {
        try {
            cfg.save(config);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
