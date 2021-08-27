package me.RaidzDev.Habilidades;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.plugin.*;
import org.bukkit.metadata.*;
import java.util.concurrent.*;
import me.RaidzDev.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.util.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class Ryu implements Listener
{
    public static HashMap<String, Long> cooldown;
    
    static {
        Ryu.cooldown = new HashMap<String, Long>();
    }
    
    @EventHandler
    public void hadouken(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && KitAPI.getkit(p) == "Ryu" && p.getItemInHand().getType() == Material.BEACON) {
            if (!Ryu.cooldown.containsKey(p.getName()) || Ryu.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                final Location location = p.getEyeLocation();
                final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 40);
                while (blocksToAdd.hasNext()) {
                    final Location blockToAdd = blocksToAdd.next().getLocation();
                    p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object)Material.BEACON, 20);
                    p.playSound(blockToAdd, Sound.IRONGOLEM_THROW, 3.0f, 3.0f);
                }
                final Snowball h = (Snowball)p.launchProjectile((Class)Snowball.class);
                final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
                h.setVelocity(velo1);
                h.setMetadata("hadouken", (MetadataValue)new FixedMetadataValue((Plugin)Main.instance, (Object)true));
                Ryu.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
                return;
            }
            p.sendMessage(Config.tempo);
        }
    }
    
    @EventHandler
    public void dano(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Snowball) {
            final Snowball s = (Snowball)e.getDamager();
            if (s.hasMetadata("hadouken")) {
                e.setDamage(e.getDamage() + 7.0);
            }
        }
    }
}
