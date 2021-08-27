package me.RaidzDev.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.RaidzDev.*;
import java.util.*;
import org.bukkit.*;

public class SetArena implements CommandExecutor
{
    public static Main plugin;
    
    public SetArena(final Main main) {
        SetArena.plugin = main;
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("SetArena") && !p.hasPermission("guikits.SetArena")) {
            p.sendMessage(Main.Permiss\u00e3o);
            return true;
        }
        if (Args.length == 0) {
            p.sendMessage("§aUse: /SetArena 1:7 ");
            return true;
        }
        if (Args[0].equalsIgnoreCase("1")) {
            p.sendMessage(String.valueOf(Config.prefix) + "Arena 1 Setada Com Sucesso ");
            Main.getInstance().arenas.set("arenas1X", (Object)p.getLocation().getX());
            Main.getInstance().arenas.set("arenas1Y", (Object)p.getLocation().getY());
            Main.getInstance().arenas.set("arenas1Z", (Object)p.getLocation().getZ());
            final World w = p.getWorld();
            Main.getInstance().arenas.set("arenas1World", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            Main.getInstance().save();
            Main.getInstance().save1();
            Main.getInstance().save2();
            Main.getInstance().save();
        }
        if (Args[0].equalsIgnoreCase("2")) {
            p.sendMessage(String.valueOf(Config.prefix) + "Arena 2 Setada Com Sucesso ");
            Main.getInstance().arenas.set("arenas2X", (Object)p.getLocation().getX());
            Main.getInstance().arenas.set("arenas2Y", (Object)p.getLocation().getY());
            Main.getInstance().arenas.set("arenas2Z", (Object)p.getLocation().getZ());
            final World w = p.getWorld();
            Main.getInstance().arenas.set("arenas2World", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
        }
        if (Args[0].equalsIgnoreCase("3")) {
            p.sendMessage(String.valueOf(Config.prefix) + "Arena 3 Setada Com Sucesso ");
            Main.getInstance().arenas.set("arenas3X", (Object)p.getLocation().getX());
            Main.getInstance().arenas.set("arenas3Y", (Object)p.getLocation().getY());
            Main.getInstance().arenas.set("arenas3Z", (Object)p.getLocation().getZ());
            final World w = p.getWorld();
            Main.getInstance().arenas.set("arenas3World", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            Main.getInstance().save();
            Main.getInstance().save1();
            Main.getInstance().save2();
            Main.getInstance().save3();
        }
        if (Args[0].equalsIgnoreCase("4")) {
            p.sendMessage(String.valueOf(Config.prefix) + "Arena 4 Setada Com Sucesso ");
            Main.getInstance().arenas.set("arenas4X", (Object)p.getLocation().getX());
            Main.getInstance().arenas.set("arenas4Y", (Object)p.getLocation().getY());
            Main.getInstance().arenas.set("arenas4Z", (Object)p.getLocation().getZ());
            final World w = p.getWorld();
            Main.getInstance().arenas.set("arenas4World", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
        }
        if (Args[0].equalsIgnoreCase("5")) {
            p.sendMessage(String.valueOf(Config.prefix) + "Arena 5 Setada Com Sucesso ");
            Main.getInstance().arenas.set("arenas5X", (Object)p.getLocation().getX());
            Main.getInstance().arenas.set("arenas5Y", (Object)p.getLocation().getY());
            Main.getInstance().arenas.set("arenas5Z", (Object)p.getLocation().getZ());
            final World w = p.getWorld();
            Main.getInstance().arenas.set("arenas5World", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            Main.getInstance().save();
            Main.getInstance().save1();
            Main.getInstance().save2();
            Main.getInstance().save3();
        }
        if (Args[0].equalsIgnoreCase("6")) {
            p.sendMessage(String.valueOf(Config.prefix) + "Arena 6 Setada Com Sucesso ");
            Main.getInstance().arenas.set("arenas6X", (Object)p.getLocation().getX());
            Main.getInstance().arenas.set("arenas6Y", (Object)p.getLocation().getY());
            Main.getInstance().arenas.set("arenas6Z", (Object)p.getLocation().getZ());
            final World w = p.getWorld();
            Main.getInstance().arenas.set("arenas6World", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            Main.getInstance().save();
            Main.getInstance().save1();
            Main.getInstance().save2();
            Main.getInstance().save3();
        }
        if (Args[0].equalsIgnoreCase("7")) {
            p.sendMessage(String.valueOf(Config.prefix) + "Arena 7 Setada Com Sucesso ");
            Main.getInstance().arenas.set("arenas7X", (Object)p.getLocation().getX());
            Main.getInstance().arenas.set("arenas7Y", (Object)p.getLocation().getY());
            Main.getInstance().arenas.set("arenas7Z", (Object)p.getLocation().getZ());
            final World w = p.getWorld();
            Main.getInstance().arenas.set("arenas7World", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            Main.getInstance().save1();
            Main.getInstance().save2();
            Main.getInstance().save3();
        }
        return false;
    }
    
    public static void TeleportArenaRandom(final Player p) {
        final Random dice = new Random();
        final int number = dice.nextInt(9);
        switch (number) {
            case 0: {
                final World w = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arenas1World"));
                final double x = Main.getInstance().arenas.getDouble("arenas1X");
                final double y = Main.getInstance().arenas.getDouble("arenas1Y");
                final double z = Main.getInstance().arenas.getDouble("arenas1Z");
                final Location lobby = new Location(w, x, y, z);
                p.teleport(lobby);
                break;
            }
            case 1: {
                final World w2 = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arenas2World"));
                final double x2 = Main.getInstance().arenas.getDouble("arenas2X");
                final double y2 = Main.getInstance().arenas.getDouble("arenas2Y");
                final double z2 = Main.getInstance().arenas.getDouble("arenas2Z");
                final Location lobby2 = new Location(w2, x2, y2, z2);
                p.teleport(lobby2);
                break;
            }
            case 2: {
                final World w3 = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arenas3World"));
                final double x3 = Main.getInstance().arenas.getDouble("arenas3X");
                final double y3 = Main.getInstance().arenas.getDouble("arenas3Y");
                final double z3 = Main.getInstance().arenas.getDouble("arenas3Z");
                final Location lobby3 = new Location(w3, x3, y3, z3);
                p.teleport(lobby3);
                break;
            }
            case 3: {
                final World w4 = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arenas4World"));
                final double x4 = Main.getInstance().arenas.getDouble("arenas4X");
                final double y4 = Main.getInstance().arenas.getDouble("arenas4Y");
                final double z4 = Main.getInstance().arenas.getDouble("arenas4Z");
                final Location lobby4 = new Location(w4, x4, y4, z4);
                p.teleport(lobby4);
                break;
            }
            case 4: {
                final World w5 = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arenas5World"));
                final double x5 = Main.getInstance().arenas.getDouble("arenas5X");
                final double y5 = Main.getInstance().arenas.getDouble("arenas5Y");
                final double z5 = Main.getInstance().arenas.getDouble("arenas5Z");
                final Location lobby5 = new Location(w5, x5, y5, z5);
                p.teleport(lobby5);
                break;
            }
            case 5: {
                final World w6 = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arenas6World"));
                final double x6 = Main.getInstance().arenas.getDouble("arenas6X");
                final double y6 = Main.getInstance().arenas.getDouble("arenas6Y");
                final double z6 = Main.getInstance().arenas.getDouble("arenas6Z");
                final Location lobby6 = new Location(w6, x6, y6, z6);
                p.teleport(lobby6);
                break;
            }
            case 6: {
                final World w7 = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arenas7World"));
                final double x7 = Main.getInstance().arenas.getDouble("arenas7X");
                final double y7 = Main.getInstance().arenas.getDouble("arenas7Y");
                final double z7 = Main.getInstance().arenas.getDouble("arenas7Z");
                final Location lobby7 = new Location(w7, x7, y7, z7);
                p.teleport(lobby7);
                break;
            }
        }
    }
}
