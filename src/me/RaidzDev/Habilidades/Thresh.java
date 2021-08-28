package me.RaidzDev.Habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import me.RaidzDev.Config;
import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class Thresh implements Listener {
	public static List<Player> cooldownm;

	static {
		Thresh.cooldownm = new ArrayList<Player>();
	}

	@EventHandler
	public void BloodClick(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.BLAZE_ROD
				&& KitAPI.getkit(event.getPlayer()) == "Thresh") {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
				event.setCancelled(true);
			}
			if (Thresh.cooldownm.contains(p)) {
				p.sendMessage(Config.tempo);
			} else {
				final Vector velo1 = p.getLocation().getDirection().normalize().multiply(30);
				final Snowball boladenve = (Snowball) p.launchProjectile(Snowball.class);
				boladenve.setVelocity(velo1);
				final Location location = p.getEyeLocation();
				final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 30);
				while (blocksToAdd.hasNext()) {
					final Location blockToAdd = blocksToAdd.next().getLocation();
					p.getWorld().playEffect(blockToAdd, Effect.SMOKE, 5);
					Thresh.cooldownm.add(p);
					Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
						@Override
						public void run() {
							Thresh.cooldownm.remove(p);
						}
					}, 200L);
				}
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
					@Override
					public void run() {
						p.sendMessage(Config.jakit);
					}
				}, 200L);
			}
		}
	}

	@EventHandler
	public void DanoOstenta$aum(final EntityDamageByEntityEvent e) {
		final Entity ent = e.getEntity();
		final Entity damager = e.getDamager();
		if (ent instanceof Player) {
			final Player hit = (Player) ent;
			if (damager instanceof Snowball) {
				final Snowball snowball = (Snowball) damager;
				if (snowball.getShooter() instanceof Player) {
					final Player shooter = (Player) snowball.getShooter();
					if (KitAPI.getkit(shooter) == "Thresh") {
						return;
					}
					hit.teleport(shooter.getLocation());
					hit.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
					hit.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
				}
			}
		}
	}
}
