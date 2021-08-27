package me.RaidzDev.Comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import ca.wacos.nametagedit.*;

public class Tag implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("tag") || cmd.getName().equalsIgnoreCase("tags")) {
            final Player p = (Player)sender;
            if (args.length == 0) {
                p.sendMessage("§aUse: /tag <tag>.");
                return false;
            }
            if (args[0].equalsIgnoreCase("Normal")) {
                if (p.hasPermission("tag.normal")) {
                    p.sendMessage("§7Tag Modificada para: §7Normal");
                    p.setDisplayName("§7Normal " + getShortStr(p.getName()) + ChatColor.GRAY);
                    p.setPlayerListName("§7" + getShortStr(p.getName()) + ChatColor.GRAY);
                    NametagAPI.setPrefix(p.getName(), "§7");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o tem permiss\u00e3o !");
            }
            if (args[0].equalsIgnoreCase("mvp")) {
                if (p.hasPermission("tag.mvp")) {
                    p.sendMessage("§7Tag Modificada para: §9Mvp");
                    p.setDisplayName("§9MVP §7" + getShortStr(p.getName()) + ChatColor.GRAY);
                    p.setPlayerListName("§9" + getShortStr(p.getName()) + ChatColor.GRAY);
                    NametagAPI.setPrefix(p.getName(), "§9MVP §7");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o tem permiss\u00e3o !");
            }
            if (args[0].equalsIgnoreCase("pro")) {
                if (p.hasPermission("tag.pro")) {
                    p.sendMessage("§7Tag Modificada para: §6Pro");
                    p.setDisplayName("§6PRO §7" + getShortStr(p.getName()) + ChatColor.GRAY);
                    p.setPlayerListName("§6" + getShortStr(p.getName()) + ChatColor.GRAY);
                    NametagAPI.setPrefix(p.getName(), "§6PRO §7");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o tem permiss\u00e3o !");
            }
            if (args[0].equalsIgnoreCase("vip")) {
                if (p.hasPermission("tag.vip")) {
                    p.sendMessage("§7Tag Modificada para: §aVip");
                    p.setDisplayName("§aVIP §7" + getShortStr(p.getName()) + ChatColor.GRAY);
                    p.setPlayerListName("§a" + getShortStr(p.getName()) + ChatColor.GRAY);
                    NametagAPI.setPrefix(p.getName(), "§aVIP §7");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o tem permiss\u00e3o !");
            }
            if (args[0].equalsIgnoreCase("builder")) {
                if (p.hasPermission("tag.builder")) {
                    p.sendMessage("§7Tag Modificada para: §2Builder");
                    p.setDisplayName("§2BUILDER §7" + getShortStr(p.getName()) + ChatColor.GRAY);
                    p.setPlayerListName("§2" + getShortStr(p.getName()) + ChatColor.GRAY);
                    NametagAPI.setPrefix(p.getName(), "§2BUILDER §7");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o tem permiss\u00e3o !");
            }
            if (args[0].equalsIgnoreCase("youtuber")) {
                if (p.hasPermission("tag.youtuber")) {
                    p.sendMessage("§7Tag Modificada para: §bYoutuber");
                    p.setDisplayName("§bYT §7" + getShortStr(p.getName()) + ChatColor.GRAY);
                    p.setPlayerListName("§b" + getShortStr(p.getName()) + ChatColor.GRAY);
                    NametagAPI.setPrefix(p.getName(), "§bYOUTUBER §7");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o tem permiss\u00e3o !");
            }
            if (args[0].equalsIgnoreCase("trial")) {
                if (p.hasPermission("tag.trial") || p.hasPermission("tag.trialmod")) {
                    p.sendMessage("§7Tag Modificada para: §dTrialMod");
                    p.setDisplayName("§dTRIAL §7" + getShortStr(p.getName()) + ChatColor.GRAY);
                    p.setPlayerListName("§d" + getShortStr(p.getName()) + ChatColor.GRAY);
                    NametagAPI.setPrefix(p.getName(), "§dTRIALMOD §7");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o tem permiss\u00e3o !");
            }
            if (args[0].equalsIgnoreCase("Dev")) {
                if (p.getName().equalsIgnoreCase("RaidzDev")) {
                    p.sendMessage("§7Tag Modificada para: §8§oDev");
                    p.setDisplayName("§8§oDEV §7" + getShortStr(p.getName()) + ChatColor.GRAY);
                    p.setPlayerListName("§8§o" + getShortStr(p.getName()) + ChatColor.GRAY);
                    NametagAPI.setPrefix(p.getName(), "§8§oDEVELOPER §7");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o e o criador do plugin!");
            }
            if (args[0].equalsIgnoreCase("Admin")) {
                if (p.hasPermission("tag.Admin")) {
                    p.sendMessage("§7Tag Modificada para: §cAdmin");
                    p.setDisplayName("§cADMIN §7" + getShortStr(p.getName()) + ChatColor.GRAY);
                    p.setPlayerListName("§c" + getShortStr(p.getName()) + ChatColor.GRAY);
                    NametagAPI.setPrefix(p.getName(), "§cADMIN §7");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o tem permiss\u00e3o !");
            }
            if (args[0].equalsIgnoreCase("Dono")) {
                if (p.hasPermission("tag.Dono")) {
                    p.sendMessage("§7Tag Modificada para: §4Dono");
                    p.setDisplayName("§4DONO §7" + getShortStr(p.getName()) + ChatColor.GRAY);
                    p.setPlayerListName("§4" + getShortStr(p.getName()) + ChatColor.GRAY);
                    NametagAPI.setPrefix(p.getName(), "§4DONO §7");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o tem permiss\u00e3o !");
            }
            if (args[0].equalsIgnoreCase("mod")) {
                if (p.hasPermission("tag.mod")) {
                    p.sendMessage("§7Tag Modificada para: §5Mod");
                    p.setDisplayName("§5MOD §7" + getShortStr(p.getName()) + ChatColor.GRAY);
                    p.setPlayerListName("§5" + getShortStr(p.getName()) + ChatColor.GRAY);
                    NametagAPI.setPrefix(p.getName(), "§5MOD §7");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o tem permiss\u00e3o !");
            }
        }
        return false;
    }
    
    public static String getShortStr(final String s) {
        if (s.length() == 16) {
            final String shorts = s.substring(0, s.length() - 6);
            return shorts;
        }
        if (s.length() == 15) {
            final String shorts = s.substring(0, s.length() - 5);
            return shorts;
        }
        if (s.length() == 14) {
            final String shorts = s.substring(0, s.length() - 4);
            return shorts;
        }
        if (s.length() == 13) {
            final String shorts = s.substring(0, s.length() - 4);
            return shorts;
        }
        if (s.length() == 12) {
            final String shorts = s.substring(0, s.length() - 2);
            return shorts;
        }
        if (s.length() == 11) {
            final String shorts = s.substring(0, s.length() - 1);
            return shorts;
        }
        return s;
    }
}
