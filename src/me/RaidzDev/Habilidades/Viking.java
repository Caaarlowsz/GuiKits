package me.RaidzDev.Habilidades;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.event.*;

public class Viking implements Listener
{
    @EventHandler
    public void Bater(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player t = (Player)e.getDamager();
            if (KitAPI.getkit(t) == "Viking") {
                e.setDamage(e.getDamage() + 3.5);
            }
        }
    }
}
