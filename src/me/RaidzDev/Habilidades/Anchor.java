package me.RaidzDev.Habilidades;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class Anchor implements Listener {
	@EventHandler
	private void habilidadeAnchor(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player jogador = (Player) e.getEntity();
		final Player anchor = (Player) e.getDamager();
		if (KitAPI.getkit(jogador) == "Anchor") {
			jogador.setVelocity(new Vector());
			jogador.playSound(jogador.getLocation(), Sound.ANVIL_BREAK, 3.0f, 3.0f);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public final void run() {
					jogador.setVelocity(new Vector());
				}
			}, 1L);
		}
		if (KitAPI.getkit(jogador) == "Anchor") {
			anchor.playSound(anchor.getLocation(), Sound.ANVIL_BREAK, 3.0f, 3.0f);
			jogador.setVelocity(new Vector());
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(),
					(Runnable) new Runnable() {
						@Override
						public final void run() {
							jogador.setVelocity(new Vector());
						}
					}, 1L);
		}
	}
}
