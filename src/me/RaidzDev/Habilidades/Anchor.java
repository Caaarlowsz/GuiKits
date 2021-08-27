package me.RaidzDev.Habilidades;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.util.*;
import org.bukkit.*;
import me.RaidzDev.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;

public class Anchor implements Listener
{
    @EventHandler
    private void habilidadeAnchor(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player jogador = (Player)e.getEntity();
        final Player anchor = (Player)e.getDamager();
        if (KitAPI.getkit(jogador) == "Anchor") {
            jogador.setVelocity(new Vector());
            jogador.playSound(jogador.getLocation(), Sound.ANVIL_BREAK, 3.0f, 3.0f);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public final void run() {
                    jogador.setVelocity(new Vector());
                }
            }, 1L);
        }
        if (KitAPI.getkit(jogador) == "Anchor") {
            anchor.playSound(anchor.getLocation(), Sound.ANVIL_BREAK, 3.0f, 3.0f);
            jogador.setVelocity(new Vector());
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public final void run() {
                    jogador.setVelocity(new Vector());
                }
            }, 1L);
        }
    }
}
