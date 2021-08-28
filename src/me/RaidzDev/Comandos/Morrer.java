package me.RaidzDev.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Morrer implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("morrer") || cmd.getName().equalsIgnoreCase("kill")
				|| cmd.getName().equalsIgnoreCase("suicide")) {
			p.setHealth(0.0);
		}
		return false;
	}
}
