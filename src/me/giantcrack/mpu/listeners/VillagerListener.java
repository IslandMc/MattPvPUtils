package me.giantcrack.mpu.listeners;

import me.giantcrack.mpu.Config;
import me.giantcrack.mpu.Main;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/**
 * Created by shoot_000 on 6/13/2015.
 */
public class VillagerListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Villager) {
            e.setCancelled(true);
            p.sendMessage(Config.getInstance().getString("Prefix").replace("&","§") + "Villagers are disabled!");
            p.playSound(p.getLocation(), Sound.GHAST_SCREAM,10f,10f);
        }
    }

}
