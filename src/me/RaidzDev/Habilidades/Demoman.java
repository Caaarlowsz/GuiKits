package me.RaidzDev.Habilidades;

import org.bukkit.Material;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.RaidzDev.Eventos.KitAPI;

public class Demoman implements Listener {
	public static Main plugin;
	public long cooldownLenght;

	public Demoman() {
		this.cooldownLenght = 0L;
	}

	@EventHandler
	public void eventDemoman(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.TNT && KitAPI.getkit(p) == "Demoman"
				&& (e.getAction().equals((Object) Action.RIGHT_CLICK_AIR)
						|| e.getAction().equals((Object) Action.RIGHT_CLICK_BLOCK))) {
			if (this.hasCooldown()) {
				p.sendMessage("?7Faltam ?c" + this.cooldownTimeRemaining() + " ?7para o cooldown acabar!");
				return;
			}
			final TNTPrimed tnt = (TNTPrimed) p.getWorld().spawn(p.getLocation(), TNTPrimed.class);
			tnt.setVelocity(p.getEyeLocation().getDirection().multiply(2.5));
			tnt.setFuseTicks(40);
			p.getLocation().getWorld().createExplosion(p.getLocation(), 4.0f);
			this.addCooldown(p, 30);
		}
	}

	@EventHandler
	public void DemomanDamage(final EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) event.getEntity();
		if (KitAPI.getkit(p) != "Demoman") {
			return;
		}
		if (event.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
			return;
		}
		event.setCancelled(true);
	}

	public void addCooldown(final Player player, final int seconds) {
		this.cooldownLenght = System.currentTimeMillis() + seconds * 1000;
	}

	public String cooldownTimeRemaining() {
		final long faltam = (this.cooldownLenght - System.currentTimeMillis()) / 1000L;
		if (faltam < 60L) {
			return String.valueOf(faltam) + " segundos restantes";
		}
		return String.valueOf(faltam) + " minutos restantes";
	}

	public boolean hasCooldown() {
		return this.cooldownLenght > System.currentTimeMillis();
	}
}
