package me.giantcrack.mpu.listeners;

import me.giantcrack.mpu.Config;
import me.giantcrack.mpu.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

/**
 * Created by shoot_000 on 6/13/2015.
 */
public class PotionListener implements Listener {

    public static List<String> disabled = Config.getInstance().getList("DisabledPotions");

    @EventHandler
    public void onPotionInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getItem() != null) {
            if (e.getItem().getType() == Material.POTION) {
                if (disabled.contains(String.valueOf(e.getItem().getDurability()))) {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage( Config.getInstance().getString("Prefix").replace("&","§") + "That potion is disabled!");
                }
            }
        }
    }


}
