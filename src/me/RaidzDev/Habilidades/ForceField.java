package me.RaidzDev.Habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import me.RaidzDev.Config;
import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class ForceField implements Listener {
	public static ArrayList<Player> cooldown;
	public static ArrayList<Player> noFF;

	static {
		ForceField.cooldown = new ArrayList<Player>();
		ForceField.noFF = new ArrayList<Player>();
	}

	public static void Force(final Player p) {
		if (!Main.areaPvP(p)) {
			return;
		}
		final Location local = p.getLocation();
		final List<Entity> Inimigos = (List<Entity>) local.getWorld().getEntities();
		for (final Entity e : Inimigos) {
			if (e.getLocation().distance(local) < 6.0 && e instanceof Player) {
				final Player d = (Player) e;
				if (d == p) {
					continue;
				}
				d.damage(1.2);
			}
		}
	}

	@EventHandler
	public void Interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitAPI.getkit(p) == "ForceField" && e.getAction() == Action.RIGHT_CLICK_AIR
				&& p.getItemInHand().getType() == Material.NETHER_FENCE) {
			if (ForceField.cooldown.contains(p)) {
				p.sendMessage(Config.tempo);
				return;
			}
			ForceField.cooldown.add(p);
			ForceField.noFF.add(p);
			p.sendMessage("§aForcefield Ativado!");
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.getInstance(),
					(Runnable) new Runnable() {
						@Override
						public void run() {
							if (ForceField.noFF.contains(p)) {
								ForceField.Force(p);
							}
						}
					}, 1L, 1L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(),
					(Runnable) new Runnable() {
						@Override
						public void run() {
							ForceField.noFF.remove(p);
						}
					}, 135L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(),
					(Runnable) new Runnable() {
						@Override
						public void run() {
							ForceField.cooldown.remove(p);
							p.sendMessage(Config.jakit);
							p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
						}
					}, 300L);
		}
	}
}
