package me.giantcrack.mpu.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by shoot_000 on 7/9/2015.
 */
public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = (Player)e.getEntity();
        if (e.getEntity().getKiller() instanceof Player) {
            Player killer = (Player)p.getKiller();
            killer.sendMessage(ChatColor.GREEN + "You've killed " + p.getName());
            p.sendMessage(ChatColor.RED + killer.getName() + " has killed you");
        }
    }

}
