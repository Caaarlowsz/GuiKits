package me.RaidzDev.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Atualiza\u00e7\u00e3o implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player jogador = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("att") || cmd.getName().equalsIgnoreCase("atualizacao")) {
			jogador.sendMessage(" ");
			jogador.sendMessage(" ");
			jogador.sendMessage("§7== §cInforma\u00e7\u00f5es §7==");
			jogador.sendMessage(" ");
			jogador.sendMessage(" §7§c[+]§7 Adicinado.");
			jogador.sendMessage(" §7§c[-]§7 Removido ou desabilitado.");
			jogador.sendMessage(" §7§c[@]§7 Bugs Retirados.");
			jogador.sendMessage(" §7§c[|]§7 Sera Adicionado na outra vers\u00e3o!");
			jogador.sendMessage(" ");
			jogador.sendMessage("§7== §cInforma\u00e7\u00f5es §7==");
			jogador.sendMessage(" ");
			jogador.sendMessage(" ");
			jogador.sendMessage("§7== §cAtualiza\u00e7\u00f5es §7==");
			jogador.sendMessage(" ");
			jogador.sendMessage(" §7§c[+]§7 Tags ao Entrar.");
			jogador.sendMessage(" §7§c[+]§7 Loja de Classes.");
			jogador.sendMessage(" §7§c[+]§7 Feast.");
			jogador.sendMessage(" §7§c[+]§7 +1 Comando.");
			jogador.sendMessage(" §7§c[+]§7 +1 Warp.");
			jogador.sendMessage(" ");
			jogador.sendMessage("§7== §cAtualiza\u00e7\u00f5es §7==");
		}
		return false;
	}
}
