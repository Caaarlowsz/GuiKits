package me.RaidzDev.Comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import me.RaidzDev.*;

public class Nofall implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] args) {
        final Player p = (Player)sender;
        if (p.hasPermission("guikits.nofall") && cmd.getName().equalsIgnoreCase("nofall")) {
            if (args.length == 0) {
                p.sendMessage("§aUse: /nofall <Jogador>");
            }
            if (args.length == 1) {
                final Player o = Bukkit.getPlayer(args[0]);
                if (o != null) {
                    o.getLocation().add(0.0, 40.0, 0.0).getBlock().setType(Material.AIR);
                    o.getLocation().add(0.0, 40.0, 1.0).getBlock().setType(Material.AIR);
                    o.getLocation().add(1.0, 40.0, 0.0).getBlock().setType(Material.AIR);
                    o.getLocation().add(0.0, 40.0, -1.0).getBlock().setType(Material.AIR);
                    o.getLocation().add(-1.0, 40.0, 0.0).getBlock().setType(Material.AIR);
                    o.getLocation().add(0.0, 40.0, 0.0).getBlock().setType(Material.AIR);
                    o.teleport(o.getLocation().add(0.0, 11.0, -0.05));
                    Player[] arrayOfPlayer;
                    for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {}
                }
                else {
                    p.sendMessage(Main.JogadorOff);
                }
            }
        }
        else {
            p.sendMessage(String.valueOf(Config.Aviso) + " §7Voc\u00ea n\u00e3o tem permiss\u00e3o para esse comando!");
        }
        return false;
    }
}
