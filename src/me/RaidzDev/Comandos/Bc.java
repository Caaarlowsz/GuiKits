package me.RaidzDev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RaidzDev.Config;
import me.RaidzDev.Main;

public class Bc implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command command, final String commandLabel,
			final String[] args) {
		final Player player = (Player) sender;
		if ((commandLabel.equalsIgnoreCase("bc") || commandLabel.equalsIgnoreCase("say"))
				&& player.hasPermission("guikits.bc")) {
			if (args.length >= 1) {
				String bcast = "";
				for (int x = 0; x < args.length; ++x) {
					bcast = String.valueOf(bcast) + args[x] + " ";
				}
				bcast = ChatColor.translateAlternateColorCodes('&', bcast);
				Bukkit.broadcastMessage(String.valueOf(Config.svs) + Config.prefix + ChatColor.GRAY + bcast);
			} else {
				sender.sendMessage("�aUse: /bc <MSG>");
				sender.sendMessage("�aUse: /say <MSG>");
			}
		} else {
			sender.sendMessage(Main.Permiss\u00e3o);
		}
		return false;
	}
}
