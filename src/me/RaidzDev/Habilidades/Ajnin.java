package me.RaidzDev.Habilidades;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;

import me.RaidzDev.Config;
import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class Ajnin implements Listener {
	public HashMap<Player, Player> a;
	public HashMap<Player, Long> b;

	public Ajnin() {
		this.a = new HashMap<Player, Player>();
		this.b = new HashMap<Player, Long>();
	}

	@EventHandler
	public void a(final EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
		if (paramEntityDamageByEntityEvent.getDamager() instanceof Player
				&& paramEntityDamageByEntityEvent.getEntity() instanceof Player) {
			final Player localPlayer1 = (Player) paramEntityDamageByEntityEvent.getDamager();
			final Player localPlayer2 = (Player) paramEntityDamageByEntityEvent.getEntity();
			if (KitAPI.getkit(localPlayer1) == "Ajnin") {
				this.a.put(localPlayer1, localPlayer2);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(),
						(Runnable) new Runnable() {
							@Override
							public void run() {
								Backpacker.cooldownbk.remove(localPlayer1.getName());
							}
						}, 100L);
			}
		}
	}

	@EventHandler
	public void a(final PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
		final Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
		if (paramPlayerToggleSneakEvent.isSneaking() && KitAPI.getkit(localPlayer1) == "Ajnin"
				&& this.a.containsKey(localPlayer1)) {
			final Player localPlayer2 = this.a.get(localPlayer1);
			if (localPlayer2 != null && !localPlayer2.isDead()) {
				if (this.b.get(localPlayer1) != null) {
				}
				if (this.b.get(localPlayer1) == null || this.b.get(localPlayer1) < System.currentTimeMillis()) {
					if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0) {
						localPlayer2.teleport(localPlayer1.getLocation());
						localPlayer2.sendMessage(
								"§7Voc\u00ea foi teletransportado para: " + Config.cor + localPlayer1.getName());
						this.b.put(localPlayer1, System.currentTimeMillis() + 10000L);
					} else {
						localPlayer1.sendMessage("§cJogador Est\u00e1 Muito Longe");
					}
				} else {
					localPlayer1.sendMessage(Config.tempo);
				}
			}
		}
	}
}
