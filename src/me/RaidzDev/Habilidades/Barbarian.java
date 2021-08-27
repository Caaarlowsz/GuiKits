package me.RaidzDev.Habilidades;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import me.RaidzDev.*;
import org.bukkit.enchantments.*;
import org.bukkit.event.*;

public class Barbarian implements Listener
{
    @EventHandler
    public void onKill(final PlayerDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            final Player k = e.getEntity().getKiller();
            if (KitAPI.getkit(k) == "Barbarian") {
                if (k.getItemInHand().getType() == Material.WOOD_SWORD) {
                    k.setItemInHand(new ItemStack(Material.STONE_SWORD));
                    k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    k.sendMessage(ChatColor.GRAY + "Level: " + Config.cor + "1");
                }
                else if (k.getItemInHand().getType() == Material.STONE_SWORD) {
                    k.setItemInHand(new ItemStack(Material.IRON_SWORD));
                    k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    k.sendMessage(ChatColor.GRAY + "Level: " + Config.cor + "2");
                }
                else if (k.getItemInHand().getType() == Material.IRON_SWORD) {
                    k.setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
                    k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    k.sendMessage(ChatColor.GRAY + "Level: " + Config.cor + "3");
                }
                else if (k.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                    final int max = 1;
                    if (k.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
                        final int lvl = k.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL);
                        if (lvl + 1 <= max) {
                            k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
                            k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, lvl + 1);
                            k.updateInventory();
                            k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                            if (lvl + 1 == 1) {
                                k.sendMessage(ChatColor.GRAY + "Level: " + Config.cor + "5");
                            }
                        }
                        if (lvl + 1 == 0) {
                            k.sendMessage("§cVoc\u00ea ja est\u00e1 no level Maximo!");
                        }
                    }
                    else {
                        k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
                        k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                        k.sendMessage(ChatColor.GRAY + "Level: " + Config.cor + "4");
                    }
                }
            }
        }
    }
}
