package me.RaidzDev.Habilidades;

import me.RaidzDev.Eventos.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import java.util.*;
import org.bukkit.*;
import java.util.concurrent.*;
import me.RaidzDev.*;
import org.bukkit.block.*;

public class Flash implements Listener
{
    public static HashMap<String, Long> cooldown;
    
    static {
        Flash.cooldown = new HashMap<String, Long>();
    }
    
    @EventHandler
    public void onDrop(final PlayerDropItemEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.getkit(p) == "Flash" && e.getItemDrop().getItemStack().getType() == Material.REDSTONE_TORCH_ON) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void SonicClick(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.getMaterial(76) && KitAPI.getkit(p) == "Flash" && (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void flash(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && KitAPI.getkit(p) == "Flash" && p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON) {
            if (!Flash.cooldown.containsKey(p.getName()) || Flash.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                final Block b = p.getTargetBlock((HashSet)null, 100).getRelative(BlockFace.UP);
                p.teleport(b.getLocation());
                p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 4.0f, 4.0f);
                Flash.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
                return;
            }
            p.sendMessage(Config.tempo);
        }
    }
}
