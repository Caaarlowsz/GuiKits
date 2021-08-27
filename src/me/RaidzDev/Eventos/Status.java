package me.RaidzDev.Eventos;

import org.bukkit.entity.*;
import me.RaidzDev.*;

public class Status
{
    public static void addKill(final Player p) {
        final int Value = Main.getInstance().status.getInt(p.getUniqueId() + ".Kills");
        Main.getInstance().status.set(p.getUniqueId() + ".Kills", (Object)(Value + 1));
        Main.getInstance().save();
    }
    
    public static void addDeaths(final Player p) {
        final int Value = Main.getInstance().status.getInt(p.getUniqueId() + ".Deaths");
        Main.getInstance().status.set(p.getUniqueId() + ".Deaths", (Object)(Value + 1));
        Main.getInstance().save();
    }
    
    public static void addMoney(final Player p) {
        final int Value = Main.getInstance().status.getInt(p.getUniqueId() + ".Money");
        Main.getInstance().status.set(p.getUniqueId() + ".Money", (Object)(Value + 100));
        Main.getInstance().save();
    }
    
    public static void addMoney1(final Player p, final int add) {
        final int Value = Main.getInstance().status.getInt(p.getUniqueId() + ".Money");
        Main.getInstance().status.set(p.getUniqueId() + ".Money", (Object)(Value + add));
        Main.getInstance().save();
    }
    
    public static void removeMoney(final Player p) {
        final int Value = Main.getInstance().status.getInt(p.getUniqueId() + ".Money");
        if (Value - 60 > 0) {
            Main.getInstance().status.set(p.getUniqueId() + ".Money", (Object)(Value - 60));
        }
        else {
            Main.getInstance().status.set(p.getUniqueId() + ".Money", (Object)0);
        }
        Main.getInstance().save();
    }
    
    public static void removeMoney(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(p.getUniqueId() + ".Money");
        if (Value - i > 0) {
            Main.getInstance().status.set(p.getUniqueId() + ".Money", (Object)(Value - i));
        }
        else {
            Main.getInstance().status.set(p.getUniqueId() + ".Money", (Object)0);
        }
        Main.getInstance().save();
    }
    
    public static int getKills(final Player p) {
        return Main.getInstance().status.getInt(p.getUniqueId() + ".Kills");
    }
    
    public static int getDeaths(final Player p) {
        return Main.getInstance().status.getInt(p.getUniqueId() + ".Deaths");
    }
    
    public static int getMoney(final Player p) {
        return Main.getInstance().status.getInt(p.getUniqueId() + ".Money");
    }
}
