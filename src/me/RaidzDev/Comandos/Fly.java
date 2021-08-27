package me.RaidzDev.Comandos;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import me.RaidzDev.*;
import me.RaidzDev.Eventos.*;

public class Fly implements CommandExecutor, Listener
{
    public static ArrayList<Player> fly;
    
    static {
        Fly.fly = new ArrayList<Player>();
    }
    
    @EventHandler
    public void noCommand(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (Fly.fly.contains(p) && !e.getMessage().toLowerCase().startsWith("/fly")) {
            e.setCancelled(true);
            p.sendMessage(String.valueOf(Config.prefix) + "Saia do modo fly para executar qualquer comando!");
        }
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (Cmd.getName().equalsIgnoreCase("fly")) {
            final Player p = (Player)Sender;
            if (!p.hasPermission("guikits.fly")) {
                p.sendMessage(Main.Permiss\u00e3o);
                return true;
            }
            if (!Fly.fly.contains(p) && API.getWarp(p) == "Spawn") {
                p.sendMessage(String.valueOf(Config.prefix) + "Fly ativado.");
                p.setAllowFlight(true);
                Fly.fly.add(p);
                return true;
            }
            if (Fly.fly.contains(p) && API.getWarp(p) == "Spawn") {
                p.sendMessage(String.valueOf(Config.prefix) + "Fly desativado.");
                p.setAllowFlight(false);
                Fly.fly.remove(p);
                return true;
            }
            if (API.getWarp(p) != "Spawn") {
                p.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea so pode usar o fly no spawn!");
            }
        }
        return false;
    }
}
