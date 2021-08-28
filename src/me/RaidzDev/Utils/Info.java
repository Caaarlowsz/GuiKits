package me.RaidzDev.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RaidzDev.Config;

public class Info implements Listener {
	public static void abrirguiInforma\u00e7\u00e3o(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 27, "§7Informa\u00e7\u00e3o");
		final ItemStack vidro = new ItemStack(Material.getMaterial(160), 1, (short) 15);
		final ItemMeta zvidro = vidro.getItemMeta();
		zvidro.setDisplayName("§7§o-");
		vidro.setItemMeta(zvidro);
		final ItemStack vidro2 = new ItemStack(Material.getMaterial(160), 1, (short) 15);
		final ItemMeta zvidro2 = vidro2.getItemMeta();
		zvidro2.setDisplayName("§7§o-");
		vidro2.setItemMeta(zvidro2);
		final ItemStack fps = new ItemStack(Material.SKULL_ITEM);
		final ItemMeta zfps = fps.getItemMeta();
		zfps.setDisplayName("§7Coder");
		fps.setItemMeta(zfps);
		final ItemStack lava = new ItemStack(Material.BOOK_AND_QUILL);
		final ItemMeta zlava = lava.getItemMeta();
		zlava.setDisplayName("§7Dono do servidor");
		lava.setItemMeta(zlava);
		final ItemStack rdm = new ItemStack(Material.HOPPER);
		final ItemMeta zrdm = rdm.getItemMeta();
		zrdm.setDisplayName("§7Aplicar");
		rdm.setItemMeta(zrdm);
		final ItemStack mdr = new ItemStack(Material.TRIPWIRE_HOOK);
		final ItemMeta zmdr = mdr.getItemMeta();
		zmdr.setDisplayName("§7Caixa");
		mdr.setItemMeta(zmdr);
		inv.setItem(0, vidro2);
		inv.setItem(1, vidro2);
		inv.setItem(2, vidro2);
		inv.setItem(3, vidro2);
		inv.setItem(4, vidro2);
		inv.setItem(5, vidro);
		inv.setItem(6, vidro);
		inv.setItem(7, vidro);
		inv.setItem(8, vidro);
		inv.setItem(9, vidro2);
		inv.setItem(10, vidro);
		inv.setItem(11, fps);
		inv.setItem(12, lava);
		inv.setItem(13, vidro2);
		inv.setItem(14, mdr);
		inv.setItem(15, rdm);
		inv.setItem(16, vidro);
		inv.setItem(17, vidro);
		inv.setItem(18, vidro2);
		inv.setItem(19, vidro2);
		inv.setItem(20, vidro2);
		inv.setItem(21, vidro2);
		inv.setItem(22, vidro);
		inv.setItem(23, vidro);
		inv.setItem(24, vidro);
		inv.setItem(25, vidro);
		inv.setItem(26, vidro);
		p.openInventory(inv);
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§7Informa\u00e7\u00e3o") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("§7Plugin Criado por " + Config.cor + "RaidzDev §7Nick do minecraft " + Config.cor
						+ "RaidzDev§7.");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BOOK_AND_QUILL) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("§7Dono do servidor " + Config.cor + Config.dono + "§7.");
				return;
			}
			if (e.getCurrentItem().getType() == Material.HOPPER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/aplicar");
				return;
			}
			if (e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/caixa");
			}
		}
	}
}
