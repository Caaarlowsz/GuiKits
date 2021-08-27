package me.RaidzDev.Habilidades;

import me.RaidzDev.*;
import org.bukkit.entity.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.potion.*;
import org.bukkit.event.entity.*;

public class Magma implements Listener
{
    public static Main plugin;
    
    public Magma(final Main main) {
        Magma.plugin = main;
    }
    
    public Magma() {
    }
    
    @EventHandler
    public void viperEvent(final EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getDamager();
        final Player player2 = (Player)event.getEntity();
        if (KitAPI.getkit(player) != "Magma") {
            return;
        }
        if (Math.random() > 0.4 && Math.random() < 0.1) {
            player2.setFireTicks(100);
        }
    }
    
    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent event1) {
        final Player player11 = event1.getPlayer();
        if (KitAPI.getkit(player11) == "Magma'" && (player11.getLocation().getBlock().getType() == Material.WATER || player11.getLocation().getBlock().getType() == Material.STATIONARY_WATER)) {
            player11.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 65, 0));
            player11.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 65, 0));
        }
    }
    
    @EventHandler
    public void damage(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (KitAPI.getkit(p) == "Magma" && (e.getCause() == EntityDamageEvent.DamageCause.LAVA || e.getCause() == EntityDamageEvent.DamageCause.FIRE || e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)) {
                e.setCancelled(true);
            }
        }
    }
}
