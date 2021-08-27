package me.RaidzDev.Habilidades;

import org.bukkit.event.player.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Lavaman implements Listener
{
    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.getkit(p) == "Lavaman" && (p.getLocation().getBlock().getType() == Material.LAVA || p.getLocation().getBlock().getType() == Material.STATIONARY_LAVA)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 65, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 65, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 130, 0));
        }
        else if (KitAPI.getkit(p) == "Lavaman" && (p.getLocation().getBlock().getType() == Material.WATER || p.getLocation().getBlock().getType() == Material.STATIONARY_WATER)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 65, 2));
        }
    }
}
