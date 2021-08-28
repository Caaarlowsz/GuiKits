package me.RaidzDev.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.RaidzDev.Config;

public class StaffChat implements Listener, CommandExecutor {
	public static ArrayList<String> staff;

	static {
		StaffChat.staff = new ArrayList<String>();
	}

	@EventHandler
	public void onChat(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		Player[] arrayOfPlayer;
		for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
			final Player online = arrayOfPlayer[i];
			if (this.isStaffChatting(p)) {
				e.setCancelled(true);
				if (online.hasPermission("guikits.sc") || this.isStaffChatting(online)) {
					online.sendMessage("§cSC §7" + p.getName() + "§c: §7" + e.getMessage());
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("sc") && p.hasPermission("guikits.sc")) {
			if (this.isStaffChatting(p)) {
				StaffChat.staff.remove(p.getName());
				p.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea saiu do chat staff.");
			} else {
				StaffChat.staff.add(p.getName());
				p.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea entrou do chat staff.");
			}
		}
		return true;
	}

	public boolean isStaffChatting(final Player player) {
		return StaffChat.staff.contains(player.getName());
	}
}
