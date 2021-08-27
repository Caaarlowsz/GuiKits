package me.RaidzDev.Comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import java.util.*;
import org.apache.commons.lang.*;
import org.bukkit.*;
import me.RaidzDev.*;
import org.bukkit.plugin.*;

public class Report implements CommandExecutor, Listener
{
    public static ArrayList<String> reported;
    
    static {
        Report.reported = new ArrayList<String>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§c#@$!@#");
            return true;
        }
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("report")) {
            if (args.length >= 2) {
                final Player target = p.getServer().getPlayer(args[0]);
                if (target != null) {
                    if (Report.reported.contains(p.getName())) {
                        p.sendMessage(String.valueOf(Config.prefix) + "§7Esse jogador ja foi reportado.");
                        return true;
                    }
                    final String reportMsg = StringUtils.join((Object[])Arrays.copyOfRange(args, 1, args.length), " ");
                    Report.reported.add(p.getName());
                    p.sendMessage(String.valueOf(Config.prefix) + "§7Obrigado pelo report.");
                    p.playSound(p.getLocation(), Sound.ANVIL_USE, 2.0f, 2.0f);
                    Player[] arrayOfPlayer;
                    for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
                        final Player s = arrayOfPlayer[i];
                        if (s.hasPermission("guikits.report")) {
                            s.playSound(s.getLocation(), Sound.LEVEL_UP, 15.0f, 1.0f);
                            s.sendMessage("§7---------- §7[ " + Config.svs + " §7]§7----------");
                            s.sendMessage(" ");
                            s.sendMessage("§7Suspeito: " + Config.cor + target.getName());
                            s.sendMessage("§7Vitima: " + Config.cor + p.getName());
                            s.sendMessage("§7Motivo: " + Config.cor + reportMsg);
                            s.sendMessage(" ");
                            s.sendMessage("§7---------- §7[ " + Config.svs + " §7]§7----------");
                        }
                    }
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            Report.reported.remove(p.getName());
                        }
                    }, 250L);
                }
                else {
                    p.sendMessage(Main.JogadorOff);
                }
            }
            else {
                p.sendMessage("§aUse /report <Player> <Motivo>");
            }
        }
        return false;
    }
}
