package me.RaidzDev.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.RaidzDev.*;
import me.RaidzDev.Eventos.*;

public class Coins implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player jogador = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("coins")) {
            jogador.sendMessage(String.valueOf(Config.prefix) + "§7Voc\u00ea tem " + Status.getMoney(jogador) + " de coins.");
        }
        return false;
    }
}
