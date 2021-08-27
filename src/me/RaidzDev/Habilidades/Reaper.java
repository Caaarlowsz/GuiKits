package me.RaidzDev.Habilidades;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;

public class Reaper implements Listener
{
    @EventHandler
    public void OnClick(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player damager = (Player)e.getDamager();
            final Player victim = (Player)e.getEntity();
            if (KitAPI.getkit(damager) == "Reaper") {
                KitAPI.getkit(damager);
                if (damager.getInventory().getItemInHand().getType() == Material.WOOD_HOE) {
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3));
                }
            }
        }
    }
}
