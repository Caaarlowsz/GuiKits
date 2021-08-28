package me.RaidzDev.Habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.RaidzDev.Config;
import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class Rain implements Listener {
	public static ArrayList<String> rain;
	public static List<String> cooldown;

	static {
		Rain.rain = new ArrayList<String>();
		Rain.cooldown = new ArrayList<String>();
	}

	@EventHandler
	public void onHit(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Arrow) {
			e.setDamage(3.0);
		}
	}

	@EventHandler
	public void RainClick(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p = e.getPlayer();
		final Player r = (Player) e.getRightClicked();
		if (p.getItemInHand().getType() == Material.ARROW && KitAPI.getkit(p) == "Rain") {
			if (KitAPI.getkit(p) == "Rain" && Rain.cooldown.contains(p.getName())) {
				p.sendMessage(Config.tempo);
				return;
			}
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							final Location loc = r.getLocation();
							loc.setY(loc.getY() + 2.5);
							r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
							Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc,
									EntityType.ARROW);
						}
					}, 40L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							final Location loc2 = r.getLocation();
							loc2.setY(loc2.getY() + 2.5);
							r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
							Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc2,
									EntityType.ARROW);
						}
					}, 35L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							final Location loc3 = r.getLocation();
							loc3.setY(loc3.getY() + 2.5);
							r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
							Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3,
									EntityType.ARROW);
						}
					}, 30L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							final Location loc3 = r.getLocation();
							loc3.setY(loc3.getY() + 2.5);
							r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
							Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3,
									EntityType.ARROW);
						}
					}, 25L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							final Location loc3 = r.getLocation();
							loc3.setY(loc3.getY() + 2.5);
							r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
							Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3,
									EntityType.ARROW);
						}
					}, 20L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							final Location loc4 = r.getLocation();
							loc4.setY(loc4.getY() + 2.5);
							r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
							Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc4,
									EntityType.ARROW);
						}
					}, 5L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							final Location loc6 = r.getLocation();
							loc6.setY(loc6.getY() + 2.5);
							r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
							Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc6,
									EntityType.ARROW);
						}
					}, 3L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							final Location loc5 = r.getLocation();
							loc5.setY(loc5.getY() + 2.5);
							r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
						}
					}, 2L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							Rain.rain.remove(p.getName());
						}
					}, 50L);
			Rain.cooldown.add(p.getName());
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							Rain.cooldown.remove(p.getName());
							p.sendMessage(Config.jakit);
							p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
						}
					}, 700L);
		}
	}
}
