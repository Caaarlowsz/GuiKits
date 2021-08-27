package me.RaidzDev.Habilidades;

import org.bukkit.event.player.*;
import org.bukkit.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import me.RaidzDev.*;
import org.bukkit.inventory.*;

public class Specialist implements Listener
{
    @EventHandler
    public void Clicar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getMaterial() == Material.BOOK && e.getItem().getType() == Material.BOOK && KitAPI.getkit(p) == "Specialist") {
            p.openEnchanting(p.getLocation(), true);
        }
    }
    
    @EventHandler
    public void Matar(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final Player t = e.getEntity().getKiller();
        if (p instanceof Player && t instanceof Player && KitAPI.getkit(t) == "Specialist") {
            t.sendMessage("Voc\u00ea ganhou 1 pote de xp por matar: " + Config.cor + p.getName());
            t.getInventory().setItem(8, new ItemStack(Material.EXP_BOTTLE));
        }
    }
}
