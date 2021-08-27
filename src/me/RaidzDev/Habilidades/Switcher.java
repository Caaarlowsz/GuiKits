package me.RaidzDev.Habilidades;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Switcher implements Listener
{
    @EventHandler
    public void snowball(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Snowball && e.getEntity() instanceof Player) {
            final Snowball s = (Snowball)e.getDamager();
            if (s.getShooter() instanceof Player) {
                final Player shooter = (Player)s.getShooter();
                if (KitAPI.getkit(shooter) == "Switcher") {
                    final Location shooterLoc = shooter.getLocation();
                    shooter.teleport(e.getEntity().getLocation());
                    e.getEntity().teleport(shooterLoc);
                    shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.ENDER_SIGNAL, 10);
                    shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.EXTINGUISH, 10);
                    shooter.getWorld().playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.2f);
                }
            }
        }
    }
}
