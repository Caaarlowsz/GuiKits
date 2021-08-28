package me.RaidzDev.Eventos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RaidzDev.Config;

public class KitAPI implements Listener {
	public static ItemStack sopa;
	public static ItemMeta sopameta;
	public static ItemStack cogu1;
	public static ItemMeta cogu1meta;
	public static ItemStack cogu2;
	public static ItemMeta cogu2meta;
	public static ItemStack pote;
	public static ItemMeta potemeta;
	public static ItemStack bu;
	public static ItemMeta bumeta;
	public static ItemStack espada;
	public static ItemMeta espadameta;
	public static HashMap<String, String> Kit;
	public static ArrayList<String> cooldown;

	static {
		KitAPI.Kit = new HashMap<String, String>();
		KitAPI.cooldown = new ArrayList<String>();
	}

	public static void setKit(final Player p, final String kit) {
		KitAPI.Kit.put(p.getName(), kit);
	}

	public static String getkit(final Player p) {
		if (KitAPI.Kit.containsKey(p.getName())) {
			return KitAPI.Kit.get(p.getName());
		}
		return "Sem Classe";
	}

	public static void RemoveKit(final Player p) {
		KitAPI.Kit.remove(p.getName());
	}

	public static void Itens(final Player p) {
		KitAPI.sopa = new ItemStack(Material.MUSHROOM_SOUP);
		(KitAPI.sopameta = KitAPI.sopa.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Sopas");
		KitAPI.sopa.setItemMeta(KitAPI.sopameta);
		KitAPI.cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
		(KitAPI.cogu1meta = KitAPI.cogu1.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Recraft");
		KitAPI.cogu1.setItemMeta(KitAPI.cogu1meta);
		KitAPI.cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
		(KitAPI.cogu2meta = KitAPI.cogu2.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Recraft");
		KitAPI.cogu2.setItemMeta(KitAPI.cogu2meta);
		KitAPI.pote = new ItemStack(Material.BOWL, 64);
		(KitAPI.potemeta = KitAPI.pote.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Recraft");
		KitAPI.pote.setItemMeta(KitAPI.potemeta);
		KitAPI.bu = new ItemStack(Material.COMPASS);
		KitAPI.bumeta = KitAPI.bu.getItemMeta();
		KitAPI.bu.setItemMeta(KitAPI.bumeta);
		KitAPI.espada = new ItemStack(Material.WOOD_SWORD);
		(KitAPI.espadameta = KitAPI.espada.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Espada");
		KitAPI.espadameta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		KitAPI.espada.setItemMeta(KitAPI.espadameta);
		for (int i = 1; i < 35; ++i) {
			p.getInventory().addItem(new ItemStack[] { KitAPI.sopa });
			p.getInventory().setItem(15, KitAPI.cogu1);
			p.getInventory().setItem(14, KitAPI.cogu2);
			p.getInventory().setItem(13, KitAPI.pote);
			p.getInventory().setItem(0, KitAPI.espada);
			API.setWarp(p, "Arena");
		}
		p.updateInventory();
	}

	public static void PvP(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "PvP");
		final ItemStack espada = new ItemStack(Material.STONE_SWORD);
		final ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName(String.valueOf(Config.cor) + "Espada");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
		p.updateInventory();
	}

	public static void Warps(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Warp");
	}

	public static void Avatar(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Avatar");
		final ItemStack apple = new ItemStack(Material.WOOL);
		final ItemMeta applemeta = apple.getItemMeta();
		applemeta.setDisplayName(String.valueOf(Config.cor) + "Avatar");
		apple.setItemMeta(applemeta);
		p.getInventory().setItem(1, apple);
	}

	public static void Specialist(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Specialist");
		final ItemStack enchant = new ItemStack(Material.BOOK);
		final ItemMeta enchantmeta = enchant.getItemMeta();
		enchantmeta.setDisplayName(String.valueOf(Config.cor) + "Specialist");
		enchant.setItemMeta(enchantmeta);
		p.getInventory().setItem(1, enchant);
	}

	public static void Magma(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Magma");
	}

	public static void Ajnin(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Ajnin");
	}

	public static void Viper(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Viper");
	}

	public static void Firer(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Firer");
	}

	public static void Turtle(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Turtle");
	}

	public static void Barbarian(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Barbarian");
	}

	public static void Lavaman(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Lavaman");
	}

	public static void ForceField(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "ForceField");
		final ItemStack ff = new ItemStack(Material.NETHER_FENCE);
		final ItemMeta ffmeta = ff.getItemMeta();
		ffmeta.setDisplayName(String.valueOf(Config.cor) + "ForceField");
		ff.setItemMeta(ffmeta);
		p.getInventory().setItem(1, ff);
	}

	public static void Strong(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Strong");
		final ItemStack ff = new ItemStack(Material.WATCH);
		final ItemMeta ffmeta = ff.getItemMeta();
		ffmeta.setDisplayName(String.valueOf(Config.cor) + "Strong");
		ff.setItemMeta(ffmeta);
		p.getInventory().setItem(1, ff);
	}

	public static void Bomber(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Bomber");
		final ItemStack ff = new ItemStack(Material.TNT, 15);
		final ItemMeta ffmeta = ff.getItemMeta();
		ffmeta.setDisplayName(String.valueOf(Config.cor) + "Bomber");
		ff.setItemMeta(ffmeta);
		p.getInventory().setItem(1, ff);
	}

	public static void Sumo(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Sumo");
		final ItemStack ff = new ItemStack(Material.APPLE);
		final ItemMeta ffmeta = ff.getItemMeta();
		ffmeta.setDisplayName(String.valueOf(Config.cor) + "Sumo");
		ff.setItemMeta(ffmeta);
		p.getInventory().setItem(1, ff);
	}

	public static void Snail(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Snail");
	}

	public static void Achilles(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Achilles");
	}

	public static void Sonic(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Sonic");
		final ItemStack spider = new ItemStack(Material.LAPIS_BLOCK);
		final ItemMeta spidermeta = spider.getItemMeta();
		spidermeta.setDisplayName(String.valueOf(Config.cor) + "Sonic");
		spider.setItemMeta(spidermeta);
		p.getInventory().setItem(1, spider);
		p.updateInventory();
	}

	public static void Thresh(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Thresh");
		final ItemStack spider = new ItemStack(Material.BLAZE_ROD);
		final ItemMeta spidermeta = spider.getItemMeta();
		spider.setItemMeta(spidermeta);
		p.getInventory().setItem(1, spider);
		p.updateInventory();
	}

	public static void C4(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "C4");
		final ItemStack spider = new ItemStack(Material.WOOD_BUTTON);
		final ItemMeta spidermeta = spider.getItemMeta();
		spidermeta.setDisplayName(String.valueOf(Config.cor) + "C4");
		spider.setItemMeta(spidermeta);
		p.getInventory().setItem(1, spider);
		p.updateInventory();
	}

	public static void Gladiator(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Gladiator");
		final ItemStack spider = new ItemStack(Material.IRON_FENCE);
		final ItemMeta spidermeta = spider.getItemMeta();
		spidermeta.setDisplayName(String.valueOf(Config.cor) + "Gladiator");
		spider.setItemMeta(spidermeta);
		p.getInventory().setItem(1, spider);
		p.updateInventory();
	}

	public static void Blink(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Blink");
		final ItemStack spider = new ItemStack(Material.GLOWSTONE_DUST);
		final ItemMeta spidermeta = spider.getItemMeta();
		spidermeta.setDisplayName(String.valueOf(Config.cor) + "Blink");
		spider.setItemMeta(spidermeta);
		p.getInventory().setItem(1, spider);
		p.updateInventory();
	}

	public static void Flash(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Flash");
		final ItemStack spider = new ItemStack(Material.REDSTONE_TORCH_ON);
		final ItemMeta spidermeta = spider.getItemMeta();
		spidermeta.setDisplayName(String.valueOf(Config.cor) + "Flash");
		spider.setItemMeta(spidermeta);
		p.getInventory().setItem(1, spider);
		p.updateInventory();
	}

	public static void Timelord(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Timelord");
		final ItemStack spider = new ItemStack(Material.WATCH);
		final ItemMeta spidermeta = spider.getItemMeta();
		spidermeta.setDisplayName(String.valueOf(Config.cor) + "Timelord");
		spider.setItemMeta(spidermeta);
		p.getInventory().setItem(1, spider);
		p.updateInventory();
	}

	public static void Endermage(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Endermage");
		final ItemStack tnt = new ItemStack(Material.PORTAL);
		final ItemMeta tntmeta = tnt.getItemMeta();
		tntmeta.setDisplayName(String.valueOf(Config.cor) + "Endermage");
		tnt.setItemMeta(tntmeta);
		p.getInventory().setItem(1, tnt);
	}

	public static void Ryu(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Ryu");
		final ItemStack flash = new ItemStack(Material.BEACON);
		final ItemMeta flashmeta = flash.getItemMeta();
		flashmeta.setDisplayName(String.valueOf(Config.cor) + "Ryu");
		flash.setItemMeta(flashmeta);
		p.getInventory().setItem(1, flash);
	}

	public static void Thor(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Thor");
		final ItemStack infernor = new ItemStack(Material.GOLD_AXE);
		final ItemMeta infernormeta = infernor.getItemMeta();
		infernormeta.setDisplayName(String.valueOf(Config.cor) + "Thor");
		infernor.setItemMeta(infernormeta);
		p.getInventory().setItem(1, infernor);
		p.updateInventory();
	}

	public static void Crack(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Crack");
	}

	public static void Kangaroo(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Kangaroo");
		final ItemStack kangaroo = new ItemStack(Material.FIREWORK);
		final ItemMeta kangaroometa = kangaroo.getItemMeta();
		kangaroometa.setDisplayName(String.valueOf(Config.cor) + "Kangaroo");
		kangaroo.setItemMeta(kangaroometa);
		p.getInventory().setItem(1, kangaroo);
		p.updateInventory();
	}

	public static void Stomper(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Stomper");
		final ItemStack jump = new ItemStack(Material.MELON);
		final ItemMeta jumpmeta = jump.getItemMeta();
		jumpmeta.setDisplayName(String.valueOf(Config.cor) + "Stomper");
		jump.setItemMeta(jumpmeta);
	}

	public static void Fisherman(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Fisherman");
		final ItemStack vara = new ItemStack(Material.FISHING_ROD);
		final ItemMeta varameta = vara.getItemMeta();
		varameta.setDisplayName(String.valueOf(Config.cor) + "Fisherman");
		vara.setItemMeta(varameta);
		p.getInventory().setItem(1, vara);
	}

	public static void Phantom(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Phantom");
		final ItemStack vara = new ItemStack(Material.FEATHER);
		final ItemMeta varameta = vara.getItemMeta();
		varameta.setDisplayName(String.valueOf(Config.cor) + "Phantom");
		vara.setItemMeta(varameta);
		p.getInventory().setItem(1, vara);
	}

	public static void Grappler(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Grappler");
		final ItemStack la\u00e7o = new ItemStack(Material.LEASH);
		final ItemMeta la\u00e7ometa = la\u00e7o.getItemMeta();
		la\u00e7ometa.setDisplayName(String.valueOf(Config.cor) + "Grappler");
		la\u00e7o.setItemMeta(la\u00e7ometa);
		p.getInventory().setItem(1, la\u00e7o);
	}

	public static void Anchor(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Anchor");
	}

	public static void Deshfire(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Deshfire");
		final ItemStack spider = new ItemStack(Material.REDSTONE_BLOCK);
		final ItemMeta spidermeta = spider.getItemMeta();
		spidermeta.setDisplayName(String.valueOf(Config.cor) + "Deshfire");
		spider.setItemMeta(spidermeta);
		p.getInventory().setItem(1, spider);
	}

	public static void Hulk(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Hulk");
	}

	public static void Ninja(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Ninja");
	}

	public static void Swords(final Player p) {
		p.getInventory().clear();
		setKit(p, "Swords");
		final ItemStack la\u00e7o = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta la\u00e7ometa = la\u00e7o.getItemMeta();
		la\u00e7ometa.setDisplayName("Madeira");
		la\u00e7o.setItemMeta(la\u00e7ometa);
		KitAPI.cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
		(KitAPI.cogu1meta = KitAPI.cogu1.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Recraft");
		KitAPI.cogu1.setItemMeta(KitAPI.cogu1meta);
		KitAPI.cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
		(KitAPI.cogu2meta = KitAPI.cogu2.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Recraft");
		KitAPI.cogu2.setItemMeta(KitAPI.cogu2meta);
		KitAPI.pote = new ItemStack(Material.BOWL, 64);
		(KitAPI.potemeta = KitAPI.pote.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Recraft");
		KitAPI.pote.setItemMeta(KitAPI.potemeta);
		KitAPI.bu = new ItemStack(Material.COMPASS);
		KitAPI.bumeta = KitAPI.bu.getItemMeta();
		KitAPI.bu.setItemMeta(KitAPI.bumeta);
		KitAPI.espada = new ItemStack(Material.WOOD_SWORD);
		(KitAPI.espadameta = KitAPI.espada.getItemMeta()).setDisplayName("§eEspada");
		KitAPI.espadameta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		KitAPI.espada.setItemMeta(KitAPI.espadameta);
		for (int i = 1; i < 35; ++i) {
			p.getInventory().addItem(new ItemStack[] { KitAPI.sopa });
			p.getInventory().setItem(15, KitAPI.cogu1);
			p.getInventory().setItem(14, KitAPI.cogu2);
			p.getInventory().setItem(13, KitAPI.pote);
			p.getInventory().setItem(0, la\u00e7o);
		}
	}

	public static void Switcher(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Switcher");
		final ItemStack la\u00e7o = new ItemStack(Material.SNOW_BALL, 16);
		final ItemMeta la\u00e7ometa = la\u00e7o.getItemMeta();
		la\u00e7ometa.setDisplayName(String.valueOf(Config.cor) + "Switcher");
		la\u00e7o.setItemMeta(la\u00e7ometa);
		p.getInventory().setItem(1, la\u00e7o);
	}

	public static void Backpacker(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Backpacker");
		final ItemStack apple = new ItemStack(Material.NETHER_STAR);
		final ItemMeta applemeta = apple.getItemMeta();
		applemeta.setDisplayName(String.valueOf(Config.cor) + "Backpacker");
		apple.setItemMeta(applemeta);
		p.getInventory().setItem(1, apple);
	}

	public static void Archer(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Archer");
		final ItemStack arco = new ItemStack(Material.BOW);
		final ItemMeta arcometa = arco.getItemMeta();
		arcometa.setDisplayName(String.valueOf(Config.cor) + "Archer");
		arcometa.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		arcometa.addEnchant(Enchantment.KNOCKBACK, 3, true);
		arco.setItemMeta(arcometa);
		final ItemStack flecha = new ItemStack(Material.ARROW, 1);
		final ItemMeta flechameta = flecha.getItemMeta();
		flecha.setItemMeta(flechameta);
		p.getInventory().setItem(1, arco);
		p.getInventory().setItem(9, flecha);
	}

	public static void Demoman(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Demoman");
		final ItemStack tnt = new ItemStack(Material.TNT);
		final ItemMeta tntmeta = tnt.getItemMeta();
		tntmeta.setDisplayName(String.valueOf(Config.cor) + "Demoman");
		tnt.setItemMeta(tntmeta);
		p.getInventory().setItem(1, tnt);
	}

	public static void DarkMage(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "DarkMage");
	}

	public static void Critical(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Critical");
	}

	public static void Berserker(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Berserker");
	}

	public static void Camel(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Camel");
	}

	public static void Poseidon(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Poseidon");
	}

	public static void Viking(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Viking");
		final ItemStack espada = new ItemStack(Material.STONE_AXE);
		final ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName(String.valueOf(Config.cor) + "Viking");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
	}

	public static void Reaper(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Reaper");
		final ItemStack flash = new ItemStack(Material.WOOD_HOE);
		final ItemMeta flashmeta = flash.getItemMeta();
		flashmeta.setDisplayName(String.valueOf(Config.cor) + "Reaper");
		flash.setItemMeta(flashmeta);
		p.getInventory().setItem(1, flash);
	}

	public static void Negresco(final Player p) {
		p.getInventory().clear();
		Itens(p);
		setKit(p, "Negresco");
		final ItemStack spider = new ItemStack(Material.COAL_BLOCK);
		final ItemMeta spidermeta = spider.getItemMeta();
		spidermeta.setDisplayName(String.valueOf(Config.cor) + "Negresco");
		spider.setItemMeta(spidermeta);
		p.getInventory().setItem(1, spider);
	}
}
