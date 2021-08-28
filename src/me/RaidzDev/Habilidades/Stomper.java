package me.RaidzDev.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class Stomper implements Listener {
	public static ArrayList<Player> cooldown;

	static {
		Stomper.cooldown = new ArrayList<Player>();
	}

	@EventHandler
	public static void pulou(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (KitAPI.getkit(p) == "Stomper" && e.getCause() == EntityDamageEvent.DamageCause.FALL) {
				p.damage(1);
				if (e.getDamage() > 6.0) {
					for (final Entity s : p.getNearbyEntities(4.5, 1.0, 4.5)) {
						e.setDamage(1.0);
						if (s instanceof Player) {
							final Player t = (Player) s;
							if (!t.isSneaking()) {
								t.damage(999999, (Entity) p);
								e.setDamage(1.0);
							} else {
								t.damage(4, (Entity) p);
								e.setDamage(1.0);
							}
						}
					}
					e.setDamage(1.0);
				}
			}
		}
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.EMERALD_BLOCK && KitAPI.getkit(p) == "Stomper"
				&& (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
						|| event.getAction() == Action.RIGHT_CLICK_BLOCK
						|| event.getAction() == Action.RIGHT_CLICK_AIR)) {
			event.setCancelled(true);
			if (Stomper.cooldown.contains(p)) {
				p.sendMessage("§7Kit em cooldown!");
			} else {
				final Vector vector = p.getEyeLocation().getDirection();
				vector.multiply(0.0f);
				vector.setY(6.0f);
				p.setVelocity(vector);
				final Location loc = p.getLocation();
				p.getWorld().playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0f, -5.0f);
				Stomper.cooldown.add(p);
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
					@Override
					public void run() {
						if (Stomper.cooldown.contains(p)) {
							Stomper.cooldown.remove(p);
							p.sendMessage("§7Voc\u00ea j\u00e1 pode usar o kit novamente!");
						}
					}
				}, 800L);
			}
		}
	}
}
