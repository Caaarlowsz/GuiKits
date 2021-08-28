package me.RaidzDev.Habilidades;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.RaidzDev.Eventos.KitAPI;

public class Reaper implements Listener {
	@EventHandler
	public void OnClick(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player damager = (Player) e.getDamager();
			final Player victim = (Player) e.getEntity();
			if (KitAPI.getkit(damager) == "Reaper") {
				KitAPI.getkit(damager);
				if (damager.getInventory().getItemInHand().getType() == Material.WOOD_HOE) {
					victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3));
				}
			}
		}
	}
}
