package me.RaidzDev.Habilidades;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import me.RaidzDev.Eventos.KitAPI;

public class Fisherman implements Listener {
	@EventHandler
	public void Pescar(final PlayerFishEvent e) {
		final Player p = e.getPlayer();
		if (e.getCaught() instanceof Player && KitAPI.getkit(p) == "Fisherman") {
			final Player t = (Player) e.getCaught();
			t.teleport((Entity) p);
			e.setCancelled(false);
		}
	}
}
