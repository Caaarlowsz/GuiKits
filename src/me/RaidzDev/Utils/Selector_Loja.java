package me.RaidzDev.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RaidzDev.Config;

public class Selector_Loja implements Listener, CommandExecutor {
	@EventHandler
	public void Warp(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.EMERALD && p.getItemInHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("§7» " + Config.cor + "Loja§7 «")) {
			p.chat("/loja");
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String CommandLabel,
			final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("Loja")) {
			final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 27, String.valueOf(Config.cor) + "Loja");
			final ItemStack vidro = new ItemStack(Material.getMaterial(160), 1, (short) 15);
			final ItemMeta zvidro = vidro.getItemMeta();
			zvidro.setDisplayName("§7-");
			vidro.setItemMeta(zvidro);
			final ItemStack vidro2 = new ItemStack(Material.getMaterial(160));
			final ItemMeta zvidro2 = vidro2.getItemMeta();
			zvidro2.setDisplayName("§7-");
			vidro2.setItemMeta(zvidro2);
			final ItemStack fps = new ItemStack(Material.STONE_SWORD);
			final ItemMeta zfps = fps.getItemMeta();
			zfps.setDisplayName("§7Classes");
			fps.setItemMeta(zfps);
			final ItemStack lava = new ItemStack(Material.POTION);
			final ItemMeta zlava = lava.getItemMeta();
			zlava.setDisplayName("§7Itens/Potions");
			lava.setItemMeta(zlava);
			final ItemStack lavas = new ItemStack(Material.PAPER);
			final ItemMeta zlavas = lavas.getItemMeta();
			zlavas.setDisplayName("§7Permiss\u00e3o");
			lavas.setItemMeta(zlavas);
			final ItemStack s = new ItemStack(Material.BOOK);
			final ItemMeta zs = s.getItemMeta();
			zs.setDisplayName("§7Site");
			s.setItemMeta(zs);
			inv.setItem(0, vidro2);
			inv.setItem(1, vidro2);
			inv.setItem(2, vidro2);
			inv.setItem(3, vidro2);
			inv.setItem(4, vidro2);
			inv.setItem(5, vidro2);
			inv.setItem(6, vidro2);
			inv.setItem(7, vidro2);
			inv.setItem(8, vidro2);
			inv.setItem(9, vidro2);
			inv.setItem(10, lavas);
			inv.setItem(11, vidro);
			inv.setItem(12, lava);
			inv.setItem(13, vidro);
			inv.setItem(14, fps);
			inv.setItem(15, vidro);
			inv.setItem(16, s);
			inv.setItem(17, vidro2);
			inv.setItem(18, vidro2);
			inv.setItem(19, vidro2);
			inv.setItem(20, vidro2);
			inv.setItem(21, vidro2);
			inv.setItem(22, vidro2);
			inv.setItem(23, vidro2);
			inv.setItem(24, vidro2);
			inv.setItem(25, vidro2);
			inv.setItem(26, vidro2);
			p.openInventory(inv);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase(String.valueOf(Config.cor) + "Loja")
				&& e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Site")) {
				p.closeInventory();
				p.sendMessage(Config.site);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Classes")) {
				p.closeInventory();
				p.chat("/lClasses");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Permiss\u00e3o")) {
				p.closeInventory();
				p.chat("/lpermi");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Itens/Potions")) {
				p.closeInventory();
				p.sendMessage("§cProxima att!");
			}
		}
	}
}
