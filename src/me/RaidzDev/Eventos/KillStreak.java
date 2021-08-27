package me.RaidzDev.Eventos;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.event.entity.*;
import me.RaidzDev.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class KillStreak implements Listener
{
    public static HashMap<Player, Integer> streak;
    
    static {
        KillStreak.streak = new HashMap<Player, Integer>();
    }
    
    public static int getkills(final Player p) {
        if (!KillStreak.streak.containsKey(p)) {
            KillStreak.streak.put(p, 0);
        }
        return KillStreak.streak.get(p);
    }
    
    @EventHandler
    public void palmdnawuid(final PlayerDeathEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getEntity().getKiller() instanceof Player)) {
            return;
        }
        final Player p = e.getEntity();
        final Player k = e.getEntity().getKiller();
        if (!KillStreak.streak.containsKey(k)) {
            KillStreak.streak.put(k, 0);
        }
        if (KillStreak.streak.containsKey(k)) {
            KillStreak.streak.put(k, KillStreak.streak.get(k) + 1);
            KillStreak.streak.put(p, 0);
        }
        if (KillStreak.streak.get(k) == 5) {
            Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "§7O Jogador " + k.getName() + " Est\ufffd Com Um KillStreak de 5!");
        }
        if (KillStreak.streak.get(k) == 10) {
            Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "§7O Jogador " + k.getName() + " Est\ufffd Com Um KillStreak de 10!");
        }
        if (KillStreak.streak.get(k) == 15) {
            Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "§7O Jogador " + k.getName() + " Est\ufffd Com Um KillStreak de 15!");
        }
        if (KillStreak.streak.get(k) == 20) {
            Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "§7O Jogador " + k.getName() + " Est\ufffd Com Um KillStreak de 20!");
        }
        if (KillStreak.streak.get(k) == 30) {
            Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "§7O Jogador " + k.getName() + " Est\ufffd Com Um KillStreak de 30!");
        }
        if (KillStreak.streak.get(k) == 40) {
            Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "§7O Jogador " + k.getName() + " Est\ufffd Com Um KillStreak de 40!");
        }
        if (KillStreak.streak.get(k) == 50) {
            Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "§7O Jogador " + k.getName() + " Est\ufffd Com Um KillStreak de 50!");
        }
        if (KillStreak.streak.get(k) == 60) {
            Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "§7O Jogador " + k.getName() + " Est\ufffd Com Um KillStreak de 60!");
        }
        if (KillStreak.streak.get(k) == 70) {
            Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "§7O Jogador " + k.getName() + " Est\ufffd Com Um KillStreak de 70!");
        }
        if (KillStreak.streak.get(k) == 80) {
            Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "§7O Jogador " + k.getName() + " Est\ufffd Com Um KillStreak de 80!");
        }
        if (KillStreak.streak.get(k) == 90) {
            Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "§7O Jogador " + k.getName() + " Est\ufffd Com Um KillStreak de 90!");
        }
        if (KillStreak.streak.get(k) == 100) {
            Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "§7O Jogador " + k.getName() + " Est\ufffd Com Um KillStreak de 100!");
        }
    }
}
