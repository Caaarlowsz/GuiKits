package me.RaidzDev.Habilidades;

import java.util.Random;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.RaidzDev.Eventos.KitAPI;

public class Critical implements Listener {
	@EventHandler
	public void dano(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player p = (Player) e.getEntity();
			final Player d = (Player) e.getDamager();
			if (KitAPI.getkit(d) == "Critical") {
				final Random r = new Random();
				final int c = r.nextInt(100);
				if (c <= 30) {
					e.setDamage(e.getDamage() + 4.0);
					p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, (Object) Material.LAVA, 100);
					p.sendMessage("?7Voc\u00ea ganhou um golpe critico do ?c" + d.getName() + "?7.");
					d.sendMessage("?7Voc\u00ea deu um golpe critical em ?c" + p.getName());
				}
			}
		}
	}
}
