package me.RaidzDev.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.RaidzDev.*;

public class Aplicar implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (args.length == 0) {
            p.sendMessage(String.valueOf(Config.prefix) + "§7Link do formulario: " + Config.cor + Main.instance.configuracoes.getString("Formulario").replace("&", "§"));
        }
        return false;
    }
}
