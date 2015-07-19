package me.giantcrack.mpu;

import me.giantcrack.mpu.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shoot_000 on 6/13/2015.
 */
public class Main extends JavaPlugin {

    private static Main i;

    @Override
    public void onEnable() {
        i = this;
        GappleListener.task.clear();
        GappleListener.time.clear();
        Config.getInstance().setup(this);
        List<String> defaults = new ArrayList<>();
        defaults.add("1337");
        Config.getInstance().getConfig().addDefault("Prefix", "&b[DefaultPrefix] ");
        Config.getInstance().getConfig().addDefault("GAPPLECOOLDOWN",10);
        Config.getInstance().getConfig().addDefault("DisabledPotions",defaults);
        Config.getInstance().getConfig().options().copyDefaults(true);
        Config.getInstance().save();
        registerListeners();
    }

    @Override
    public void onDisable() {
        i = null;
        GappleListener.task.clear();
        GappleListener.time.clear();
    }

    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new BowListener(),this);
        Bukkit.getPluginManager().registerEvents(new GappleListener(),this);
        Bukkit.getPluginManager().registerEvents(new PotionListener(),this);
        Bukkit.getPluginManager().registerEvents(new VillagerListener(),this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(),this);
        Bukkit.getPluginManager().registerEvents(new DispenserListener(),this);
    }

    public static Main getInstance() {
        return i;
    }

}
