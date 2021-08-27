package me.RaidzDev.Habilidades;

import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.event.block.*;
import com.sk89q.worldguard.protection.flags.*;
import me.RaidzDev.*;
import java.util.*;
import org.bukkit.plugin.*;
import com.sk89q.worldguard.bukkit.*;
import com.sk89q.worldguard.protection.managers.*;
import com.sk89q.worldguard.protection.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Thor implements Listener
{
    public static ArrayList<Player> cooldown;
    
    static {
        Thor.cooldown = new ArrayList<Player>();
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.getkit(p) == "Thor" && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            final WorldGuardPlugin worldGuard = Main.getWorldGuard();
            final RegionManager regionManager = worldGuard.getRegionManager(p.getWorld());
            final ApplicableRegionSet set = regionManager.getApplicableRegions(p.getLocation());
            if (set.allows(DefaultFlag.PVP)) {
                final ItemStack hand = p.getItemInHand();
                if (hand.getType() == Material.GOLD_AXE) {
                    if (Thor.cooldown.contains(p)) {
                        p.sendMessage(Config.tempo);
                    }
                    else {
                        final Location loc = p.getTargetBlock((HashSet)null, 20).getLocation();
                        p.getWorld().strikeLightning(loc);
                        Thor.cooldown.add(p);
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                Thor.cooldown.remove(p);
                                p.sendMessage(Config.jakit);
                            }
                        }, 120L);
                    }
                }
            }
        }
    }
}
