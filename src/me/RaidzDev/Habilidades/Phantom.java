package me.RaidzDev.Habilidades;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import me.RaidzDev.Config;
import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class Phantom implements Listener {
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
				if (!Phantom.cooldownPhantom.containsKey(p.getName())
						|| Phantom.cooldownPhantom.get(p.getName()) <= System.currentTimeMillis()) {
					p.setAllowFlight(true);
					p.setFlying(true);
					p.sendMessage("§aVoc\u00ea ativou o kit !");
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
						@Override
						public void run() {
							p.setFlying(false);
							p.setAllowFlight(false);
							p.sendMessage("§cAsa Cortada !");
						}
					}, 100L);
					Phantom.cooldownPhantom.put(p.getName(),
							System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
				} else {
					p.sendMessage(Config.tempo);
				}
			}
		}
	}
}
