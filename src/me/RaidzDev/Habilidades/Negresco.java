package me.RaidzDev.Habilidades;

import org.bukkit.inventory.*;
import org.bukkit.event.player.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.event.block.*;
import org.bukkit.util.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.meta.*;
import me.RaidzDev.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class Negresco implements Listener
{
    public int boost;
    public static ArrayList<String> sonic;
    ArrayList<String> fall;
    public static List<Player> cooldownm;
    public static HashMap<String, ItemStack[]> Armadura;
    
    static {
        Negresco.sonic = new ArrayList<String>();
        Negresco.cooldownm = new ArrayList<Player>();
        Negresco.Armadura = new HashMap<String, ItemStack[]>();
    }
    
    public Negresco() {
        this.boost = 6;
        this.fall = new ArrayList<String>();
    }
    
    @EventHandler
    public void VelotrolClick(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getPlayer().getItemInHand().getType() == Material.COAL_BLOCK && KitAPI.getkit(p) == "Negresco") {
            if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                e.setCancelled(true);
                p.playSound(p.getLocation(), Sound.BURP, 2.0f, 2.0f);
            }
            if (Negresco.cooldownm.contains(p)) {
                p.sendMessage(Config.tempo);
                return;
            }
            Negresco.cooldownm.add(p);
            p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
            p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 10, 10);
            final Location loc = p.getLocation();
            for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
                if (pertos instanceof Player) {
                    final Player perto = (Player)pertos;
                    ((Player)pertos).damage(10.0);
                    pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
                    ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 105, 105));
                    ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 105, 105));
                }
            }
            final ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
            final LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
            kCapacete.setColor(Color.BLACK);
            Capacete.setItemMeta((ItemMeta)kCapacete);
            final ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
            final LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
            kPeitoral.setColor(Color.BLACK);
            Peitoral.setItemMeta((ItemMeta)kPeitoral);
            final ItemStack Cal\u00e7a = new ItemStack(Material.LEATHER_LEGGINGS);
            final LeatherArmorMeta kCal\u00e7a = (LeatherArmorMeta)Cal\u00e7a.getItemMeta();
            kCal\u00e7a.setColor(Color.BLACK);
            Cal\u00e7a.setItemMeta((ItemMeta)kCal\u00e7a);
            final ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
            final LeatherArmorMeta kBota = (LeatherArmorMeta)Capacete.getItemMeta();
            kBota.setColor(Color.BLACK);
            Bota.setItemMeta((ItemMeta)kBota);
            Negresco.Armadura.put(p.getName(), p.getInventory().getArmorContents());
            p.getInventory().setHelmet(Capacete);
            p.getInventory().setChestplate(Peitoral);
            p.getInventory().setLeggings(Cal\u00e7a);
            p.getInventory().setBoots(Bota);
            p.updateInventory();
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.getInventory().setHelmet((ItemStack)null);
                    p.getInventory().setChestplate((ItemStack)null);
                    p.getInventory().setLeggings((ItemStack)null);
                    p.getInventory().setBoots((ItemStack)null);
                    p.updateInventory();
                }
            }, 50L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    Negresco.cooldownm.remove(p);
                    p.sendMessage(Config.jakit);
                    p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
                }
            }, 700L);
        }
    }
    
    @EventHandler
    public void onPlayerDamageSponge(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL && this.fall.contains(p.getName())) {
            this.fall.remove(p.getName());
            e.setDamage(6.5);
        }
    }
}
