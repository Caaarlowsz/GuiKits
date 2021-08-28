package me.RaidzDev.Eventos;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.RaidzDev.Config;

public class Bussula implements Listener {
	@EventHandler
	public void onCompass(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.COMPASS && (event.getAction() == Action.LEFT_CLICK_AIR
				|| event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK
				|| event.getAction() == Action.RIGHT_CLICK_AIR)) {
			Boolean found = false;
			for (int i = 0; i < 1000; ++i) {
				final List<Entity> entities = p.getNearbyEntities((double) i, 128.0, (double) i);
				for (final Object e : entities) {
					if (((Entity) e).getType().equals((Object) EntityType.PLAYER)
							&& p.getLocation().distance(((Entity) e).getLocation()) > 0.0) {
						p.setCompassTarget(((Entity) e).getLocation());
						p.sendMessage("§7Bussola Apontando Para " + Config.cor + ((Player) e).getName());
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
