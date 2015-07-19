package me.giantcrack.mpu.listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by shoot_000 on 6/13/2015.
 */
public class BowListener implements Listener {


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Arrow && e.getEntity() instanceof Player) {
            if (((Arrow) e.getDamager()).getShooter() instanceof Player) {
                Player damaged = (Player)e.getEntity();
                Player damager = (Player)((Arrow) e.getDamager()).getShooter();
                if (damaged.getUniqueId().equals(damager.getUniqueId())) {
                    e.setCancelled(true);
                }
            }
        }
    }

}
