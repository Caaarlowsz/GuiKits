package me.RaidzDev.Habilidades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.RaidzDev.Eventos.KitAPI;

public class Viking implements Listener {
	@EventHandler
	public void Bater(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player t = (Player) e.getDamager();
			if (KitAPI.getkit(t) == "Viking") {
				e.setDamage(e.getDamage() + 3.5);
			}
		}
	}
}
