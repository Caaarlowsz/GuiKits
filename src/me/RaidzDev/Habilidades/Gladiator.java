package me.RaidzDev.Habilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.RaidzDev.Main;
import me.RaidzDev.Eventos.KitAPI;

public class Gladiator implements Listener {
	public boolean generateGlass;
	public HashMap<String, Location> oldl;
	public static HashMap<String, String> fighting;
	public HashMap<Integer, ArrayList<Location>> blocks;
	public HashMap<Player, Location> localizacao;
	public HashMap<Location, Block> bloco;
	public HashMap<Integer, String[]> players;
	public HashMap<String, Integer> tasks;
	int nextID;
	public int id1;
	public int id2;
	public static ArrayList<String> gladgladiator;

	static {
		Gladiator.fighting = new HashMap<String, String>();
		Gladiator.gladgladiator = new ArrayList<String>();
	}

	public Gladiator() {
		this.generateGlass = true;
		this.oldl = new HashMap<String, Location>();
		this.blocks = new HashMap<Integer, ArrayList<Location>>();
		this.localizacao = new HashMap<Player, Location>();
		this.bloco = new HashMap<Location, Block>();
		this.players = new HashMap<Integer, String[]>();
		this.tasks = new HashMap<String, Integer>();
		this.nextID = 0;
	}

	@EventHandler
	void death(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		Gladiator.gladgladiator.remove(p.getName());
	}

	@EventHandler
	public void OnGladiatorKit(final PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (event.getRightClicked() instanceof Player) {
			final Player r = (Player) event.getRightClicked();
			if (p.getItemInHand().getType() == Material.IRON_FENCE && KitAPI.getkit(p) == "Gladiator") {
				event.setCancelled(true);
				final Location loc = new Location(p.getWorld(), (double) p.getLocation().getBlockX(),
						(double) (p.getLocation().getBlockY() + 70), (double) p.getLocation().getBlockZ());
				this.localizacao.put(p, loc);
				this.localizacao.put(r, loc);
				final Location loc2 = new Location(p.getWorld(), (double) (p.getLocation().getBlockX() + 8),
						(double) (p.getLocation().getBlockY() + 73), (double) (p.getLocation().getBlockZ() + 8));
				final Location loc3 = new Location(p.getWorld(), (double) (p.getLocation().getBlockX() - 8),
						(double) (p.getLocation().getBlockY() + 73), (double) (p.getLocation().getBlockZ() - 8));
				if (Gladiator.fighting.containsKey(p.getName()) || Gladiator.fighting.containsKey(r.getName())) {
					event.setCancelled(true);
					p.sendMessage("?7Voce ja esta em combate!");
					return;
				}
				final Integer currentID = this.nextID;
				++this.nextID;
				final ArrayList<String> list = new ArrayList<String>();
				list.add(p.getName());
				list.add(r.getName());
				this.players.put(currentID, list.toArray(new String[1]));
				this.oldl.put(p.getName(), p.getLocation());
				this.oldl.put(r.getName(), r.getLocation());
				if (this.generateGlass) {
					final List<Location> cuboid = new ArrayList<Location>();
					cuboid.clear();
					for (int bX = -10; bX <= 10; ++bX) {
						for (int bZ = -10; bZ <= 10; ++bZ) {
							for (int bY = -1; bY <= 10; ++bY) {
								final Block b = loc.clone().add((double) bX, (double) bY, (double) bZ).getBlock();
								if (!b.isEmpty()) {
									event.setCancelled(true);
									p.sendMessage("?7Voce nao pode criar sua arena aqui");
									return;
								}
								if (bY == 10) {
									cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
								} else if (bY == -1) {
									cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
								} else if (bX == -10 || bZ == -10 || bX == 10 || bZ == 10) {
									cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
								}
							}
						}
					}
					for (final Location loc4 : cuboid) {
						loc4.getBlock().setType(Material.GLASS);
						this.bloco.put(loc4, loc4.getBlock());
					}
					loc2.setYaw(135.0f);
					p.teleport(loc2);
					loc3.setYaw(-45.0f);
					r.teleport(loc3);
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
					r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
					p.sendMessage("?7Voce desafiou um jogador! Voce tem 5 segundos de invencibilidade!");
					p.sendMessage(
							"?7Caso nao tenha nenhum vencedor depois de 4 minutos, voce voltara ao seu local de origem!");
					r.sendMessage("?7Voce foi desafiado! Voce tem 5 segundos de invencibilidade!");
					r.sendMessage(
							"?7Caso nao tenha nenhum vencedor depois de 4 minutos, voce voltara ao seu local de origem!");
					Gladiator.fighting.put(p.getName(), r.getName());
					Gladiator.fighting.put(r.getName(), p.getName());
					Gladiator.gladgladiator.add(p.getName());
					Gladiator.gladgladiator.add(r.getName());
					this.id2 = Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
							(Runnable) new Runnable() {
								@Override
								public void run() {
									if (Gladiator.fighting.containsKey(p.getName())
											&& Gladiator.fighting.get(p.getName()).equalsIgnoreCase(r.getName())
											&& Gladiator.fighting.containsKey(r.getName())
											&& Gladiator.fighting.get(r.getName()).equalsIgnoreCase(p.getName())) {
										p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 2000000, 5));
										r.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 2000000, 5));
									}
								}
							}, 2400L);
					this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
							(Runnable) new Runnable() {
								@Override
								public void run() {
									if (Gladiator.fighting.containsKey(p.getName())
											&& Gladiator.fighting.get(p.getName()).equalsIgnoreCase(r.getName())
											&& Gladiator.fighting.containsKey(r.getName())
											&& Gladiator.fighting.get(r.getName()).equalsIgnoreCase(p.getName())) {
										Gladiator.fighting.remove(p.getName());
										Gladiator.fighting.remove(r.getName());
										Gladiator.gladgladiator.remove(p.getName());
										Gladiator.gladgladiator.remove(r.getName());
										p.teleport((Location) Gladiator.this.oldl.get(p.getName()));
										r.teleport((Location) Gladiator.this.oldl.get(r.getName()));
										Gladiator.this.oldl.remove(p.getName());
										Gladiator.this.oldl.remove(r.getName());
										p.sendMessage(
												"?7Nao houve nenhum vencedor, voce foi teleportado para o seu lugar de origem!");
										r.sendMessage(
												"?7Nao houve nenhum vencedor, voce foi teleportado para o seu lugar de origem!");
										final Location loc = Gladiator.this.localizacao.get(p);
										final List<Location> cuboid = new ArrayList<Location>();
										for (int bX = -10; bX <= 10; ++bX) {
											for (int bZ = -10; bZ <= 10; ++bZ) {
												for (int bY = -1; bY <= 10; ++bY) {
													if (bY == 10) {
														cuboid.add(
																loc.clone().add((double) bX, (double) bY, (double) bZ));
													} else if (bY == -1) {
														cuboid.add(
																loc.clone().add((double) bX, (double) bY, (double) bZ));
													} else if (bX == -10 || bZ == -10 || bX == 10 || bZ == 10) {
														cuboid.add(
																loc.clone().add((double) bX, (double) bY, (double) bZ));
													}
												}
											}
										}
										for (final Location loc2 : cuboid) {
											loc2.getBlock().setType(Material.AIR);
											Gladiator.this.bloco.get(loc2).setType(Material.AIR);
										}
									}
								}
							}, 4800L);
				}
			}
		}
	}

	@EventHandler
	public void onPlayerInteractGlad(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.IRON_FENCE && KitAPI.getkit(p) == "Gladiator") {
			e.setCancelled(true);
			p.updateInventory();
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDrop(final PlayerDropItemEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.IRON_FENCE && KitAPI.getkit(p) == "Gladiator") {
			e.setCancelled(true);
			p.updateInventory();
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlyaerInteract(final PlayerInteractEvent e) {
		if (e.getAction() == Action.LEFT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.GLASS
				&& e.getPlayer().getGameMode() != GameMode.CREATIVE
				&& Gladiator.fighting.containsKey(e.getPlayer().getName())) {
			e.setCancelled(true);
			e.getClickedBlock().setType(Material.GLASS);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							if (Gladiator.fighting.containsKey(e.getPlayer().getName())) {
								e.getClickedBlock().setType(Material.GLASS);
							}
						}
					}, 30L);
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onBlockBreak(final BlockBreakEvent e) {
		if (e.getBlock().getType() == Material.GLASS && e.getPlayer().getGameMode() != GameMode.CREATIVE
				&& Gladiator.fighting.containsKey(e.getPlayer().getName())) {
			e.setCancelled(true);
			e.getBlock().setType(Material.GLASS);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
				@Override
				public void run() {
					if (e.getPlayer().getGameMode() != GameMode.CREATIVE
							&& Gladiator.fighting.containsKey(e.getPlayer().getName())) {
						e.getBlock().setType(Material.GLASS);
					}
				}
			}, 30L);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLeft(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (Gladiator.fighting.containsKey(p.getName())) {
			final Player t = Bukkit.getServer().getPlayer((String) Gladiator.fighting.get(p.getName()));
			Gladiator.fighting.remove(t.getName());
			Gladiator.fighting.remove(p.getName());
			Gladiator.gladgladiator.remove(p.getName());
			Gladiator.gladgladiator.remove(t.getName());
			final Location old = this.oldl.get(t.getName());
			t.teleport(old);
			t.sendMessage("?7O jogador " + p.getName() + " deslogou-se!");
			Bukkit.getScheduler().cancelTask(this.id1);
			Bukkit.getScheduler().cancelTask(this.id2);
			t.removePotionEffect(PotionEffectType.WITHER);
			final Location loc = this.localizacao.get(p);
			final List<Location> cuboid = new ArrayList<Location>();
			for (int bX = -10; bX <= 10; ++bX) {
				for (int bZ = -10; bZ <= 10; ++bZ) {
					for (int bY = -1; bY <= 10; ++bY) {
						if (bY == 10) {
							cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
						} else if (bY == -1) {
							cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
						} else if (bX == -10 || bZ == -10 || bX == 10 || bZ == 10) {
							cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
						}
					}
				}
			}
			for (final Location loc2 : cuboid) {
				loc2.getBlock().setType(Material.AIR);
				this.bloco.get(loc2).setType(Material.AIR);
			}
			for (final Location loc2 : cuboid) {
				loc2.getBlock().setType(Material.AIR);
				this.bloco.get(loc2).setType(Material.AIR);
			}
			for (final Location loc2 : cuboid) {
				loc2.getBlock().setType(Material.AIR);
				this.bloco.get(loc2).setType(Material.AIR);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDeathGladiator(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if (Gladiator.fighting.containsKey(p.getName())) {
			final Player k = Bukkit.getServer().getPlayer((String) Gladiator.fighting.get(p.getName()));
			final Location old = this.oldl.get(p.getName());
			k.teleport(old);
			k.sendMessage(ChatColor.GREEN + "Voce ganhou a batalha contra " + p.getName() + ChatColor.GREEN + "!");
			Bukkit.getScheduler().cancelTask(this.id1);
			Bukkit.getScheduler().cancelTask(this.id2);
			k.removePotionEffect(PotionEffectType.WITHER);
			k.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
			Gladiator.fighting.remove(k.getName());
			Gladiator.fighting.remove(p.getName());
			Gladiator.gladgladiator.remove(p.getName());
			Gladiator.gladgladiator.remove(k.getName());
			final Location loc = this.localizacao.get(p);
			final List<Location> cuboid = new ArrayList<Location>();
			cuboid.clear();
			for (int bX = -10; bX <= 10; ++bX) {
				for (int bZ = -10; bZ <= 10; ++bZ) {
					for (int bY = -1; bY <= 10; ++bY) {
						if (bY == 10) {
							cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
						} else if (bY == -1) {
							cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
						} else if (bX == -10 || bZ == -10 || bX == 10 || bZ == 10) {
							cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
						}
					}
				}
			}
			for (final Location loc2 : cuboid) {
				loc2.getBlock().setType(Material.AIR);
				if (this.bloco.containsKey(loc2)) {
					this.bloco.get(loc2).setType(Material.AIR);
				}
			}
		}
	}
}
