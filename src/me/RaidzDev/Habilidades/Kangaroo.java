package me.RaidzDev.Habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.RaidzDev.Eventos.KitAPI;

public class Kangaroo implements Listener {
	private HashMap<Player, Integer> jumpinho;
	public static ArrayList<Player> kangarinho;

	static {
		Kangaroo.kangarinho = new ArrayList<Player>();
	}

	public Kangaroo() {
		this.jumpinho = new HashMap<Player, Integer>();
	}

	@EventHandler
	public void interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitAPI.getkit(p) == "Kangaroo" && p.getItemInHand().getType() == Material.FIREWORK) {
			e.setCancelled(true);
			if (!this.jumpinho.containsKey(p)) {
				if (!p.isSneaking()) {
					if (!((CraftPlayer) p).getHandle().onGround) {
						this.jumpinho.put(p, 1);
						p.setVelocity(new Vector(p.getVelocity().getX(), 1.0, p.getVelocity().getZ()));
					} else {
						p.setVelocity(new Vector(p.getVelocity().getX(), 1.0, p.getVelocity().getZ()));
					}
				} else if (!((CraftPlayer) p).getHandle().onGround) {
					p.setVelocity(p.getLocation().getDirection().multiply(1.2));
					p.setVelocity(new Vector(p.getVelocity().getX(), 0.5, p.getVelocity().getZ()));
					this.jumpinho.put(p, 1);
				} else {
					p.setVelocity(p.getLocation().getDirection().multiply(1.2));
					p.setVelocity(new Vector(p.getVelocity().getX(), 0.5, p.getVelocity().getZ()));
				}
			}
		}
	}

	@EventHandler
	public void landed(final PlayerMoveEvent e) {
		if (e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR
				&& this.jumpinho.containsKey(e.getPlayer())) {
			this.jumpinho.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void poucodano(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (KitAPI.getkit(p) == "Kangaroo") {
				if (e.getDamage() > 7.0) {
					e.setDamage(7);
				} else {
					e.setDamage(e.getDamage());
				}
			}
		}
	}
}
