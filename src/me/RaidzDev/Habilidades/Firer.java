package me.RaidzDev.Habilidades;

import org.bukkit.event.player.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.entity.*;
import me.RaidzDev.*;
import me.RaidzDev.Comandos.*;
import org.bukkit.potion.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import java.util.*;
import org.bukkit.event.*;

public class Firer implements Listener
{
    ArrayList<String> Pegos;
    ArrayList<String> Cooldown;
    
    public Firer() {
        this.Pegos = new ArrayList<String>();
        this.Cooldown = new ArrayList<String>();
    }
    
    @EventHandler
    public void onShift(final PlayerToggleSneakEvent event) {
        final Player p = event.getPlayer();
        if (KitAPI.getkit(p) == "Firer") {
            if (this.Cooldown.contains(p.getName())) {
                p.sendMessage(Config.tempo);
            }
            else {
                for (final Entity e : p.getNearbyEntities(10.0, 10.0, 10.0)) {
                    if (e instanceof Player && !Main.Watch.contains(((Player)e).getName())) {
                        if (Admin.admin.contains(p.getName())) {
                            continue;
                        }
                        e.setFireTicks(100);
                        this.Cooldown.add(p.getName());
                        this.Pegos.add(((Player)e).getPlayer().getName());
                        ((Player)e).getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 170, 2));
                        ((Player)e).getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 170, 2));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 170, 2));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 170, 2));
                        ((Player)e).getPlayer().sendMessage("§cVoce foi atingido por 1 firer");
                        p.sendMessage("§aTodos ao seu redor foram atingidos!");
                        Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                Firer.this.Cooldown.remove(p.getName());
                            }
                        }, 750L);
                    }
                }
            }
        }
    }
}
