package me.RaidzDev.Habilidades;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.RaidzDev.Eventos.KitAPI;

public class Poseidon implements Listener {
	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (KitAPI.getkit(p) == "Poseidon" && (p.getLocation().getBlock().getType() == Material.WATER
				|| p.getLocation().getBlock().getType() == Material.STATIONARY_WATER)) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 65, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 65, 0));
		}
	}
}
