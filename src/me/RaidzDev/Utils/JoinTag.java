package me.RaidzDev.Utils;

import org.bukkit.event.player.*;
import org.bukkit.*;
import ca.wacos.nametagedit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class JoinTag implements Listener
{
    public static String getShortStr(final String name) {
        if (name.length() == 16) {
            final String shorts = name.substring(0, name.length() - 5);
            return shorts;
        }
        if (name.length() == 15) {
            final String shorts = name.substring(0, name.length() - 4);
            return shorts;
        }
        return name;
    }
    
    public static String getMod(final String name) {
        if (name.length() == 16) {
            final String shorts = name.substring(0, name.length() - 4);
            return shorts;
        }
        if (name.length() == 15) {
            final String shorts = name.substring(0, name.length() - 3);
            return shorts;
        }
        if (name.length() == 14) {
            final String shorts = name.substring(0, name.length() - 2);
            return shorts;
        }
        if (name.length() == 13) {
            final String shorts = name.substring(0, name.length() - 1);
            return shorts;
        }
        return name;
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void NomeNoTab(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        String name = p.getName();
        if (name.length() + 4 >= 16) {
            name = name.substring(0, name.length() - 4);
        }
        if (p.hasPermission("*")) {
            p.setDisplayName("§4DONO §7" + getShortStr(p.getName()) + ChatColor.GRAY);
            p.setPlayerListName("§4" + getShortStr(p.getName()) + ChatColor.GRAY);
            NametagAPI.setPrefix(p.getName(), "§4DONO §7");
            return;
        }
        if (p.hasPermission("tag.pro")) {
            p.setDisplayName("§6PRO §7" + getShortStr(p.getName()) + ChatColor.GRAY);
            p.setPlayerListName("§6" + getShortStr(p.getName()) + ChatColor.GRAY);
            NametagAPI.setPrefix(p.getName(), "§6PRO §7");
            return;
        }
        if (p.hasPermission("tag.normal")) {
            p.setDisplayName("§7Normal " + getShortStr(p.getName()) + ChatColor.GRAY);
            p.setPlayerListName("§7" + getShortStr(p.getName()) + ChatColor.GRAY);
            NametagAPI.setPrefix(p.getName(), "§7");
            return;
        }
        if (p.hasPermission("tag.mvp")) {
            p.setDisplayName("§9MVP §7" + getShortStr(p.getName()) + ChatColor.GRAY);
            p.setPlayerListName("§9" + getShortStr(p.getName()) + ChatColor.GRAY);
            NametagAPI.setPrefix(p.getName(), "§9MVP §7");
            return;
        }
        if (p.hasPermission("tag.vip")) {
            p.setDisplayName("§aVIP §7" + getShortStr(p.getName()) + ChatColor.GRAY);
            p.setPlayerListName("§a" + getShortStr(p.getName()) + ChatColor.GRAY);
            NametagAPI.setPrefix(p.getName(), "§aVIP §7");
            return;
        }
        if (p.hasPermission("tag.admin")) {
            p.setDisplayName("§cADMIN §7" + getShortStr(p.getName()) + ChatColor.GRAY);
            p.setPlayerListName("§c" + getShortStr(p.getName()) + ChatColor.GRAY);
            NametagAPI.setPrefix(p.getName(), "§cADMIN §7");
            return;
        }
        if (p.hasPermission("tag.youtuber")) {
            p.setDisplayName("§bYT §7" + getShortStr(p.getName()) + ChatColor.GRAY);
            p.setPlayerListName("§b" + getShortStr(p.getName()) + ChatColor.GRAY);
            NametagAPI.setPrefix(p.getName(), "§bYOUTUBER §7");
            return;
        }
        if (p.hasPermission("tag.trial")) {
            p.setDisplayName("§dTRIAL §7" + getShortStr(p.getName()) + ChatColor.GRAY);
            p.setPlayerListName("§d" + getShortStr(p.getName()) + ChatColor.GRAY);
            NametagAPI.setPrefix(p.getName(), "§dTRIALMOD §7");
            return;
        }
        if (p.getName().equalsIgnoreCase("RaidzDev")) {
            p.setDisplayName("§8§oDEV §7" + getShortStr(p.getName()) + ChatColor.GRAY);
            p.setPlayerListName("§8§o" + getShortStr(p.getName()) + ChatColor.GRAY);
            NametagAPI.setPrefix(p.getName(), "§8§oDEVELOPER §7");
            return;
        }
        if (p.hasPermission("tag.mod")) {
            p.setDisplayName("§5MOD §7" + getShortStr(p.getName()) + ChatColor.GRAY);
            p.setPlayerListName("§5" + getShortStr(p.getName()) + ChatColor.GRAY);
            NametagAPI.setPrefix(p.getName(), "§5MOD §7");
            return;
        }
        if (p.hasPermission("tag.builder")) {
            p.setDisplayName("§2BUILDER §7" + getShortStr(p.getName()) + ChatColor.GRAY);
            p.setPlayerListName("§2" + getShortStr(p.getName()) + ChatColor.GRAY);
            NametagAPI.setPrefix(p.getName(), "§2BUILDER §7");
        }
    }
}
