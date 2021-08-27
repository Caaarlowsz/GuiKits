package me.RaidzDev.Habilidades;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.event.entity.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import java.text.*;
import me.RaidzDev.*;

public class Ajnin implements Listener
{
    public HashMap<Player, Player> a;
    public HashMap<Player, Long> b;
    
    public Ajnin() {
        this.a = new HashMap<Player, Player>();
        this.b = new HashMap<Player, Long>();
    }
    
    @EventHandler
    public void a(final EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
        if (paramEntityDamageByEntityEvent.getDamager() instanceof Player && paramEntityDamageByEntityEvent.getEntity() instanceof Player) {
            final Player localPlayer1 = (Player)paramEntityDamageByEntityEvent.getDamager();
            final Player localPlayer2 = (Player)paramEntityDamageByEntityEvent.getEntity();
            if (KitAPI.getkit(localPlayer1) == "Ajnin") {
                this.a.put(localPlayer1, localPlayer2);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Backpacker.cooldownbk.remove(localPlayer1);
                    }
                }, 100L);
            }
        }
    }
    
    @EventHandler
    public void a(final PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
        final Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
        if (paramPlayerToggleSneakEvent.isSneaking() && KitAPI.getkit(localPlayer1) == "Ajnin" && this.a.containsKey(localPlayer1)) {
            final Player localPlayer2 = this.a.get(localPlayer1);
            if (localPlayer2 != null && !localPlayer2.isDead()) {
                String str = null;
                if (this.b.get(localPlayer1) != null) {
                    final long l = this.b.get(localPlayer1) - System.currentTimeMillis();
                    final DecimalFormat localDecimalFormat = new DecimalFormat("##");
                    final int i = (int)l / 1000;
                    str = localDecimalFormat.format(i);
                }
                if (this.b.get(localPlayer1) == null || this.b.get(localPlayer1) < System.currentTimeMillis()) {
                    if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0) {
                        localPlayer2.teleport(localPlayer1.getLocation());
                        localPlayer2.sendMessage("§7Voc\u00ea foi teletransportado para: " + Config.cor + localPlayer1.getName());
                        this.b.put(localPlayer1, System.currentTimeMillis() + 10000L);
                    }
                    else {
                        localPlayer1.sendMessage("§cJogador Est\u00e1 Muito Longe");
                    }
                }
                else {
                    localPlayer1.sendMessage(Config.tempo);
                }
            }
        }
    }
}
