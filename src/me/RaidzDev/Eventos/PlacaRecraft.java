package me.RaidzDev.Eventos;

import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.block.*;
import me.RaidzDev.*;

public class PlacaRecraft implements Listener
{
    public static ItemStack sopa;
    public static ItemMeta sopameta;
    public static ItemStack cogu1;
    public static ItemMeta cogu1meta;
    public static ItemStack cogu2;
    public static ItemMeta cogu2meta;
    public static ItemStack pote;
    public static ItemMeta potemeta;
    
    @EventHandler
    public void Escrever(final SignChangeEvent e) {
        final Player p = e.getPlayer();
        if (p.hasPermission("placa.recraft") && e.getLine(0).equalsIgnoreCase("recraft")) {
            e.setLine(0, "§e---------");
            e.setLine(1, "§eKitPvP");
            e.setLine(2, "§6Recraft");
            e.setLine(3, "§e---------");
        }
    }
    
    @EventHandler
    public void inv(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null && (e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN_POST)) {
            final Sign s = (Sign)e.getClickedBlock().getState();
            final String[] lines = s.getLines();
            if (lines.length > 0 && lines[0].equals("§e---------") && lines.length > 1 && lines[1].equals("§eKitPvP") && lines.length > 2 && lines[2].equals("§6Recraft") && lines.length > 3 && lines[3].equals("§e---------")) {
                PlacaRecraft.cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
                (PlacaRecraft.cogu1meta = PlacaRecraft.cogu1.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Recraft");
                PlacaRecraft.cogu1.setItemMeta(PlacaRecraft.cogu1meta);
                PlacaRecraft.cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
                (PlacaRecraft.cogu2meta = PlacaRecraft.cogu2.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Recraft");
                PlacaRecraft.cogu2.setItemMeta(PlacaRecraft.cogu2meta);
                PlacaRecraft.pote = new ItemStack(Material.BOWL, 64);
                (PlacaRecraft.potemeta = PlacaRecraft.pote.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Recraft");
                PlacaRecraft.pote.setItemMeta(PlacaRecraft.potemeta);
                p.sendMessage(String.valueOf(Config.Aviso) + " §7Recraft Adicionado!");
                p.getInventory().addItem(new ItemStack[] { PlacaRecraft.cogu1 });
                p.getInventory().addItem(new ItemStack[] { PlacaRecraft.cogu2 });
                p.getInventory().addItem(new ItemStack[] { PlacaRecraft.pote });
                p.updateInventory();
            }
        }
    }
}
