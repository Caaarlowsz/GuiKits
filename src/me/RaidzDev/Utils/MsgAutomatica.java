package me.RaidzDev.Utils;

import org.bukkit.plugin.*;
import org.bukkit.*;
import me.RaidzDev.*;
import org.bukkit.entity.*;

public class MsgAutomatica
{
    public MsgAutomatica(final Plugin plugin) {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                    final Player s = onlinePlayers[i];
                    s.sendMessage(Main.instance.configuracoes.getString("Mensagem1").replace("&", "§"));
                    Main.instance.save();
                    Main.instance.save1();
                    Main.instance.save2();
                    Main.instance.save3();
                }
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Player[] onlinePlayers;
                        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                            final Player s = onlinePlayers[i];
                            s.sendMessage(Main.instance.configuracoes.getString("Mensagem2").replace("&", "§"));
                            Main.instance.save();
                            Main.instance.save1();
                            Main.instance.save2();
                            Main.instance.save3();
                        }
                    }
                }, 1200L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Player[] onlinePlayers;
                        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                            final Player s = onlinePlayers[i];
                            s.sendMessage(Main.instance.configuracoes.getString("Mensagem3").replace("&", "§"));
                            Main.instance.save();
                            Main.instance.save1();
                            Main.instance.save2();
                            Main.instance.save3();
                        }
                    }
                }, 2400L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Player[] onlinePlayers;
                        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                            final Player s = onlinePlayers[i];
                            s.sendMessage(Main.instance.configuracoes.getString("Mensagem4").replace("&", "§"));
                            Main.instance.save();
                            Main.instance.save1();
                            Main.instance.save2();
                            Main.instance.save3();
                        }
                    }
                }, 4600L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Player[] onlinePlayers;
                        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                            final Player s = onlinePlayers[i];
                            s.sendMessage(Main.instance.configuracoes.getString("Mensagem5").replace("&", "§"));
                            Main.instance.save();
                            Main.instance.save1();
                            Main.instance.save2();
                            Main.instance.save3();
                        }
                    }
                }, 5800L);
            }
        }, 0L, 7000L);
    }
}
