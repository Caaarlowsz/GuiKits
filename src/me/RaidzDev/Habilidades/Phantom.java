package me.RaidzDev.Habilidades;

import java.util.*;
import org.bukkit.event.player.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import java.util.concurrent.*;
import me.RaidzDev.*;
import org.bukkit.event.*;

public class Phantom implements Listener
{
    public static HashMap<String, Long> cooldownPhantom;
    
    static {
        Phantom.cooldownPhantom = new HashMap<String, Long>();
    }
    
    @EventHandler
    public void voar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction().name().contains("RIGHT") && p.getItemInHand().getType() == Material.FEATHER) {
            e.setCancelled(true);
            p.updateInventory();
            if (KitAPI.getkit(p) == "Phantom") {
                if (!Phantom.cooldownPhantom.containsKey(p.getName()) || Phantom.cooldownPhantom.get(p.getName()) <= System.currentTimeMillis()) {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage("§aVoc\u00ea ativou o kit !");
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            p.setFlying(false);
                            p.setAllowFlight(false);
                            p.sendMessage("§cAsa Cortada !");
                        }
                    }, 100L);
                    Phantom.cooldownPhantom.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
                }
                else {
                    p.sendMessage(Config.tempo);
                }
            }
        }
    }
}
