package me.RaidzDev.Eventos;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.util.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.block.*;
import org.bukkit.*;
import org.bukkit.potion.*;

public class Jumps implements Listener
{
    public static ArrayList<String> jump;
    ArrayList<String> nofalldamage;
    ArrayList<String> nofalldamagewait;
    
    static {
        Jumps.jump = new ArrayList<String>();
    }
    
    public Jumps() {
        this.nofalldamage = new ArrayList<String>();
        this.nofalldamagewait = new ArrayList<String>();
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJump1(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_BLOCK) {
            Jumps.jump.remove(p.getName());
            final Vector sponge = p.getLocation().getDirection().multiply(0).setY(5);
            p.setVelocity(sponge);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            Jumps.jump.add(p.getName());
            Jumps.jump.remove(p.getName());
            Jumps.jump.add(p.getName());
        }
    }
    
    @EventHandler
    public void onPlayerDamageCoisaBugada(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (Jumps.jump.contains(p.getName())) {
            Jumps.jump.remove(p.getName());
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageSponge(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getEntity();
        final Location loc = player.getLocation();
        final Location below = loc.subtract(0.0, 3.0, 0.0);
        final Block blockBelow = below.getBlock();
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (blockBelow.getType() == Material.DIAMOND_BLOCK) {
            Jumps.jump.add(player.getName());
            event.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJump111(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE) {
            Jumps.jump.remove(p.getName());
            final Vector sponge = p.getLocation().getDirection().multiply(0).setY(1);
            p.setVelocity(sponge);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            Jumps.jump.add(p.getName());
            Jumps.jump.remove(p.getName());
            Jumps.jump.add(p.getName());
        }
    }
    
    @EventHandler
    public void onPlayerDamageCoisaBugada111(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (Jumps.jump.contains(p.getName())) {
            Jumps.jump.remove(p.getName());
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageSponge11(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getEntity();
        final Location loc = player.getLocation();
        final Location below = loc.subtract(0.0, 3.0, 0.0);
        final Block blockBelow = below.getBlock();
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (blockBelow.getType() == Material.DIAMOND_BLOCK) {
            Jumps.jump.add(player.getName());
            event.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJump1a(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE) {
            Jumps.jump.remove(p.getName());
            final Vector sponge = p.getLocation().getDirection().multiply(0).setY(2);
            p.setVelocity(sponge);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            Jumps.jump.add(p.getName());
            Jumps.jump.remove(p.getName());
            Jumps.jump.add(p.getName());
            p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        }
    }
    
    @EventHandler
    public void onPlayerDamageCoisaBugada1(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (Jumps.jump.contains(p.getName())) {
            Jumps.jump.remove(p.getName());
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageSpongea(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getEntity();
        final Location loc = player.getLocation();
        final Location below = loc.subtract(0.0, 3.0, 0.0);
        final Block blockBelow = below.getBlock();
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (blockBelow.getType() == Material.SPONGE) {
            Jumps.jump.add(player.getName());
            event.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJump1a1111(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK) {
            Jumps.jump.remove(p.getName());
            final Vector sponge = p.getLocation().getDirection().multiply(0).setY(3);
            p.setVelocity(sponge);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0f, 2.0f);
            Jumps.jump.add(p.getName());
            Jumps.jump.remove(p.getName());
            Jumps.jump.add(p.getName());
            p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        }
    }
    
    @EventHandler
    public void onPlayerDamageCoisaBugada11111(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (Jumps.jump.contains(p.getName())) {
            Jumps.jump.remove(p.getName());
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageSpongea111111(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getEntity();
        final Location loc = player.getLocation();
        final Location below = loc.subtract(0.0, 3.0, 0.0);
        final Block blockBelow = below.getBlock();
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (blockBelow.getType() == Material.SPONGE) {
            Jumps.jump.add(player.getName());
            event.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerSpongeDamage(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (Jumps.jump.contains(p.getName())) {
            Jumps.jump.remove(p.getName());
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onPlayerFrente(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.REDSTONE_BLOCK) {
            final Location loc = e.getTo().getBlock().getLocation();
            p.playSound(loc, Sound.ENDERDRAGON_HIT, 6.0f, 1.0f);
            p.playEffect(loc, Effect.MOBSPAWNER_FLAMES, (Object)null);
            final Vector sponge = p.getLocation().getDirection().multiply(3.5).setY(0.35);
            p.setVelocity(sponge);
            Jumps.jump.add(p.getName());
        }
    }
    
    @EventHandler
    public void onPlayerDamageSponge1(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (Jumps.jump.contains(p.getName())) {
            Jumps.jump.remove(p.getName());
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageSponge1(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getEntity();
        final Location loc = player.getLocation();
        final Location below = loc.subtract(0.0, 1.0, 0.0);
        final Block blockBelow = below.getBlock();
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (blockBelow.getType() == Material.SPONGE) {
            Jumps.jump.add(player.getName());
            event.setDamage(0.0);
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onPlayerJumpBaixo(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.PISTON_BASE) {
            final Vector sponge = p.getLocation().getDirection().multiply(0).setY(1);
            p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 1);
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 999));
            p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0f, 1.0f);
            p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0f, 1.0f);
            p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0f, 1.0f);
            p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0f, 1.0f);
            p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0f, 1.0f);
            p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0f, 1.0f);
            p.setVelocity(sponge);
            if (!this.nofalldamage.contains(p.getName())) {
                this.nofalldamage.add(p.getName());
            }
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            final Player player = (Player)event.getEntity();
            if (this.nofalldamage.contains(player.getName()) && event.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL)) {
                event.setCancelled(true);
                this.nofalldamage.remove(player.getName());
            }
        }
    }
}
