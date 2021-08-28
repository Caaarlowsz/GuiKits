package me.RaidzDev.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;

import me.RaidzDev.Config;
import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class Thor implements Listener {
	public static ArrayList<Player> cooldown;

	static {
		Thor.cooldown = new ArrayList<Player>();
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitAPI.getkit(p) == "Thor"
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			final WorldGuardPlugin worldGuard = Main.getWorldGuard();
			final RegionManager regionManager = worldGuard.getRegionManager(p.getWorld());
			final ApplicableRegionSet set = regionManager.getApplicableRegions(p.getLocation());
			if (set.allows(DefaultFlag.PVP)) {
				final ItemStack hand = p.getItemInHand();
				if (hand.getType() == Material.GOLD_AXE) {
					if (Thor.cooldown.contains(p)) {
						p.sendMessage(Config.tempo);
					} else {
						final Location loc = p.getTargetBlock(null, 20).getLocation();
						p.getWorld().strikeLightning(loc);
						Thor.cooldown.add(p);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
								(Runnable) new Runnable() {
									@Override
									public void run() {
										Thor.cooldown.remove(p);
										p.sendMessage(Config.jakit);
									}
								}, 120L);
					}
				}
			}
		}
	}
}
