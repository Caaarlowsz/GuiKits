package me.RaidzDev.Eventos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.*;

public class Warp implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("warp")) {
            abrirguiWarps(p);
        }
        return false;
    }
    
    public static void abrirguiWarps(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 27, "§7Warps");
        final ItemStack vidro = new ItemStack(Material.getMaterial(160), 1, (short)15);
        final ItemMeta zvidro = vidro.getItemMeta();
        zvidro.setDisplayName("§7§o-");
        vidro.setItemMeta(zvidro);
        final ItemStack vidro2 = new ItemStack(Material.getMaterial(160), 1, (short)15);
        final ItemMeta zvidro2 = vidro2.getItemMeta();
        zvidro2.setDisplayName("§7§o-");
        vidro2.setItemMeta(zvidro2);
        final ItemStack fps = new ItemStack(Material.GLASS);
        final ItemMeta zfps = fps.getItemMeta();
        zfps.setDisplayName("§7Warp FPS");
        fps.setItemMeta(zfps);
        final ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
        final ItemMeta zlava = lava.getItemMeta();
        zlava.setDisplayName("§7Warp Challenge");
        lava.setItemMeta(zlava);
        final ItemStack rdm = new ItemStack(Material.getMaterial(101));
        final ItemMeta zrdm = rdm.getItemMeta();
        zrdm.setDisplayName("§7Evento RDM");
        rdm.setItemMeta(zrdm);
        final ItemStack mdr = new ItemStack(Material.CAKE);
        final ItemMeta zmdr = mdr.getItemMeta();
        zmdr.setDisplayName("§7Evento MDR");
        mdr.setItemMeta(zmdr);
        final ItemStack Knock = new ItemStack(Material.STICK);
        final ItemMeta zKnock = Knock.getItemMeta();
        zKnock.setDisplayName("§7Warp Knock");
        Knock.setItemMeta(zKnock);
        inv.setItem(0, vidro2);
        inv.setItem(1, vidro2);
        inv.setItem(2, vidro2);
        inv.setItem(3, vidro2);
        inv.setItem(4, vidro2);
        inv.setItem(5, vidro);
        inv.setItem(6, vidro);
        inv.setItem(7, vidro);
        inv.setItem(8, vidro);
        inv.setItem(9, vidro2);
        inv.setItem(10, vidro);
        inv.setItem(11, fps);
        inv.setItem(12, lava);
        inv.setItem(13, Knock);
        inv.setItem(14, mdr);
        inv.setItem(15, rdm);
        inv.setItem(16, vidro);
        inv.setItem(17, vidro);
        inv.setItem(18, vidro2);
        inv.setItem(19, vidro2);
        inv.setItem(20, vidro2);
        inv.setItem(21, vidro2);
        inv.setItem(22, vidro);
        inv.setItem(23, vidro);
        inv.setItem(24, vidro);
        inv.setItem(25, vidro);
        inv.setItem(26, vidro);
        p.openInventory(inv);
    }
    
    @EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§7Warps") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.GLASS) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/fps");
                return;
            }
            if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/challenge");
                return;
            }
            if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/rdm");
                return;
            }
            if (e.getCurrentItem().getType() == Material.CAKE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/mdr");
                return;
            }
            if (e.getCurrentItem().getType() == Material.STICK) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/knock");
            }
        }
    }
}
