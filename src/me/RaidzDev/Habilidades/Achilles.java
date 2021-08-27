package me.RaidzDev.Habilidades;

import java.util.*;
import org.bukkit.entity.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.*;
import me.RaidzDev.*;
import org.bukkit.plugin.*;

public class Achilles implements Listener
{
    public static HashMap<Player, Player> hit;
    
    static {
        Achilles.hit = new HashMap<Player, Player>();
    }
    
    @EventHandler
    public void damage(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (KitAPI.getkit(p) == "Achilles") {
                return;
            }
            if (e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                e.setDamage(e.getDamage() / 2.0);
            }
        }
    }
    
    @EventHandler
    public void onachillesDamage(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player d = (Player)e.getDamager();
            if (KitAPI.getkit(p) == "Achilles") {
                if (d.isSneaking()) {
                    e.setDamage(e.getDamage() * 2.0);
                }
                else {
                    e.setDamage(e.getDamage() / 10.0);
                    if (Achilles.hit.get(d) == null || Achilles.hit.get(d) != p) {
                        Achilles.hit.put(d, p);
                        d.sendMessage(String.valueOf(Config.prefix) + " §cEsse player \u00e9 um achilles se abaixe para dar mais dano nele!");
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                if (Achilles.hit.get(d) == p) {
                                    Achilles.hit.remove(d);
                                }
                            }
                        }, 200L);
                    }
                }
            }
        }
    }
}
