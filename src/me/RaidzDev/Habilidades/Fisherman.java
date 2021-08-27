package me.RaidzDev.Habilidades;

import org.bukkit.event.player.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Fisherman implements Listener
{
    @EventHandler
    public void Pescar(final PlayerFishEvent e) {
        final Player p = e.getPlayer();
        if (e.getCaught() instanceof Player && KitAPI.getkit(p) == "Fisherman") {
            final Player t = (Player)e.getCaught();
            t.teleport((Entity)p);
            e.setCancelled(false);
        }
    }
}
