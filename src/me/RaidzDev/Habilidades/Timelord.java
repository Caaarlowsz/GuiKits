package me.RaidzDev.Habilidades;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.*;
import me.RaidzDev.*;
import org.bukkit.plugin.*;
import java.util.*;
import org.bukkit.event.*;

public class Timelord implements Listener
{
    public static ArrayList<String> cooldown;
    
    static {
        Timelord.cooldown = new ArrayList<String>();
    }
    
    @EventHandler
    public void Clicar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.getkit(p) == "Timelord" && e.getMaterial() == Material.WATCH) {
            if (Timelord.cooldown.contains(p.getName())) {
                p.sendMessage(Config.tempo);
                return;
            }
            Timelord.cooldown.add(p.getName());
            p.sendMessage("§7Voc\u00ea congelou todos os Jogadores perto de voc\u00ea");
            p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0f, 1.0f);
            p.playSound(p.getLocation(), Sound.EXPLODE, 1.0f, 1.0f);
            for (final Entity ent : p.getNearbyEntities(5.0, 3.0, 5.0)) {
                if (ent instanceof Player) {
                    final Player t = (Player)ent;
                    AntiMoveAPI.AntiMove1.add(t.getName());
                    t.sendMessage("§7Voc\u00ea foi congelado por um timelord");
                    t.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0f, 1.0f);
                    p.sendMessage("§7Voc\u00ea congelou §c" + t.getDisplayName());
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (AntiMoveAPI.AntiMove1.contains(t.getName())) {
                                AntiMoveAPI.AntiMove1.remove(t.getName());
                                t.sendMessage("§cVoc\u00ea foi descongelado");
                            }
                        }
                    }, 200L);
                }
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (KitAPI.getkit(p) == "Timelord") {
                        p.sendMessage(Config.jakit);
                        Timelord.cooldown.remove(p.getName());
                    }
                }
            }, 400L);
        }
    }
}
