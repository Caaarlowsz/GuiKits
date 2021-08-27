package me.RaidzDev.Comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import me.RaidzDev.*;

public class Arena implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] args) {
        final Player p = (Player)sender;
        if (p.hasPermission("guikits.arena") && cmd.getName().equalsIgnoreCase("arena")) {
            if (args.length == 0) {
                p.sendMessage("§aUse: /arena <Jogador>");
            }
            if (args.length == 1) {
                final Player o = Bukkit.getPlayer(args[0]);
                if (o != null) {
                    o.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
                    o.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
                    o.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
                    o.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
                    o.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
                    o.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
                    o.teleport(o.getLocation().add(0.0, 11.0, -0.05));
                    p.sendMessage(String.valueOf(Config.prefix) + "§cJogador preso com sucesso");
                    Player[] arrayOfPlayer;
                    for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
                        final Player p2 = arrayOfPlayer[i];
                        if (p2.hasPermission("guikits.admin")) {
                            p2.sendMessage(ChatColor.RED + sender.getName() + " §7Criou Uma Arena Com §c" + o.getDisplayName());
                        }
                    }
                }
                else {
                    p.sendMessage(Main.JogadorOff);
                }
            }
        }
        else {
            p.sendMessage(Main.Permiss\u00e3o);
        }
        return false;
    }
}
