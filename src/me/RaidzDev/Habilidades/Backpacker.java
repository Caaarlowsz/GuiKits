package me.RaidzDev.Habilidades;

import java.util.*;
import org.bukkit.event.player.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import me.RaidzDev.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;

public class Backpacker implements Listener
{
    static List<String> cooldownbk;
    
    static {
        Backpacker.cooldownbk = new ArrayList<String>();
    }
    
    @EventHandler
    public void backpackerKit(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§eSopas");
        sopa.setItemMeta(sopas);
        if (p.getItemInHand().getType() == Material.NETHER_STAR && KitAPI.getkit(p) == "Backpacker") {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                event.setCancelled(true);
            }
            if (Backpacker.cooldownbk.contains(p)) {
                p.sendMessage("§cAguarde o Cooldown!");
                return;
            }
            Backpacker.cooldownbk.add(p.getName());
            final Inventory v = Bukkit.createInventory((InventoryHolder)null, 27, "§eBackpacker");
            for (int i = 0; i < 27; ++i) {
                v.addItem(new ItemStack[] { new ItemStack(sopa) });
            }
            event.getPlayer().openInventory(v);
            Backpacker.cooldownbk.add(p.getName());
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Backpacker.cooldownbk.remove(p);
                }
            }, 750L);
        }
    }
}
