package me.RaidzDev.Eventos;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import me.RaidzDev.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.event.*;

public class Bussula implements Listener
{
    @EventHandler
    public void onCompass(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (p.getItemInHand().getType() == Material.COMPASS && (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)) {
            Boolean found = false;
            for (int i = 0; i < 1000; ++i) {
                final List entities = p.getNearbyEntities((double)i, 128.0, (double)i);
                for (final Object e : entities) {
                    if (((Entity)e).getType().equals((Object)EntityType.PLAYER) && p.getLocation().distance(((Entity)e).getLocation()) > 0.0) {
                        p.setCompassTarget(((Entity)e).getLocation());
                        p.sendMessage("§7Bussola Apontando Para " + Config.cor + ((Player)e).getName());
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (!found) {
                p.sendMessage("§cNenhum Jogador Foi Encontrado!");
                p.setCompassTarget(new Location(p.getWorld(), -420.0, 115.0, -271.0));
            }
        }
    }
}
