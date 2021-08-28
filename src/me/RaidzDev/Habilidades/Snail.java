package me.RaidzDev.Habilidades;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.RaidzDev.Eventos.KitAPI;

public class Snail implements Listener {
	@EventHandler
	public void Bater(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player p = (Player) e.getEntity();
			final Player t = (Player) e.getDamager();
			if (KitAPI.getkit(t) == "Snail" && t.getItemInHand().getType() == Material.WOOD_SWORD
					&& new Random().nextInt(100) <= 25) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0, true));
			}
		}
	}
}
