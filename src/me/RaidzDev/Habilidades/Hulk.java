package me.RaidzDev.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.Plugin;

import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class Hulk implements Listener {
	ArrayList<String> Hulk;
	ArrayList<String> Cooldown;

	public Hulk() {
		this.Hulk = new ArrayList<String>();
		this.Cooldown = new ArrayList<String>();
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onHulk(final PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (event.getRightClicked() instanceof Player) {
			final Player d = (Player) event.getRightClicked();
			if (KitAPI.getkit(p) == "Hulk" && p.getItemInHand().getType().equals((Object) Material.AIR)) {
				if (this.Cooldown.contains(p.getName())) {
					event.setCancelled(true);
					return;
				}
				if (p.getPassenger() == null) {
					p.setPassenger((Entity) d);
					this.Cooldown.add(p.getName());
				}
			}
		}
		if (this.Cooldown.contains(p.getName())) {
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
				@Override
				public void run() {
					me.RaidzDev.Habilidades.Hulk.this.Cooldown.remove(p.getName());
				}
			}, 120L);
		}
	}
}
