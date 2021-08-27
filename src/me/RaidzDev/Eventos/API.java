package me.RaidzDev.Eventos;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class API
{
    private static HashMap<Player, String> Warp;
    
    static {
        API.Warp = new HashMap<Player, String>();
    }
    
    public static String getWarp(final Player joagdor) {
        if (API.Warp.containsKey(joagdor)) {
            return API.Warp.get(joagdor);
        }
        return "Spawn";
    }
    
    public static void setWarp(final Player jogador, final String warp) {
        API.Warp.put(jogador, warp);
    }
    
    public static void reloadPlayer(final Player p) {
        p.setGameMode(GameMode.ADVENTURE);
        p.getInventory().clear();
        p.getInventory().setArmorContents((ItemStack[])null);
        p.setLevel(0);
    }
}
