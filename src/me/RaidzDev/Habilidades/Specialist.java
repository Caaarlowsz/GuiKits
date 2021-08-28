package me.RaidzDev.Habilidades;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.RaidzDev.Config;
import me.RaidzDev.Eventos.KitAPI;

public class Specialist implements Listener {
	@EventHandler
	public void Clicar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getMaterial() == Material.BOOK && e.getItem().getType() == Material.BOOK
				&& KitAPI.getkit(p) == "Specialist") {
			p.openEnchanting(p.getLocation(), true);
		}
	}

	@EventHandler
	public void Matar(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		final Player t = e.getEntity().getKiller();
		if (p instanceof Player && t instanceof Player && KitAPI.getkit(t) == "Specialist") {
			t.sendMessage("Voc\u00ea ganhou 1 pote de xp por matar: " + Config.cor + p.getName());
			t.getInventory().setItem(8, new ItemStack(Material.EXP_BOTTLE));
		}
	}
}
