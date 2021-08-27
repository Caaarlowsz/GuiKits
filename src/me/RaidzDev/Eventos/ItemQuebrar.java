package me.RaidzDev.Eventos;

import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;

public class ItemQuebrar implements Listener
{
    @EventHandler
    public void Andar(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final ItemStack item1 = p.getItemInHand();
        final Material Material1 = Material.getMaterial(item1.getTypeId());
        if (!Material1.isBlock() && Material1.getMaxDurability() >= 1 && item1.getDurability() != 0) {
            p.getItemInHand().setDurability((short)0);
            p.updateInventory();
        }
        final PlayerInventory item2 = p.getInventory();
        if (p.getInventory().getHelmet() != null) {
            final Material material2 = Material.getMaterial(item2.getHelmet().getTypeId());
            if (!material2.isBlock() && material2.getMaxDurability() >= 1 && item2.getHelmet().getDurability() != 0) {
                p.getInventory().getHelmet().setDurability((short)0);
                p.updateInventory();
            }
        }
        if (p.getInventory().getChestplate() != null) {
            final Material material2 = Material.getMaterial(item2.getChestplate().getTypeId());
            if (!material2.isBlock() && material2.getMaxDurability() >= 1 && item2.getChestplate().getDurability() != 0) {
                p.getInventory().getChestplate().setDurability((short)0);
                p.updateInventory();
            }
        }
        if (p.getInventory().getLeggings() != null) {
            final Material material2 = Material.getMaterial(item2.getLeggings().getTypeId());
            if (!material2.isBlock() && material2.getMaxDurability() >= 1 && item2.getLeggings().getDurability() != 0) {
                p.getInventory().getLeggings().setDurability((short)1);
                p.updateInventory();
            }
        }
        if (p.getInventory().getBoots() != null) {
            final Material material2 = Material.getMaterial(item2.getBoots().getTypeId());
            if (!material2.isBlock() && material2.getMaxDurability() >= 1 && item2.getBoots().getDurability() != 0) {
                p.getInventory().getBoots().setDurability((short)0);
                p.updateInventory();
            }
        }
    }
}
