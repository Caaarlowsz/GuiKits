package me.RaidzDev.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import me.RaidzDev.*;

public class Gamemode implements CommandExecutor
{
    Main main;
    
    public Gamemode(Main plugin) {
        plugin = this.main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final Player player = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("gm") && sender.hasPermission("guikits.gm")) {
            if (args.length != 1) {
                player.sendMessage("§aUse: /gm <0|1>");
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("0")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage("§7Gamemode Alterado Para " + Config.cor + "Aventura.");
                }
                if (args[0].equalsIgnoreCase("1")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage("§7Gamemode Alterado Para " + Config.cor + "Criativo.");
                }
                if (args[0].equalsIgnoreCase("2")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage("§7Gamemode Alterado Para " + Config.cor + "Aventura.");
                }
                return true;
            }
        }
        return false;
    }
}
