package me.RaidzDev.Eventos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.RaidzDev.Config;
import me.RaidzDev.Main;
import me.RaidzDev.Utils.Inventario;

public class APIWarp implements Listener, CommandExecutor {
	public static final List<Player> warping;
	public static List<String> tanawarp;
	public static ArrayList<String> oitc;

	static {
		warping = new ArrayList<Player>();
		APIWarp.tanawarp = new ArrayList<String>();
		APIWarp.oitc = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("setrdm")) {
			if (!p.hasPermission("guikits.warp")) {
				sender.sendMessage(Main.Permiss\u00e3o);
				return true;
			}
			Main.instance.warps.set("RdmWorld", (Object) p.getLocation().getWorld().getName());
			Main.instance.warps.set("RdmX", (Object) p.getLocation().getX());
			Main.instance.warps.set("RdmY", (Object) p.getLocation().getY());
			Main.instance.warps.set("RdmZ", (Object) p.getLocation().getZ());
			Main.instance.save2();
			p.sendMessage(String.valueOf(Config.prefix) + "§7A warp RDM foi setada com sucesso!");
			return true;
		} else if (cmd.getName().equalsIgnoreCase("setmdr")) {
			if (!p.hasPermission("guikits.warp")) {
				sender.sendMessage(Main.Permiss\u00e3o);
				return true;
			}
			Main.instance.warps.set("MdrWorld", (Object) p.getLocation().getWorld().getName());
			Main.instance.warps.set("MdrX", (Object) p.getLocation().getX());
			Main.instance.warps.set("MdrY", (Object) p.getLocation().getY());
			Main.instance.warps.set("MdrZ", (Object) p.getLocation().getZ());
			Main.instance.save2();
			p.sendMessage(String.valueOf(Config.prefix) + "§7A warp MDR foi setada com sucesso!");
			return true;
		} else if (cmd.getName().equalsIgnoreCase("setspawn")) {
			if (!p.hasPermission("guikits.warp")) {
				sender.sendMessage(Main.Permiss\u00e3o);
				return true;
			}
			Main.instance.warps.set("SpawnWorld", (Object) p.getLocation().getWorld().getName());
			Main.instance.warps.set("SpawnX", (Object) p.getLocation().getX());
			Main.instance.warps.set("SpawnY", (Object) p.getLocation().getY());
			Main.instance.warps.set("SpawnZ", (Object) p.getLocation().getZ());
			Main.instance.save2();
			final World world = p.getWorld();
			final Location loc = p.getLocation();
			world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
			p.sendMessage(String.valueOf(Config.prefix) + "§7O Spawn foi setado com sucesso!");
			return true;
		} else if (cmd.getName().equalsIgnoreCase("setfps")) {
			if (!p.hasPermission("guikits.warp")) {
				sender.sendMessage(Main.Permiss\u00e3o);
				return true;
			}
			Main.instance.warps.set("FpsWorld", (Object) p.getLocation().getWorld().getName());
			Main.instance.warps.set("FpsX", (Object) p.getLocation().getX());
			Main.instance.warps.set("FpsY", (Object) p.getLocation().getY());
			Main.instance.warps.set("FpsZ", (Object) p.getLocation().getZ());
			Main.instance.save2();
			p.sendMessage(String.valueOf(Config.prefix) + "§7A warp FPS foi setada com sucesso!");
			return true;
		} else if (cmd.getName().equalsIgnoreCase("setchallenge")) {
			if (!p.hasPermission("guikits.warp")) {
				sender.sendMessage(Main.Permiss\u00e3o);
				return true;
			}
			Main.instance.warps.set("ChallengeWorld", (Object) p.getLocation().getWorld().getName());
			Main.instance.warps.set("ChallengeX", (Object) p.getLocation().getX());
			Main.instance.warps.set("ChallengeY", (Object) p.getLocation().getY());
			Main.instance.warps.set("ChallengeZ", (Object) p.getLocation().getZ());
			Main.instance.save2();
			p.sendMessage(String.valueOf(Config.prefix) + "§7A warp Lava Challenge foi setada com sucesso!");
			return true;
		} else {
			if (!cmd.getName().equalsIgnoreCase("setKnock")) {
				if (cmd.getName().equalsIgnoreCase("rdm")) {
					p.sendMessage(
							String.valueOf(Config.prefix) + " §7Voc\u00ea ser\u00e1 teletransportado em 5 segundos");
					p.getInventory().setArmorContents((ItemStack[]) null);
					p.getInventory().clear();
					APIWarp.warping.add(p);
					Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(),
							(Runnable) new Runnable() {
								@Override
								public void run() {
									if (APIWarp.warping.contains(p)) {
										for (final PotionEffect effect : p.getActivePotionEffects()) {
											p.removePotionEffect(effect.getType());
										}
										final World w = Bukkit.getServer()
												.getWorld(Main.getInstance().warps.getString("RdmWorld"));
										final double x = Main.instance.warps.getDouble("RdmX");
										final double y = Main.instance.warps.getDouble("RdmY");
										final double z = Main.instance.warps.getDouble("RdmZ");
										p.teleport(new Location(w, x, y, z));
										p.getInventory().clear();
										ScoreBoard.onScoreboard(p);
										KitAPI.setKit(p, "Warps");
										KitAPI.Warps(p);
										KitAPI.Itens(p);
										Eventos.sendTitle(p, Config.svs);
										Eventos.sendSubTitle(p, "§cRDM");
										API.setWarp(p, "RDM");
										p.sendMessage(
												String.valueOf(Config.prefix) + " §7Voc\u00ea foi teletransportado");
										p.getInventory().setHelmet(new ItemStack(Material.AIR));
										p.getInventory().setChestplate(new ItemStack(Material.AIR));
										p.getInventory().setLeggings(new ItemStack(Material.AIR));
										p.getInventory().setBoots(new ItemStack(Material.AIR));
										p.setMaxHealth(20.0);
										p.setHealth(20.0);
										APIWarp.warping.remove(p);
										APIWarp.tanawarp.add(p.getName());
										ScoreBoard.onScoreboard(p);
									}
								}
							}, 100L);
				}
				if (cmd.getName().equalsIgnoreCase("mdr")) {
					p.getInventory().setArmorContents((ItemStack[]) null);
					p.getInventory().clear();
					APIWarp.warping.add(p);
					Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
						@Override
						public void run() {
							if (APIWarp.warping.contains(p)) {
								for (final PotionEffect effect : p.getActivePotionEffects()) {
									p.removePotionEffect(effect.getType());
								}
								KitAPI.Warps(p);
								ScoreBoard.onScoreboard(p);
								KitAPI.setKit(p, "Warps");
								final World w = Bukkit.getServer().getWorld(Main.instance.warps.getString("MdrWorld"));
								final double x = Main.instance.warps.getDouble("MdrX");
								final double y = Main.instance.warps.getDouble("MdrY");
								final double z = Main.instance.warps.getDouble("MdrZ");
								p.teleport(new Location(w, x, y, z));
								p.getInventory().clear();
								KitAPI.Itens(p);
								ScoreBoard.onScoreboard(p);
								KitAPI.setKit(p, "Warps");
								Eventos.sendTitle(p, Config.svs);
								Eventos.sendSubTitle(p, "§cMDR");
								API.setWarp(p, "MDR");
								p.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea foi teletransportado");
								p.getInventory().setHelmet(new ItemStack(Material.AIR));
								p.getInventory().setChestplate(new ItemStack(Material.AIR));
								p.getInventory().setLeggings(new ItemStack(Material.AIR));
								p.getInventory().setBoots(new ItemStack(Material.AIR));
								p.setMaxHealth(20.0);
								p.setHealth(20.0);
								APIWarp.warping.remove(p);
								APIWarp.tanawarp.add(p.getName());
								ScoreBoard.onScoreboard(p);
							}
						}
					}, 100L);
				}
				if (cmd.getName().equalsIgnoreCase("Knock")) {
					p.getInventory().setArmorContents((ItemStack[]) null);
					p.getInventory().clear();
					APIWarp.warping.add(p);
					Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
						@Override
						public void run() {
							if (APIWarp.warping.contains(p)) {
								for (final PotionEffect effect : p.getActivePotionEffects()) {
									p.removePotionEffect(effect.getType());
								}
								KitAPI.Warps(p);
								ScoreBoard.onScoreboard(p);
								KitAPI.setKit(p, "Warps");
								final World w = Bukkit.getServer()
										.getWorld(Main.instance.warps.getString("KnockWorld"));
								final double x = Main.instance.warps.getDouble("KnockX");
								final double y = Main.instance.warps.getDouble("KnockY");
								final double z = Main.instance.warps.getDouble("KnockZ");
								p.teleport(new Location(w, x, y, z));
								p.getInventory().clear();
								KitAPI.Itens(p);
								ScoreBoard.onScoreboard(p);
								KitAPI.setKit(p, "Warps");
								Eventos.sendTitle(p, Config.svs);
								Eventos.sendSubTitle(p, "§cKnock");
								API.setWarp(p, "Knock");
								p.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea foi teletransportado");
								p.getInventory().setHelmet(new ItemStack(Material.AIR));
								p.getInventory().setChestplate(new ItemStack(Material.AIR));
								p.getInventory().setLeggings(new ItemStack(Material.AIR));
								p.getInventory().setBoots(new ItemStack(Material.AIR));
								p.setMaxHealth(20.0);
								p.setHealth(20.0);
								p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 105, 99999));
								p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 105, 99999));
								final ItemStack espada = new ItemStack(Material.STICK);
								final ItemMeta espadameta = espada.getItemMeta();
								espadameta.setDisplayName(String.valueOf(Config.cor) + "Knock");
								espada.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
								p.getInventory().setItem(0, espada);
								p.setFireTicks(0);
								p.getInventory().setBoots((ItemStack) null);
								p.getInventory().setChestplate((ItemStack) null);
								p.getInventory().setLeggings((ItemStack) null);
								p.getInventory().setHelmet((ItemStack) null);
								APIWarp.warping.remove(p);
								APIWarp.tanawarp.add(p.getName());
								ScoreBoard.onScoreboard(p);
							}
						}
					}, 100L);
				}
				if (cmd.getName().equalsIgnoreCase("challenge")) {
					p.getInventory().setArmorContents((ItemStack[]) null);
					p.getInventory().clear();
					APIWarp.warping.add(p);
					Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
						@Override
						public void run() {
							if (APIWarp.warping.contains(p)) {
								for (final PotionEffect effect : p.getActivePotionEffects()) {
									p.removePotionEffect(effect.getType());
								}
								final World w = Bukkit.getServer()
										.getWorld(Main.instance.warps.getString("ChallengeWorld"));
								final double x = Main.instance.warps.getDouble("ChallengeX");
								final double y = Main.instance.warps.getDouble("ChallengeY");
								final double z = Main.instance.warps.getDouble("ChallengeZ");
								p.teleport(new Location(w, x, y, z));
								KitAPI.Warps(p);
								p.getInventory().clear();
								Eventos.sendTitle(p, Config.svs);
								ScoreBoard.onScoreboard(p);
								KitAPI.setKit(p, "Warps");
								Eventos.sendSubTitle(p, "§cChallenge");
								API.setWarp(p, "Challenge");
								final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
								final ItemMeta sopameta = sopa.getItemMeta();
								sopameta.setDisplayName("§eSopas");
								sopa.setItemMeta(sopameta);
								final ItemStack cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
								final ItemMeta cogu1meta = cogu1.getItemMeta();
								cogu1meta.setDisplayName("§7Cogumelo");
								cogu1.setItemMeta(cogu1meta);
								final ItemStack cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
								final ItemMeta cogu2meta = cogu2.getItemMeta();
								cogu2meta.setDisplayName("§7Cogumelo");
								cogu2.setItemMeta(cogu2meta);
								final ItemStack pote = new ItemStack(Material.BOWL, 64);
								final ItemMeta potemeta = pote.getItemMeta();
								potemeta.setDisplayName("§7Pote");
								pote.setItemMeta(potemeta);
								for (int i = 1; i < 35; ++i) {
									p.getInventory().addItem(new ItemStack[] { sopa });
									p.getInventory().setItem(15, cogu1);
									p.getInventory().setItem(14, cogu2);
									p.getInventory().setItem(13, pote);
								}
								p.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea foi teletransportado");
								p.getInventory().setHelmet(new ItemStack(Material.AIR));
								p.getInventory().setChestplate(new ItemStack(Material.AIR));
								p.getInventory().setLeggings(new ItemStack(Material.AIR));
								p.getInventory().setBoots(new ItemStack(Material.AIR));
								p.setMaxHealth(20.0);
								p.setHealth(20.0);
								APIWarp.warping.remove(p);
								APIWarp.tanawarp.add(p.getName());
								ScoreBoard.onScoreboard(p);
							}
						}
					}, 100L);
				}
				if (cmd.getName().equalsIgnoreCase("fps")) {
					p.getInventory().setArmorContents((ItemStack[]) null);
					p.getInventory().clear();
					APIWarp.warping.add(p);
					Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
						@Override
						public void run() {
							if (APIWarp.warping.contains(p)) {
								for (final PotionEffect effect : p.getActivePotionEffects()) {
									p.removePotionEffect(effect.getType());
								}
								final World w = Bukkit.getServer().getWorld(Main.instance.warps.getString("FpsWorld"));
								final double x = Main.instance.warps.getDouble("FpsX");
								final double y = Main.instance.warps.getDouble("FpsY");
								final double z = Main.instance.warps.getDouble("FpsZ");
								p.teleport(new Location(w, x, y, z));
								ScoreBoard.onScoreboard(p);
								KitAPI.setKit(p, "Warps");
								KitAPI.Warps(p);
								if (KitAPI.getkit(p) == "Warps") {
									API.setWarp(p, "FPS");
								}
								p.setMaxHealth(20.0);
								p.setHealth(20.0);
								Eventos.sendTitle(p, Config.svs);
								Eventos.sendSubTitle(p, "§cFPS");
								KitAPI.Warps(p);
								APIWarp.warping.remove(p);
								APIWarp.tanawarp.add(p.getName());
								p.getInventory().clear();
								final ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
								final ItemMeta espadameta = espada.getItemMeta();
								espadameta.setDisplayName("§e§oFPS");
								espadameta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
								espada.setItemMeta(espadameta);
								final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
								final ItemMeta sopameta = sopa.getItemMeta();
								sopameta.setDisplayName("§eSopas");
								sopa.setItemMeta(sopameta);
								final ItemStack cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
								final ItemMeta cogu1meta = cogu1.getItemMeta();
								cogu1meta.setDisplayName("§7Cogumelo");
								cogu1.setItemMeta(cogu1meta);
								final ItemStack cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
								final ItemMeta cogu2meta = cogu2.getItemMeta();
								cogu2meta.setDisplayName("§7Cogumelo");
								cogu2.setItemMeta(cogu2meta);
								final ItemStack pote = new ItemStack(Material.BOWL, 64);
								final ItemMeta potemeta = pote.getItemMeta();
								potemeta.setDisplayName("§7Pote");
								pote.setItemMeta(potemeta);
								p.getInventory().addItem(new ItemStack[] { espada });
								p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
								p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
								p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
								p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
								for (int i = 1; i < 35; ++i) {
									p.getInventory().addItem(new ItemStack[] { sopa });
									p.getInventory().setItem(15, cogu1);
									p.getInventory().setItem(14, cogu2);
									p.getInventory().setItem(13, pote);
									p.updateInventory();
									ScoreBoard.onScoreboard(p);
								}
							}
						}
					}, 100L);
				}
				if (cmd.getName().equalsIgnoreCase("spawn")) {
					p.getInventory().setArmorContents((ItemStack[]) null);
					p.getInventory().clear();
					APIWarp.warping.add(p);
					Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
						@Override
						public void run() {
							if (APIWarp.warping.contains(p)) {
								p.teleport(p.getWorld().getSpawnLocation());
								ScoreBoard.onScoreboard(p);
								p.getInventory().clear();
								for (final PotionEffect effect : p.getActivePotionEffects()) {
									p.removePotionEffect(effect.getType());
								}
								p.getInventory().setArmorContents((ItemStack[]) null);
								for (final PotionEffect effect : p.getActivePotionEffects()) {
									p.removePotionEffect(effect.getType());
								}
								p.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea foi teletransportado");
								p.getInventory().setHelmet(new ItemStack(Material.AIR));
								p.getInventory().setChestplate(new ItemStack(Material.AIR));
								p.getInventory().setLeggings(new ItemStack(Material.AIR));
								p.getInventory().setBoots(new ItemStack(Material.AIR));
								p.setMaxHealth(20.0);
								p.setHealth(20.0);
								APIWarp.warping.remove(p);
								APIWarp.tanawarp.remove(p.getName());
								KitAPI.RemoveKit(p);
								API.setWarp(p, "Spawn");
								final World world = p.getWorld();
								final Location loc = new Location(world, -674.0, 92.0, -1143.0);
								Eventos.sendTitle(p, Config.svs);
								Eventos.sendSubTitle(p, "§cSpawn");
								APIWarp.this.tp(p, loc);
								Inventario.limpar(p);
								KitAPI.RemoveKit(p);
								APIWarp.tanawarp.remove(p.getName());
								ScoreBoard.onScoreboard(p);
							}
						}
					}, 100L);
				}
				return false;
			}
			if (!p.hasPermission("guikits.warp")) {
				sender.sendMessage(Main.Permiss\u00e3o);
				return true;
			}
			Main.instance.warps.set("KnockWorld", (Object) p.getLocation().getWorld().getName());
			Main.instance.warps.set("KnockX", (Object) p.getLocation().getX());
			Main.instance.warps.set("KnockY", (Object) p.getLocation().getY());
			Main.instance.warps.set("KnockZ", (Object) p.getLocation().getZ());
			Main.instance.save2();
			p.sendMessage(String.valueOf(Config.prefix) + "§7A warp Knock foi setada com sucesso!");
			return true;
		}
	}

	protected void tp(final Player p, final Location loc) {
	}
}
