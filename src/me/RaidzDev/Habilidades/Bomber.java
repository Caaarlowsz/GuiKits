package me.RaidzDev.Habilidades;

import org.bukkit.craftbukkit.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.event.block.*;
import me.RaidzDev.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class Bomber implements Listener
{
    public static Main plugin;
    public long cooldownLenght;
    
    public Bomber() {
        this.cooldownLenght = 0L;
    }
    
    @EventHandler
    public void eventBomber(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.TNT && KitAPI.getkit(p) == "Bomber") {
            if (Gladiator.gladgladiator.contains(p)) {
                return;
            }
            if (p.getItemInHand().getType() == Material.TNT && KitAPI.getkit(p) == "Bomber" && (e.getAction().equals((Object)Action.RIGHT_CLICK_AIR) || e.getAction().equals((Object)Action.RIGHT_CLICK_BLOCK))) {
                if (this.hasCooldown()) {
                    p.sendMessage(Config.tempo);
                    return;
                }
                final TNTPrimed tnt = (TNTPrimed)p.getWorld().spawn(p.getLocation(), (Class)TNTPrimed.class);
                tnt.setVelocity(p.getEyeLocation().getDirection().multiply(2.5));
                tnt.setFuseTicks(40);
                p.getLocation().getWorld().createExplosion(p.getLocation(), 4.0f);
                this.addCooldown(p, 30);
            }
        }
    }
    
    @EventHandler
    public void bomberDamage(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)event.getEntity();
        if (KitAPI.getkit(p) != "Bomber") {
            return;
        }
        if (event.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
            return;
        }
        event.setCancelled(true);
    }
    
    public void addCooldown(final Player player, final int seconds) {
        this.cooldownLenght = System.currentTimeMillis() + seconds * 1000;
    }
    
    public String cooldownTimeRemaining() {
        final long faltam = (this.cooldownLenght - System.currentTimeMillis()) / 1000L;
        if (faltam < 60L) {
            return String.valueOf(faltam) + " segundos restantes";
        }
        return String.valueOf(faltam) + " minutos restantes";
    }
    
    public boolean hasCooldown() {
        return this.cooldownLenght > System.currentTimeMillis();
    }
}
