package me.RaidzDev.Eventos;

import org.bukkit.inventory.meta.*;
import java.util.*;
import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import me.RaidzDev.*;

public class KitSelector2 implements Listener, CommandExecutor
{
    public static ItemStack vidro;
    public static ItemMeta vidrometa;
    public static ItemStack vidro1;
    public static ItemMeta vidro1meta;
    public static ItemStack escada;
    public static ItemMeta escadameta;
    public static ItemStack fogo;
    public static ItemMeta fogometa;
    public static ItemStack testi;
    public static ItemMeta testimeta;
    public static ItemStack achilles;
    public static ItemMeta achillesmeta;
    public static ItemStack phantom;
    public static ItemMeta phantommeta;
    public static ItemStack timelord;
    public static ItemMeta timelordmeta;
    public static ItemStack ff;
    public static ItemMeta ffmeta;
    public static ItemStack avatar;
    public static ItemMeta avatarmeta;
    public static ItemStack turtle;
    public static ItemMeta turtlemeta;
    public static ItemStack kits1;
    public static ItemMeta kits1meta;
    public static ItemStack head;
    public static ItemMeta headmeta;
    public static ItemStack barbarian;
    public static ItemMeta barbarianmeta;
    public static ItemStack specialist;
    public static ItemMeta specialistmeta;
    public static ItemStack ajnin;
    public static ItemMeta ajninmeta;
    public static ItemStack bomber;
    public static ItemMeta bombermeta;
    public static ItemStack strong;
    public static ItemMeta strongmeta;
    public static ItemStack sumo;
    public static ItemMeta sumometa;
    public static ItemStack lavaman;
    public static ItemMeta lavamanmeta;
    
    public static List<String> Lore(String string) {
        final String[] split = string.split("§7§o-");
        string = "";
        final ChatColor color = ChatColor.GOLD;
        final ArrayList newString = new ArrayList();
        for (int i = 0; i < split.length; ++i) {
            if (string.length() > 20 || string.endsWith(".")) {
                newString.add(color + string);
                if (string.endsWith(".")) {
                    newString.add("");
                }
                string = "";
            }
            string = String.valueOf(string) + ((string.length() == 0) ? "" : "§7§o-") + split[i];
        }
        newString.add(string);
        return (List<String>)newString;
    }
    
    @EventHandler
    public void PvP(final InventoryClickEvent e) {
        if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
            final Player p = (Player)e.getWhoClicked();
            final Inventory inv = e.getInventory();
            if (inv.getTitle().equalsIgnoreCase("§7Suas Classes")) {
                if (e.getCurrentItem().isSimilar(KitSelector2.vidro)) {
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.head)) {
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.testi)) {
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.achilles)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit achilles");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.timelord)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit timelord");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.ff)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit forcefield");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.ajnin)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit ajnin");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.specialist)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit specialist");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.avatar)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit avatar");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.phantom)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit phantom");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.barbarian)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit barbarian");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.turtle)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit turtle");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.kits1)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kits");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.bomber)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit bomber");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.strong)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit strong");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.sumo)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit sumo");
                }
                if (e.getCurrentItem().isSimilar(KitSelector2.lavaman)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit lavaman");
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem usar isso");
            return true;
        }
        final Player p = (Player)sender;
        final Inventory kit = Bukkit.createInventory((InventoryHolder)p, 54, "§7Suas Classes");
        KitSelector2.vidro = new ItemStack(Material.STAINED_GLASS_PANE);
        (KitSelector2.vidrometa = KitSelector2.vidro.getItemMeta()).setDisplayName("§7§o-");
        KitSelector2.vidro.setItemMeta(KitSelector2.vidrometa);
        KitSelector2.testi = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
        (KitSelector2.testimeta = KitSelector2.testi.getItemMeta()).setDisplayName("§7§o-");
        KitSelector2.testi.setItemMeta(KitSelector2.testimeta);
        KitSelector2.kits1 = new ItemStack(Material.CARPET, 1, (short)5);
        (KitSelector2.kits1meta = KitSelector2.kits1.getItemMeta()).setDisplayName("§c<-");
        KitSelector2.kits1.setItemMeta(KitSelector2.kits1meta);
        KitSelector2.vidro1 = new ItemStack(Material.STAINED_GLASS_PANE);
        (KitSelector2.vidro1meta = KitSelector2.vidro1.getItemMeta()).setDisplayName("§7§o-");
        KitSelector2.vidro1.setItemMeta(KitSelector2.vidro1meta);
        KitSelector2.head = new ItemStack(Material.SKULL_ITEM);
        (KitSelector2.headmeta = KitSelector2.head.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + p.getName());
        KitSelector2.head.setItemMeta(KitSelector2.headmeta);
        KitSelector2.escada = new ItemStack(Material.LADDER, 1);
        (KitSelector2.escadameta = KitSelector2.escada.getItemMeta()).setDisplayName("§7-");
        KitSelector2.escada.setItemMeta(KitSelector2.escadameta);
        KitSelector2.achilles = new ItemStack(Material.WOOD_SWORD, 1);
        (KitSelector2.achillesmeta = KitSelector2.achilles.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Achilles");
        KitSelector2.achilles.setItemMeta(KitSelector2.achillesmeta);
        KitSelector2.ajnin = new ItemStack(Material.COAL_BLOCK, 1);
        (KitSelector2.ajninmeta = KitSelector2.ajnin.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Ajnin");
        KitSelector2.ajnin.setItemMeta(KitSelector2.ajninmeta);
        KitSelector2.specialist = new ItemStack(Material.WOOD_SWORD, 1);
        (KitSelector2.specialistmeta = KitSelector2.specialist.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Specialist");
        KitSelector2.specialist.setItemMeta(KitSelector2.specialistmeta);
        KitSelector2.phantom = new ItemStack(Material.FEATHER, 1);
        (KitSelector2.phantommeta = KitSelector2.phantom.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Phantom");
        KitSelector2.phantom.setItemMeta(KitSelector2.phantommeta);
        KitSelector2.ff = new ItemStack(Material.NETHER_FENCE, 1);
        (KitSelector2.ffmeta = KitSelector2.ff.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Forcefield");
        KitSelector2.ff.setItemMeta(KitSelector2.ffmeta);
        KitSelector2.avatar = new ItemStack(Material.WOOL, 1);
        (KitSelector2.avatarmeta = KitSelector2.avatar.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Avatar");
        KitSelector2.avatar.setItemMeta(KitSelector2.avatarmeta);
        KitSelector2.barbarian = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        (KitSelector2.barbarianmeta = KitSelector2.barbarian.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Barbarian");
        KitSelector2.barbarian.setItemMeta(KitSelector2.barbarianmeta);
        KitSelector2.turtle = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        (KitSelector2.turtlemeta = KitSelector2.turtle.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Turtle");
        KitSelector2.turtle.setItemMeta(KitSelector2.turtlemeta);
        KitSelector2.timelord = new ItemStack(Material.WATCH, 1);
        (KitSelector2.timelordmeta = KitSelector2.timelord.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Timelord");
        KitSelector2.timelord.setItemMeta(KitSelector2.timelordmeta);
        KitSelector2.bomber = new ItemStack(Material.TNT, 1);
        (KitSelector2.bombermeta = KitSelector2.bomber.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Bomber");
        KitSelector2.bomber.setItemMeta(KitSelector2.bombermeta);
        KitSelector2.strong = new ItemStack(Material.WATCH, 1);
        (KitSelector2.strongmeta = KitSelector2.strong.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Strong");
        KitSelector2.strong.setItemMeta(KitSelector2.strongmeta);
        KitSelector2.sumo = new ItemStack(Material.APPLE, 1);
        (KitSelector2.sumometa = KitSelector2.sumo.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Sumo");
        KitSelector2.sumo.setItemMeta(KitSelector2.sumometa);
        KitSelector2.lavaman = new ItemStack(Material.LAVA_BUCKET, 1);
        (KitSelector2.lavamanmeta = KitSelector2.lavaman.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Lavaman");
        KitSelector2.lavaman.setItemMeta(KitSelector2.lavamanmeta);
        KitSelector2.fogo = new ItemStack(Material.AIR);
        KitSelector2.fogometa = KitSelector2.fogo.getItemMeta();
        KitSelector2.fogo.setItemMeta(KitSelector2.fogometa);
        for (int i = 0; i != 54; ++i) {
            kit.setItem(i, KitSelector2.fogo);
        }
        kit.setItem(0, KitSelector2.kits1);
        kit.setItem(1, KitSelector2.testi);
        kit.setItem(2, KitSelector2.testi);
        kit.setItem(3, KitSelector2.testi);
        kit.setItem(4, KitSelector2.testi);
        kit.setItem(5, KitSelector2.testi);
        kit.setItem(6, KitSelector2.testi);
        kit.setItem(7, KitSelector2.testi);
        kit.setItem(8, KitSelector2.testi);
        kit.setItem(45, KitSelector2.testi);
        kit.setItem(46, KitSelector2.testi);
        kit.setItem(47, KitSelector2.testi);
        kit.setItem(48, KitSelector2.testi);
        kit.setItem(49, KitSelector2.testi);
        kit.setItem(50, KitSelector2.testi);
        kit.setItem(51, KitSelector2.testi);
        kit.setItem(52, KitSelector2.testi);
        kit.setItem(53, KitSelector2.testi);
        if (p.hasPermission("kit.achilles")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.achilles });
        }
        if (p.hasPermission("kit.phantom")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.phantom });
        }
        if (p.hasPermission("kit.forcefield")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.ff });
        }
        if (p.hasPermission("kit.timelord")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.timelord });
        }
        if (p.hasPermission("kit.turtle")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.turtle });
        }
        if (p.hasPermission("kit.avatar")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.avatar });
        }
        if (p.hasPermission("kit.specialist")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.specialist });
        }
        if (p.hasPermission("kit.ajnin")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.ajnin });
        }
        if (p.hasPermission("kit.barbarian")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.barbarian });
        }
        if (p.hasPermission("kit.bomber")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.bomber });
        }
        if (p.hasPermission("kit.strong")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.strong });
        }
        if (p.hasPermission("kit.sumo")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.sumo });
        }
        if (p.hasPermission("kit.lavaman")) {
            kit.removeItem(new ItemStack[] { KitSelector2.vidro });
            kit.addItem(new ItemStack[] { KitSelector2.lavaman });
        }
        p.openInventory(kit);
        return false;
    }
}
