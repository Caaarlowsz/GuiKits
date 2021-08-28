package me.RaidzDev.Habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class Backpacker implements Listener {
	static List<String> cooldownbk;

	static {
		Backpacker.cooldownbk = new ArrayList<String>();
	}

	@EventHandler
	public void backpackerKit(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§eSopas");
		sopa.setItemMeta(sopas);
		if (p.getItemInHand().getType() == Material.NETHER_STAR && KitAPI.getkit(p) == "Backpacker") {
			if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Backpacker.cooldownbk.contains(p.getName())) {
				p.sendMessage("§cAguarde o Cooldown!");
				return;
			}
			Backpacker.cooldownbk.add(p.getName());
			final Inventory v = Bukkit.createInventory((InventoryHolder) null, 27, "§eBackpacker");
			for (int i = 0; i < 27; ++i) {
				v.addItem(new ItemStack[] { new ItemStack(sopa) });
			}
			event.getPlayer().openInventory(v);
			Backpacker.cooldownbk.add(p.getName());
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							Backpacker.cooldownbk.remove(p.getName());
						}
					}, 750L);
		}
	}
}
