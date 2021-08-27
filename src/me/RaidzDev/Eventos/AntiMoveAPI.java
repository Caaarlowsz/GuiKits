package me.RaidzDev.Eventos;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.util.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class AntiMoveAPI implements Listener
{
    public static ArrayList<String> AntiMove1;
    public static ArrayList<String> AntiMove2;
    
    static {
        AntiMoveAPI.AntiMove1 = new ArrayList<String>();
        AntiMoveAPI.AntiMove2 = new ArrayList<String>();
    }
    
    @EventHandler
    public void Andar(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (AntiMoveAPI.AntiMove1.contains(p.getName())) {
            e.setCancelled(true);
        }
        if (AntiMoveAPI.AntiMove2.contains(p.getName())) {
            p.setVelocity(new Vector(0.0, -2.0, 0.0));
        }
    }
}
