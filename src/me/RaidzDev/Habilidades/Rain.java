package me.RaidzDev.Habilidades;

import java.util.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import me.RaidzDev.Eventos.*;
import me.RaidzDev.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import org.bukkit.*;

public class Rain implements Listener
{
    public static ArrayList<String> rain;
    public static List<String> cooldown;
    
    static {
        Rain.rain = new ArrayList<String>();
        Rain.cooldown = new ArrayList<String>();
    }
    
    @EventHandler
    public void onHit(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Arrow) {
            e.setDamage(3.0);
        }
    }
    
    @EventHandler
    public void RainClick(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        final Player p = e.getPlayer();
        final Player r = (Player)e.getRightClicked();
        if (p.getItemInHand().getType() == Material.ARROW && KitAPI.getkit(p) == "Rain") {
            if (KitAPI.getkit(p) == "Rain" && Rain.cooldown.contains(p)) {
                p.sendMessage(Config.tempo);
                return;
            }
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc = r.getLocation();
                    loc.setY(loc.getY() + 2.5);
                    r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
                    final Entity arrow2 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.ARROW);
                }
            }, 40L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc2 = r.getLocation();
                    loc2.setY(loc2.getY() + 2.5);
                    r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
                    final Entity arrow3 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc2, EntityType.ARROW);
                }
            }, 35L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc3 = r.getLocation();
                    loc3.setY(loc3.getY() + 2.5);
                    r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
                    final Entity arrow4 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);
                }
            }, 30L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc3 = r.getLocation();
                    loc3.setY(loc3.getY() + 2.5);
                    r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
                    final Entity arrow4 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);
                }
            }, 25L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc3 = r.getLocation();
                    loc3.setY(loc3.getY() + 2.5);
                    r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
                    final Entity arrow4 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);
                }
            }, 20L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc4 = r.getLocation();
                    loc4.setY(loc4.getY() + 2.5);
                    r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
                    final Entity arrow5 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc4, EntityType.ARROW);
                }
            }, 5L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc6 = r.getLocation();
                    loc6.setY(loc6.getY() + 2.5);
                    r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
                    final Entity arrow6 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc6, EntityType.ARROW);
                }
            }, 3L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    final Location loc5 = r.getLocation();
                    loc5.setY(loc5.getY() + 2.5);
                    r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
                }
            }, 2L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Rain.rain.remove(p.getName());
                }
            }, 50L);
            Rain.cooldown.add(p.getName());
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Rain.cooldown.remove(p);
                    p.sendMessage(Config.jakit);
                    p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
                }
            }, 700L);
        }
    }
}
