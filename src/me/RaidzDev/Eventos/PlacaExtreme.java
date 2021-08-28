package me.RaidzDev.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.RaidzDev.Config;
import me.RaidzDev.Main;

public class PlacaExtreme implements Listener {
	@EventHandler
	public void Escrever(final SignChangeEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("placa.extreme") && e.getLine(0).equalsIgnoreCase("extreme")) {
			e.setLine(0, "§e---------");
			e.setLine(1, "§eChallenge");
			e.setLine(2, "§6Extreme");
			e.setLine(3, "§e---------");
		}
	}

	@EventHandler
	public void inv(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null
				&& (e.getClickedBlock().getType() == Material.WALL_SIGN
						|| e.getClickedBlock().getType() == Material.SIGN_POST)) {
			final Sign s = (Sign) e.getClickedBlock().getState();
			final String[] lines = s.getLines();
			if (lines.length > 0 && lines[0].equals("§e---------") && lines.length > 1 && lines[1].equals("§eChallenge")
					&& lines.length > 2 && lines[2].equals("§6Extreme") && lines.length > 3
					&& lines[3].equals("§e---------")) {
				Status.addMoney1(p, 100);
				ScoreBoard.onScoreboard(p);
				Bukkit.broadcastMessage(String.valueOf(Config.prefix) + " o jogador §c" + p.getName()
						+ " §7completou o lava challenge extreme!");
				p.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea completou a lava challenge §cextreme§7!");
				final World w = Bukkit.getServer().getWorld(Main.instance.warps.getString("ChallengeWorld"));
				final double x = Main.instance.warps.getDouble("ChallengeX");
				final double y = Main.instance.warps.getDouble("ChallengeY");
				final double z = Main.instance.warps.getDouble("ChallengeZ");
				p.teleport(new Location(w, x, y, z));
				p.updateInventory();
			}
		}
	}
}
