package me.RaidzDev.Habilidades;

import me.RaidzDev.Eventos.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Swords implements Listener
{
    @EventHandler
    public void Dropando(final PlayerDropItemEvent e) {
        final Player p = e.getPlayer();
        final ItemStack item = e.getItemDrop().getItemStack();
        if (KitAPI.getkit(p) == "Swords" && item.getItemMeta().getDisplayName().contains("Swords")) {
            e.setCancelled(true);
            p.updateInventory();
        }
    }
    
    @EventHandler
    public void SwordsAlterner(final PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        if (player.getItemInHand() != null && player.getItemInHand().getType() != Material.AIR) {
            final ItemStack hand = player.getItemInHand();
            if (KitAPI.getkit(player) == "Swords") {
                if (hand.hasItemMeta() && hand.getItemMeta().hasDisplayName() && hand.getItemMeta().getDisplayName().equals("Madeira")) {
                    final ItemStack Pedra = new ItemStack(Material.STONE_SWORD);
                    final ItemMeta MetaPedra = Pedra.getItemMeta();
                    MetaPedra.setDisplayName("Pedra");
                    Pedra.setItemMeta(MetaPedra);
                    player.setItemInHand(Pedra);
                }
                else if (hand.hasItemMeta() && hand.getItemMeta().hasDisplayName() && hand.getItemMeta().getDisplayName().equals("Pedra")) {
                    final ItemStack Gold = new ItemStack(Material.GOLD_SWORD);
                    final ItemMeta MetaGold = Gold.getItemMeta();
                    MetaGold.setDisplayName("Ouro");
                    Gold.setItemMeta(MetaGold);
                    player.setItemInHand(Gold);
                }
                else if (hand.hasItemMeta() && hand.getItemMeta().hasDisplayName() && hand.getItemMeta().getDisplayName().equals("Ouro")) {
                    final ItemStack Iron = new ItemStack(Material.IRON_SWORD);
                    final ItemMeta MetaIron = Iron.getItemMeta();
                    MetaIron.setDisplayName("Ferro");
                    Iron.setItemMeta(MetaIron);
                    player.setItemInHand(Iron);
                }
                else if (hand.hasItemMeta() && hand.getItemMeta().hasDisplayName() && hand.getItemMeta().getDisplayName().equals("Ferro")) {
                    final ItemStack Madeira = new ItemStack(Material.WOOD_SWORD);
                    final ItemMeta MetaMadeira = Madeira.getItemMeta();
                    MetaMadeira.setDisplayName("Madeira");
                    Madeira.setItemMeta(MetaMadeira);
                    player.setItemInHand(Madeira);
                }
            }
        }
    }
}
