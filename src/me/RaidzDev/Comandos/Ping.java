package me.RaidzDev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.RaidzDev.Config;
import me.RaidzDev.Main;

public class Ping implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player jogador = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ping")) {
			final int ping = ((CraftPlayer) jogador).getHandle().ping;
			if (args.length == 0) {
				jogador.sendMessage(String.valueOf(Config.prefix) + "§aSeu Ping " + ping + " ms.");
			} else if (jogador.getServer().getPlayer(args[0]) != null) {
				final String jogador2 = args[0];
				final Player target = Bukkit.getServer().getPlayer(args[0]);
				final int ping2 = ((CraftPlayer) target).getHandle().ping;
				jogador.sendMessage(
						String.valueOf(Config.prefix) + "§aO ping do " + jogador2 + " e de " + ping2 + " ms.");
			} else {
				jogador.sendMessage(Main.JogadorOff);
			}
		}
		return false;
	}
}
