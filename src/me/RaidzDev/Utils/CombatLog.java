package me.RaidzDev.Utils;

import java.util.*;
import org.bukkit.entity.*;
import me.RaidzDev.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;

public class CombatLog implements Listener
{
    public static ArrayList<String> cl;
    public static ArrayList<String> em;
    
    static {
        CombatLog.cl = new ArrayList<String>();
        CombatLog.em = new ArrayList<String>();
    }
    
    @EventHandler
    public void entrarCombate(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player damager = (Player)e.getDamager();
            if (Main.getInstance().configuracoes.getBoolean("CombatLog") && !CombatLog.em.contains(p.getName())) {
                if (!CombatLog.cl.contains(p.getName())) {
                    CombatLog.cl.add(p.getName());
                    p.sendMessage(String.valueOf(Config.prefix) + "Voce entrou em combate com: " + Config.cor + damager.getName() + ChatColor.GRAY + ". Nao podera fugir durante os proximos 10 segundos.");
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (CombatLog.cl.contains(p.getName())) {
                                CombatLog.cl.remove(p.getName());
                                if (p != null) {
                                    p.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea n\u00e3o esta mais em combate.");
                                }
                            }
                        }
                    }, 200L);
                }
                if (!CombatLog.cl.contains(damager.getName())) {
                    CombatLog.cl.add(damager.getName());
                    damager.sendMessage(String.valueOf(Config.prefix) + "Voce entrou em combate com: " + Config.cor + p.getName() + ChatColor.GRAY + ". Nao podera fugir durante os proximos 10 segundos.");
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (CombatLog.cl.contains(damager.getName())) {
                                CombatLog.cl.remove(damager.getName());
                                if (damager != null) {
                                    damager.sendMessage(String.valueOf(Config.prefix) + "Voce nao esta mais em combate.");
                                }
                            }
                        }
                    }, 200L);
                }
            }
        }
    }
    
    @EventHandler
    public void antiFuga(final PlayerCommandPreprocessEvent e) {
        if (CombatLog.cl.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(String.valueOf(Config.prefix) + "Voce est\u00e1 em combate. Aguarde para digitar comandos.");
        }
    }
    
    @EventHandler
    public void reset(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        if (CombatLog.cl.contains(p.getName())) {
            CombatLog.cl.remove(p.getName());
        }
    }
}
