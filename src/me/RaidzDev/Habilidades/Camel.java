package me.RaidzDev.Habilidades;

import org.bukkit.event.player.*;
import org.bukkit.block.*;
import org.bukkit.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Camel implements Listener
{
    @EventHandler
    public void Andar(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if ((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND || e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SANDSTONE) && KitAPI.getkit(p) == "Camel") {
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 0));
        }
    }
}
