package me.RaidzDev.Habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import me.RaidzDev.Config;
import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class Blink implements Listener {
	public static HashMap<Player, Integer> uso;
	HashMap<Location, Material> bloco;
	HashMap<Location, Byte> data;
	public static ArrayList<Player> noExecut;

	static {
		Blink.uso = new HashMap<Player, Integer>();
		Blink.noExecut = new ArrayList<Player>();
	}

	public Blink() {
		this.bloco = new HashMap<Location, Material>();
		this.data = new HashMap<Location, Byte>();
	}

	@EventHandler
	public void onInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitAPI.getkit(p) == "Blink" && p.getItemInHand().getType() == Material.GLOWSTONE_DUST
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			if (Gladiator.gladgladiator.contains(p.getName())) {
				e.setCancelled(true);
				p.sendMessage(Config.tempo);
			} else {
				if (Blink.uso.containsKey(p) && Blink.uso.get(p) == 2) {
					Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(),
							(Runnable) new Runnable() {
								@Override
								public void run() {
									Blink.uso.remove(p);
									p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, (Object) null);
									p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, (Object) null);
									p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, (Object) null);
									if (Blink.uso.containsKey(p)) {
										p.sendMessage(Config.jakit);
									}
								}
							}, 200L);
				}
				if (!Blink.uso.containsKey(p) || Blink.uso.get(p) != 3) {
					if (!Blink.uso.containsKey(p)) {
						Blink.uso.put(p, 1);
					} else {
						Blink.uso.put(p, Blink.uso.get(p) + 1);
					}
					final Block b = p.getTargetBlock(null, 5);
					final Location loc = b.getLocation();
					this.bloco.put(loc, b.getType());
					this.data.put(loc, b.getData());
					b.setType(Material.LEAVES);
					p.teleport(new Location(p.getWorld(), (double) b.getLocation().getBlockX(),
							(double) (b.getLocation().getBlockY() + 1), (double) b.getLocation().getBlockZ(),
							p.getLocation().getYaw(), p.getLocation().getPitch()));
					final Material bloco = this.bloco.get(loc);
					final Byte data = this.data.get(loc);
					p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 5.0f, -5.0f);
					Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(),
							(Runnable) new Runnable() {
								@Override
								public void run() {
									b.setType(bloco);
									b.setData((byte) data);
								}
							}, 100L);
					return;
				}
				p.sendMessage("?7Kit em Cooldown!");
			}
		}
	}
}
