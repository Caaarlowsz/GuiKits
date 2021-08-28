package me.RaidzDev.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.RaidzDev.Config;
import me.RaidzDev.Main;
import me.RaidzDev.Comandos.Admin;
import me.RaidzDev.Eventos.KitAPI;

public class Firer implements Listener {
	ArrayList<String> Pegos;
	ArrayList<String> Cooldown;

	public Firer() {
		this.Pegos = new ArrayList<String>();
		this.Cooldown = new ArrayList<String>();
	}

	@EventHandler
	public void onShift(final PlayerToggleSneakEvent event) {
		final Player p = event.getPlayer();
		if (KitAPI.getkit(p) == "Firer") {
			if (this.Cooldown.contains(p.getName())) {
				p.sendMessage(Config.tempo);
			} else {
				for (final Entity e : p.getNearbyEntities(10.0, 10.0, 10.0)) {
					if (e instanceof Player && !Main.Watch.contains(((Player) e).getName())) {
						if (Admin.admin.contains(p.getName())) {
							continue;
						}
						e.setFireTicks(100);
						this.Cooldown.add(p.getName());
						this.Pegos.add(((Player) e).getPlayer().getName());
						((Player) e).getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 170, 2));
						((Player) e).getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 170, 2));
						p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 170, 2));
						p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 170, 2));
						((Player) e).getPlayer().sendMessage("§cVoce foi atingido por 1 firer");
						p.sendMessage("§aTodos ao seu redor foram atingidos!");
						Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
								(Runnable) new Runnable() {
									@Override
									public void run() {
										Firer.this.Cooldown.remove(p.getName());
									}
								}, 750L);
					}
				}
			}
		}
	}
}
