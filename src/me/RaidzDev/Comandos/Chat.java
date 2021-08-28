package me.RaidzDev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.RaidzDev.Config;
import me.RaidzDev.Main;

public class Chat implements CommandExecutor, Listener {
	public static boolean pausado;

	static {
		Chat.pausado = false;
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		if (Cmd.getName().equalsIgnoreCase("chat")) {
			final Player p = (Player) Sender;
			if (!p.hasPermission("guikits.chat")) {
				p.sendMessage(Main.Permiss\u00e3o);
				return true;
			}
			if (Args.length == 0) {
				p.sendMessage("§aUse: /chat <clear : mute : desmute>");
				return true;
			}
			if (Args[0].equalsIgnoreCase("clear")) {
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage(String.valueOf(Config.prefix) + "Chat Limpo!");
			} else if (Args[0].equalsIgnoreCase("mute")) {
				Bukkit.getServer().broadcastMessage(String.valueOf(Config.prefix) + "§cChat Pausado!");
				Chat.pausado = true;
			} else if (Args[0].equalsIgnoreCase("desmute")) {
				Bukkit.getServer().broadcastMessage(String.valueOf(Config.prefix) + "§aChat Despausado!");
				Chat.pausado = false;
			}
		}
		return true;
	}

	@EventHandler
	public void onChat(final PlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (Chat.pausado && !p.hasPermission("falar.chatmutado")) {
			e.setCancelled(true);
			p.sendMessage(String.valueOf(Config.prefix) + "§cChat pausado no momento!");
		}
	}

	@EventHandler
	public void mutetell(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (Chat.pausado
				&& (e.getMessage().toLowerCase().startsWith("/tell") || e.getMessage().toLowerCase().startsWith("/msg")
						|| e.getMessage().toLowerCase().startsWith("/bukkit:tell")
						|| e.getMessage().toLowerCase().startsWith("/bukkit:msg"))) {
			e.setCancelled(true);
			p.sendMessage(String.valueOf(Config.prefix) + "§cChat pausado no momento!");
		}
	}
}
