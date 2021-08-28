package me.RaidzDev.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.RaidzDev.Config;

public class Youtuber implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
		final Player p = (Player) Sender;
		if (cmd.getName().equalsIgnoreCase("youtuber")) {
			p.sendMessage(" ");
			p.sendMessage("§7»     Tag §6Pro ");
			p.sendMessage("§7»     " + Config.Pro + " Inscritos");
			p.sendMessage("§7»     +1 Video!");
			p.sendMessage(" ");
			p.sendMessage(" ");
			p.sendMessage("§7»     Tag §bYoutuber ");
			p.sendMessage("§7»     " + Config.YT + " Inscritos");
			p.sendMessage("§7»     +1 Video!");
			p.sendMessage(" ");
		}
		return false;
	}
}
