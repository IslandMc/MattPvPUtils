package me.giantcrack.mpu.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by shoot_000 on 6/13/2015.
 */
public class DispenserListener implements Listener {

    @EventHandler
    public void onDispense(BlockDispenseEvent e) {
        ItemStack i = e.getItem();
        if (i.getType() != Material.POTION) return;
        if (PotionListener.disabled.contains(String.valueOf(i.getDurability()))) {
            e.setCancelled(true);
        }
    }

}
