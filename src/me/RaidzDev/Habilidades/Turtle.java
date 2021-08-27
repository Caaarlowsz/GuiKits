package me.RaidzDev.Habilidades;

import org.bukkit.entity.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class Turtle implements Listener
{
    @EventHandler
    public void LevouDano(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (KitAPI.getkit(p) == "Turtle" && p.isSneaking()) {
                e.setDamage(2.5);
            }
        }
    }
    
    @EventHandler
    public void DeuDan(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getDamager();
            if (KitAPI.getkit(p) == "Turtle" && p.isSneaking()) {
                e.setDamage(1);
            }
        }
    }
}
