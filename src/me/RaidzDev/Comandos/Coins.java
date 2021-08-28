package me.RaidzDev.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RaidzDev.Config;
import me.RaidzDev.Eventos.Status;

public class Coins implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player jogador = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("coins")) {
			jogador.sendMessage(
					String.valueOf(Config.prefix) + "§7Voc\u00ea tem " + Status.getMoney(jogador) + " de coins.");
		}
		return false;
	}
}
