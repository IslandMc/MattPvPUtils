package me.giantcrack.mpu.listeners;

import me.giantcrack.mpu.Config;
import me.giantcrack.mpu.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shoot_000 on 6/13/2015.
 */
public class GappleListener implements Listener {

    public static Map<Player, BukkitRunnable> task = new HashMap<>();
    public static Map<Player, Integer> time = new HashMap<>();
    int cooldown = Config.getInstance().getInt("GAPPLECOOLDOWN");

    @EventHandler
    public void onItemConsume(final PlayerItemConsumeEvent e) {
        final Player p = e.getPlayer();
        if (e.getItem().getType() != Material.GOLDEN_APPLE) return;
        if (e.getItem().getDurability() == 0) return;
            if (time.containsKey(p)) {
                e.setCancelled(true);
                p.sendMessage( Config.getInstance().getString("Prefix").replace("&","§") + "You are still on cooldown for " + time.get(p) + " second(s)!");
                return;
            }
        time.put(p, cooldown);
        task.put(p, new BukkitRunnable() {
            @Override
            public void run() {
                if (time.get(p) == 0) {
                    task.remove(p);
                    time.remove(p);
                    cancel();
                    return;
                }
                time.put(p, time.get(p) - 1);
            }
        });
        task.get(p).runTaskTimer(Main.getInstance(), 20, 20);
    }
}


