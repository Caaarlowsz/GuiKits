package me.RaidzDev.Eventos;

import org.bukkit.event.*;
import org.bukkit.entity.*;
import me.RaidzDev.*;
import org.bukkit.*;
import org.bukkit.scoreboard.*;

public class ScoreBoard implements Listener
{
    public static Main plugin;
    
    public static void onScoreboard(final Player p) {
        final SimpleScoreboard scoreboard = new SimpleScoreboard("    " + Config.svs + "   ");
        scoreboard.blankLine();
        scoreboard.add("§7» §fClasse: " + Config.cor + KitAPI.getkit(p));
        scoreboard.add("§7» §fCoins: " + Config.cor + Status.getMoney(p));
        scoreboard.add("§a");
        scoreboard.add("§7» §fKills: " + Config.cor + Status.getKills(p));
        scoreboard.add("§7» §fDeaths: " + Config.cor + Status.getDeaths(p));
        scoreboard.add("§7» §fKS: " + Config.cor + KillStreak.getkills(p));
        scoreboard.add("§a§c");
        scoreboard.add("    " + Config.site + "    ");
        scoreboard.build();
        scoreboard.send(new Player[] { p });
    }
    
    public static void removeScoreBoard(final Player p) {
        final Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective o = score.registerNewObjective("gui", "kits");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName("");
        p.setScoreboard(score);
    }
}
