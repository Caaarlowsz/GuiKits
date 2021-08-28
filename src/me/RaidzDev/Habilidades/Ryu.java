package me.RaidzDev.Habilidades;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import me.RaidzDev.Config;
import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class Ryu implements Listener {
	public static HashMap<String, Long> cooldown;

	static {
		Ryu.cooldown = new HashMap<String, Long>();
	}

	@EventHandler
	public void hadouken(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& KitAPI.getkit(p) == "Ryu" && p.getItemInHand().getType() == Material.BEACON) {
			if (!Ryu.cooldown.containsKey(p.getName()) || Ryu.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				final Location location = p.getEyeLocation();
				final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 40);
				while (blocksToAdd.hasNext()) {
					final Location blockToAdd = blocksToAdd.next().getLocation();
					p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.BEACON, 20);
					p.playSound(blockToAdd, Sound.IRONGOLEM_THROW, 3.0f, 3.0f);
				}
				final Snowball h = (Snowball) p.launchProjectile(Snowball.class);
				final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
				h.setVelocity(velo1);
				h.setMetadata("hadouken",
						(MetadataValue) new FixedMetadataValue((Plugin) Main.instance, (Object) true));
				Ryu.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
				return;
			}
			p.sendMessage(Config.tempo);
		}
	}

	@EventHandler
	public void dano(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Snowball) {
			final Snowball s = (Snowball) e.getDamager();
			if (s.hasMetadata("hadouken")) {
				e.setDamage(e.getDamage() + 7.0);
			}
		}
	}
}
