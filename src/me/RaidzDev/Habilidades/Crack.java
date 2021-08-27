package me.RaidzDev.Habilidades;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;

public class Crack implements Listener
{
    @EventHandler
    public void Bater(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player t = (Player)e.getDamager();
            if (KitAPI.getkit(t) == "Crack" && t.getItemInHand().getType() == Material.WOOD_SWORD && new Random().nextInt(100) <= 25) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 2, true));
            }
        }
    }
}
