package me.RaidzDev.Utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RaidzDev.Config;
import me.RaidzDev.Main;
import me.RaidzDev.Eventos.ScoreBoard;
import me.RaidzDev.Eventos.Status;

public class Selector_LojaClasses implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("lclasses")) {
			final Player p = (Player) sender;
			money(p);
		}
		return false;
	}

	public static void money(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27,
				String.valueOf(Config.cor) + "Loja de Classes");
		final ItemStack vidro = new ItemStack(Material.getMaterial(160));
		final ItemMeta zvidro = vidro.getItemMeta();
		zvidro.setDisplayName("§7-");
		vidro.setItemMeta(zvidro);
		final ItemStack v = new ItemStack(Material.getMaterial(160));
		final ItemMeta zv = v.getItemMeta();
		zv.setDisplayName("§7-");
		v.setItemMeta(zv);
		final ItemStack n = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		final ItemMeta zn = n.getItemMeta();
		zn.setDisplayName("§7-");
		n.setItemMeta(zn);
		final ItemStack Stomper = new ItemStack(Material.IRON_BOOTS);
		final ItemMeta zStomper = Stomper.getItemMeta();
		zStomper.setDisplayName("§7Stomper");
		final ArrayList<String> descpyro = new ArrayList<String>();
		descpyro.add("§7PRE\u00c7O: §c150000");
		zStomper.setLore(descpyro);
		Stomper.setItemMeta(zStomper);
		final ItemStack Deshfire = new ItemStack(Material.REDSTONE_BLOCK);
		final ItemMeta zDeshfire = Deshfire.getItemMeta();
		zDeshfire.setDisplayName("§7Deshfire");
		final ArrayList<String> descpyros = new ArrayList<String>();
		descpyros.add("§7PRE\u00c7O: §c150000");
		zDeshfire.setLore(descpyros);
		Deshfire.setItemMeta(zDeshfire);
		final ItemStack Viking = new ItemStack(Material.STONE_AXE);
		final ItemMeta zViking = Viking.getItemMeta();
		zViking.setDisplayName("§7Viking");
		final ArrayList<String> descpyrosas = new ArrayList<String>();
		descpyrosas.add("§7PRE\u00c7O: §c150000");
		zViking.setLore(descpyrosas);
		Viking.setItemMeta(zViking);
		final ItemStack Gladiator = new ItemStack(Material.IRON_FENCE);
		final ItemMeta zGladiator = Gladiator.getItemMeta();
		zGladiator.setDisplayName("§7Gladiator");
		final ArrayList<String> descpyrosea = new ArrayList<String>();
		descpyrosea.add("§7PRE\u00c7O: §c150000");
		zGladiator.setLore(descpyrosea);
		Gladiator.setItemMeta(zGladiator);
		inv.setItem(0, vidro);
		inv.setItem(1, vidro);
		inv.setItem(2, v);
		inv.setItem(3, v);
		inv.setItem(4, v);
		inv.setItem(5, v);
		inv.setItem(6, v);
		inv.setItem(7, v);
		inv.setItem(8, v);
		inv.setItem(9, vidro);
		inv.setItem(10, Deshfire);
		inv.setItem(11, n);
		inv.setItem(12, Gladiator);
		inv.setItem(13, n);
		inv.setItem(14, Viking);
		inv.setItem(15, n);
		inv.setItem(16, Stomper);
		inv.setItem(17, vidro);
		inv.setItem(18, v);
		inv.setItem(19, v);
		inv.setItem(20, v);
		inv.setItem(21, v);
		inv.setItem(22, v);
		inv.setItem(23, v);
		inv.setItem(24, v);
		inv.setItem(25, vidro);
		inv.setItem(26, vidro);
		p.openInventory(inv);
	}

	@EventHandler
	public void click(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals(String.valueOf(Config.cor) + "Loja de Classes")) {
			if (e.getCurrentItem().getType() == Material.getMaterial(160)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7-")) {
				e.setCancelled(true);
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Coins §7" + Status.getMoney(p))) {
				e.setCancelled(true);
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Deshfire")) {
				e.setCancelled(true);
				p.closeInventory();
				final int money = Status.getMoney(p);
				if (p.hasPermission("kit.Deshfire")) {
					p.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea j\u00e1 tem esse kit.");
					return;
				}
				if (money >= 150000) {
					p.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea Acabou de Comprar o Kit " + Config.cor
							+ "Deshfire");
					Main.instance.getServer().dispatchCommand(
							(CommandSender) Main.instance.getServer().getConsoleSender(),
							"pex user " + p.getName() + " add kit.Deshfire");
					Status.removeMoney(p, 150000);
					ScoreBoard.onScoreboard(p);
					ScoreBoard.onScoreboard(p);
					return;
				}
				p.sendMessage(String.valueOf(Config.prefix)
						+ "§7Voc\u00ea precisa de 150000 de money para comprar esse kit.");
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Viking")) {
				e.setCancelled(true);
				p.closeInventory();
				final int money = Status.getMoney(p);
				if (p.hasPermission("kit.Viking")) {
					p.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea j\u00e1 tem esse kit.");
					return;
				}
				if (money >= 150000) {
					p.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea Acabou de Comprar o Kit " + Config.cor
							+ "Viking");
					Main.instance.getServer().dispatchCommand(
							(CommandSender) Main.instance.getServer().getConsoleSender(),
							"pex user " + p.getName() + " add kit.Viking");
					Status.removeMoney(p, 150000);
					ScoreBoard.onScoreboard(p);
					return;
				}
				p.sendMessage(String.valueOf(Config.prefix)
						+ "§7Voc\u00ea precisa de 150000 de money para comprar esse kit.");
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Gladiator")) {
				e.setCancelled(true);
				p.closeInventory();
				final int money = Status.getMoney(p);
				if (p.hasPermission("kit.Gladiator")) {
					p.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea j\u00e1 tem esse kit.");
					return;
				}
				if (money >= 150000) {
					p.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea Acabou de Comprar o Kit " + Config.cor
							+ "Gladiator");
					Main.instance.getServer().dispatchCommand(
							(CommandSender) Main.instance.getServer().getConsoleSender(),
							"pex user " + p.getName() + " add kit.Gladiator");
					Status.removeMoney(p, 150000);
					ScoreBoard.onScoreboard(p);
					return;
				}
				p.sendMessage(String.valueOf(Config.prefix)
						+ "§7Voc\u00ea precisa de 150000 de money para comprar esse kit.");
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stomper")) {
				e.setCancelled(true);
				p.closeInventory();
				final int money = Status.getMoney(p);
				if (p.hasPermission("kit.Stomper")) {
					p.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea j\u00e1 tem esse kit.");
					return;
				}
				if (money >= 150000) {
					p.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea Acabou de Comprar o Kit " + Config.cor
							+ "Stomper");
					Main.instance.getServer().dispatchCommand(
							(CommandSender) Main.instance.getServer().getConsoleSender(),
							"pex user " + p.getName() + " add kit.Stomper");
					Status.removeMoney(p, 150000);
					ScoreBoard.onScoreboard(p);
					return;
				}
				p.sendMessage(String.valueOf(Config.prefix)
						+ "§7Voc\u00ea precisa de 150000 de money para comprar esse kit.");
			}
		}
	}
}
