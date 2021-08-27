package me.RaidzDev.Eventos;

import org.bukkit.inventory.meta.*;
import java.util.*;
import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import me.RaidzDev.Comandos.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import me.RaidzDev.*;

public class KitSelector implements Listener, CommandExecutor
{
    public static ItemStack vidro;
    public static ItemMeta vidrometa;
    public static ItemStack vidro1;
    public static ItemMeta vidro1meta;
    public static ItemStack escada;
    public static ItemMeta escadameta;
    public static ItemStack endermage;
    public static ItemMeta endermagemeta;
    public static ItemStack ryu;
    public static ItemMeta ryumeta;
    public static ItemStack head;
    public static ItemMeta headmeta;
    public static ItemStack pvp;
    public static ItemMeta pvpmeta;
    public static ItemStack magma;
    public static ItemMeta magmameta;
    public static ItemStack switcher;
    public static ItemMeta switchermeta;
    public static ItemStack thor;
    public static ItemMeta thormeta;
    public static ItemStack crack;
    public static ItemMeta crackmeta;
    public static ItemStack berserker;
    public static ItemMeta berserkermeta;
    public static ItemStack critical;
    public static ItemMeta criticalmeta;
    public static ItemStack stomper;
    public static ItemMeta stompermeta;
    public static ItemStack viking;
    public static ItemMeta vikingmeta;
    public static ItemStack reaper;
    public static ItemMeta reapermeta;
    public static ItemStack Demoman;
    public static ItemMeta Demomanmeta;
    public static ItemStack sonic;
    public static ItemMeta sonicmeta;
    public static ItemStack fisherman;
    public static ItemMeta fishermanmeta;
    public static ItemStack darkmage;
    public static ItemMeta darkmagemeta;
    public static ItemStack camel;
    public static ItemMeta camelmeta;
    public static ItemStack poseidon;
    public static ItemMeta poseidonmeta;
    public static ItemStack archer;
    public static ItemMeta archermeta;
    public static ItemStack viper;
    public static ItemMeta vipermeta;
    public static ItemStack snail;
    public static ItemMeta snailmeta;
    public static ItemStack gladiator;
    public static ItemMeta gladiatormeta;
    public static ItemStack kangaroo;
    public static ItemMeta kangaroometa;
    public static ItemStack c4;
    public static ItemMeta c4meta;
    public static ItemStack hulk;
    public static ItemMeta hulkmeta;
    public static ItemStack anchor;
    public static ItemMeta anchormeta;
    public static ItemStack fogo;
    public static ItemMeta fogometa;
    public static ItemStack flash;
    public static ItemMeta flashmeta;
    public static ItemStack backpacker;
    public static ItemMeta backpackermeta;
    public static ItemStack kits2;
    public static ItemMeta kits2meta;
    public static ItemStack grappler;
    public static ItemMeta grapplermeta;
    public static ItemStack deshfire;
    public static ItemMeta deshfiremeta;
    public static ItemStack ninja;
    public static ItemMeta ninjameta;
    public static ItemStack negresco;
    public static ItemMeta negrescometa;
    public static ItemStack testi;
    public static ItemMeta testimeta;
    public static ItemStack firer;
    public static ItemMeta firermeta;
    public static ItemStack blink;
    public static ItemMeta blinkmeta;
    public static ItemStack swords;
    public static ItemMeta swordsmeta;
    public static ItemStack thresh;
    public static ItemMeta threshmeta;
    
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
            string = String.valueOf(string) + ((string.length() == 0) ? "" : "§7§o- Slots") + split[i];
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
                if (e.getCurrentItem().isSimilar(KitSelector.vidro)) {
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.testi)) {
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.swords)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit swords");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.head)) {
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.thresh)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit thresh");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.blink)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit blink");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.magma)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit magma");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.c4)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit c4");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.pvp)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit pvp");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.gladiator)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit gladiator");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.hulk)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit hulk");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.thor)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit thor");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.firer)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit firer");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.flash)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit flash");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.anchor)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit anchor");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.ryu)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit ryu");
                }
                if (e.getCurrentItem().isSimilar(KitSelector.kits2)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kits2");
                }
                if (e.getCurrentItem().isSimilar(KitSelector.endermage)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit endermage");
                }
                if (e.getCurrentItem().isSimilar(KitSelector.stomper)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit stomper");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.kangaroo)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit kangaroo");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.fisherman)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit fisherman");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.sonic)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit sonic");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.Demoman)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit demoman");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.poseidon)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit poseidon");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.viking)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit viking");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.negresco)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit negresco");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.reaper)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit reaper");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.switcher)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit switcher");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.crack)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit crack");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.camel)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit camel");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.viper)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit viper");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.snail)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit snail");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.grappler)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit grappler");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.darkmage)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit darkmage");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.deshfire)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit deshfire");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.ninja)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit ninja");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.backpacker)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit backpacker");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.archer)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit archer");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.berserker)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit berserker");
                    SetArena.TeleportArenaRandom(p);
                }
                if (e.getCurrentItem().isSimilar(KitSelector.critical)) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.chat("/kit critical");
                    SetArena.TeleportArenaRandom(p);
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
        KitSelector.vidro = new ItemStack(Material.STAINED_GLASS_PANE);
        (KitSelector.vidrometa = KitSelector.vidro.getItemMeta()).setDisplayName("§7§o-");
        KitSelector.vidro.setItemMeta(KitSelector.vidrometa);
        KitSelector.testi = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
        (KitSelector.testimeta = KitSelector.testi.getItemMeta()).setDisplayName("§7§o-");
        KitSelector.testi.setItemMeta(KitSelector.testimeta);
        KitSelector.vidro1 = new ItemStack(Material.STAINED_GLASS_PANE);
        (KitSelector.vidro1meta = KitSelector.vidro1.getItemMeta()).setDisplayName("§7§o-");
        KitSelector.vidro1.setItemMeta(KitSelector.vidro1meta);
        KitSelector.ryu = new ItemStack(Material.BEACON);
        (KitSelector.ryumeta = KitSelector.ryu.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Ryu");
        KitSelector.ryu.setItemMeta(KitSelector.ryumeta);
        KitSelector.ninja = new ItemStack(Material.COMPASS, 1);
        (KitSelector.ninjameta = KitSelector.ninja.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Ninja");
        KitSelector.ninja.setItemMeta(KitSelector.ninjameta);
        KitSelector.escada = new ItemStack(Material.LADDER, 1);
        (KitSelector.escadameta = KitSelector.escada.getItemMeta()).setDisplayName("§7-");
        KitSelector.escada.setItemMeta(KitSelector.escadameta);
        KitSelector.sonic = new ItemStack(Material.LAPIS_BLOCK);
        (KitSelector.sonicmeta = KitSelector.sonic.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Sonic");
        KitSelector.sonic.setItemMeta(KitSelector.sonicmeta);
        KitSelector.blink = new ItemStack(Material.GLOWSTONE_DUST);
        (KitSelector.blinkmeta = KitSelector.blink.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Blink");
        KitSelector.blink.setItemMeta(KitSelector.blinkmeta);
        KitSelector.stomper = new ItemStack(Material.LEATHER_BOOTS, 1);
        (KitSelector.stompermeta = KitSelector.stomper.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Stomper");
        KitSelector.stomper.setItemMeta(KitSelector.stompermeta);
        KitSelector.c4 = new ItemStack(Material.WOOD_BUTTON, 1);
        (KitSelector.c4meta = KitSelector.c4.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "C4");
        KitSelector.c4.setItemMeta(KitSelector.c4meta);
        KitSelector.firer = new ItemStack(Material.BLAZE_POWDER, 1);
        (KitSelector.firermeta = KitSelector.firer.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Firer");
        KitSelector.firer.setItemMeta(KitSelector.firermeta);
        KitSelector.gladiator = new ItemStack(Material.IRON_FENCE, 1);
        (KitSelector.gladiatormeta = KitSelector.gladiator.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Gladiator");
        KitSelector.gladiator.setItemMeta(KitSelector.gladiatormeta);
        KitSelector.pvp = new ItemStack(Material.STONE_SWORD, 1);
        (KitSelector.pvpmeta = KitSelector.pvp.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "PvP");
        KitSelector.pvp.setItemMeta(KitSelector.pvpmeta);
        KitSelector.switcher = new ItemStack(Material.SNOW_BALL);
        (KitSelector.switchermeta = KitSelector.switcher.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Switcher");
        KitSelector.switcher.setItemMeta(KitSelector.switchermeta);
        KitSelector.crack = new ItemStack(Material.GRASS, 1);
        (KitSelector.crackmeta = KitSelector.crack.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Crack");
        KitSelector.crack.setItemMeta(KitSelector.crackmeta);
        KitSelector.fisherman = new ItemStack(Material.FISHING_ROD, 1);
        (KitSelector.fishermanmeta = KitSelector.fisherman.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Fisherman");
        KitSelector.fisherman.setItemMeta(KitSelector.fishermanmeta);
        KitSelector.magma = new ItemStack(Material.BLAZE_ROD, 1);
        (KitSelector.magmameta = KitSelector.magma.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Magma");
        KitSelector.magma.setItemMeta(KitSelector.magmameta);
        KitSelector.swords = new ItemStack(Material.IRON_SWORD, 1);
        (KitSelector.swordsmeta = KitSelector.swords.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Swords");
        KitSelector.swords.setItemMeta(KitSelector.swordsmeta);
        KitSelector.kangaroo = new ItemStack(Material.FIREWORK, 1);
        (KitSelector.kangaroometa = KitSelector.kangaroo.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Kangaroo");
        KitSelector.kangaroo.setItemMeta(KitSelector.kangaroometa);
        KitSelector.hulk = new ItemStack(Material.LEATHER, 1);
        (KitSelector.hulkmeta = KitSelector.hulk.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Hulk");
        KitSelector.hulk.setItemMeta(KitSelector.hulkmeta);
        KitSelector.grappler = new ItemStack(Material.LEASH);
        (KitSelector.grapplermeta = KitSelector.grappler.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Grappler");
        KitSelector.grappler.setItemMeta(KitSelector.grapplermeta);
        KitSelector.head = new ItemStack(Material.SKULL_ITEM);
        (KitSelector.headmeta = KitSelector.head.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + p.getName());
        KitSelector.head.setItemMeta(KitSelector.headmeta);
        KitSelector.endermage = new ItemStack(Material.PORTAL);
        (KitSelector.endermagemeta = KitSelector.endermage.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Endermage");
        KitSelector.endermage.setItemMeta(KitSelector.endermagemeta);
        KitSelector.anchor = new ItemStack(Material.ANVIL);
        (KitSelector.anchormeta = KitSelector.anchor.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Anchor");
        KitSelector.anchor.setItemMeta(KitSelector.anchormeta);
        KitSelector.backpacker = new ItemStack(Material.NETHER_STAR, 1);
        (KitSelector.backpackermeta = KitSelector.backpacker.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Backpacker");
        KitSelector.backpacker.setItemMeta(KitSelector.backpackermeta);
        KitSelector.kits2 = new ItemStack(Material.CARPET, 1, (short)5);
        (KitSelector.kits2meta = KitSelector.kits2.getItemMeta()).setDisplayName("§a->");
        KitSelector.kits2.setItemMeta(KitSelector.kits2meta);
        KitSelector.thor = new ItemStack(Material.GOLD_AXE);
        (KitSelector.thormeta = KitSelector.thor.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Thor");
        KitSelector.thor.setItemMeta(KitSelector.thormeta);
        KitSelector.deshfire = new ItemStack(Material.REDSTONE_BLOCK);
        (KitSelector.deshfiremeta = KitSelector.deshfire.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Deshfire");
        KitSelector.deshfire.setItemMeta(KitSelector.deshfiremeta);
        KitSelector.viper = new ItemStack(Material.SPIDER_EYE, 1);
        (KitSelector.vipermeta = KitSelector.viper.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Viper");
        KitSelector.viper.setItemMeta(KitSelector.vipermeta);
        KitSelector.snail = new ItemStack(Material.WEB, 1);
        (KitSelector.snailmeta = KitSelector.snail.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Snail");
        KitSelector.snail.setItemMeta(KitSelector.snailmeta);
        KitSelector.negresco = new ItemStack(Material.COAL_BLOCK);
        (KitSelector.negrescometa = KitSelector.negresco.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Negresco");
        KitSelector.negresco.setItemMeta(KitSelector.negrescometa);
        KitSelector.poseidon = new ItemStack(Material.WATER_BUCKET);
        (KitSelector.poseidonmeta = KitSelector.poseidon.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Poseidon");
        KitSelector.poseidon.setItemMeta(KitSelector.poseidonmeta);
        KitSelector.viking = new ItemStack(Material.STONE_AXE, 1);
        (KitSelector.vikingmeta = KitSelector.viking.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Viking");
        KitSelector.viking.setItemMeta(KitSelector.vikingmeta);
        KitSelector.reaper = new ItemStack(Material.WOOD_HOE);
        (KitSelector.reapermeta = KitSelector.reaper.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Reaper");
        KitSelector.reaper.setItemMeta(KitSelector.reapermeta);
        KitSelector.camel = new ItemStack(Material.SAND);
        (KitSelector.camelmeta = KitSelector.camel.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Camel");
        KitSelector.camel.setItemMeta(KitSelector.camelmeta);
        KitSelector.archer = new ItemStack(Material.BOW, 1);
        (KitSelector.archermeta = KitSelector.archer.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Archer");
        KitSelector.archer.setItemMeta(KitSelector.archermeta);
        KitSelector.Demoman = new ItemStack(Material.TNT);
        (KitSelector.Demomanmeta = KitSelector.Demoman.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Demoman");
        KitSelector.Demoman.setItemMeta(KitSelector.Demomanmeta);
        KitSelector.thresh = new ItemStack(Material.BLAZE_ROD);
        (KitSelector.threshmeta = KitSelector.thresh.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Thresh");
        KitSelector.thresh.setItemMeta(KitSelector.threshmeta);
        KitSelector.darkmage = new ItemStack(Material.ENDER_PORTAL_FRAME);
        (KitSelector.darkmagemeta = KitSelector.darkmage.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "DarkMage");
        KitSelector.darkmage.setItemMeta(KitSelector.darkmagemeta);
        KitSelector.berserker = new ItemStack(Material.WOOL, 1, (short)15);
        (KitSelector.berserkermeta = KitSelector.berserker.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Berserker");
        KitSelector.berserker.setItemMeta(KitSelector.berserkermeta);
        KitSelector.flash = new ItemStack(Material.REDSTONE_TORCH_ON);
        (KitSelector.flashmeta = KitSelector.flash.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Flash");
        KitSelector.flash.setItemMeta(KitSelector.flashmeta);
        KitSelector.critical = new ItemStack(Material.GOLDEN_APPLE);
        (KitSelector.criticalmeta = KitSelector.critical.getItemMeta()).setDisplayName(String.valueOf(Config.cor) + "Critical");
        KitSelector.critical.setItemMeta(KitSelector.criticalmeta);
        KitSelector.fogo = new ItemStack(Material.AIR);
        KitSelector.fogometa = KitSelector.fogo.getItemMeta();
        KitSelector.fogo.setItemMeta(KitSelector.fogometa);
        for (int i = 0; i != 54; ++i) {
            kit.setItem(i, KitSelector.fogo);
        }
        kit.setItem(0, KitSelector.testi);
        kit.setItem(1, KitSelector.testi);
        kit.setItem(2, KitSelector.testi);
        kit.setItem(3, KitSelector.testi);
        kit.setItem(4, KitSelector.testi);
        kit.setItem(5, KitSelector.testi);
        kit.setItem(6, KitSelector.testi);
        kit.setItem(7, KitSelector.testi);
        kit.setItem(8, KitSelector.kits2);
        kit.setItem(45, KitSelector.testi);
        kit.setItem(46, KitSelector.testi);
        kit.setItem(47, KitSelector.testi);
        kit.setItem(48, KitSelector.testi);
        kit.setItem(49, KitSelector.testi);
        kit.setItem(50, KitSelector.testi);
        kit.setItem(51, KitSelector.testi);
        kit.setItem(52, KitSelector.testi);
        kit.setItem(53, KitSelector.testi);
        if (p.hasPermission("kit.pvp")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.pvp });
        }
        if (p.hasPermission("kit.kangaroo")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.kangaroo });
        }
        if (p.hasPermission("kit.critical")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.critical });
        }
        if (p.hasPermission("kit.fisherman")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.fisherman });
        }
        if (p.hasPermission("kit.sonic")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.sonic });
        }
        if (p.hasPermission("kit.berserker")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.berserker });
        }
        if (p.hasPermission("kit.anchor")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.anchor });
        }
        if (p.hasPermission("kit.grappler")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.grappler });
        }
        if (p.hasPermission("kit.deshfire")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.deshfire });
        }
        if (p.hasPermission("kit.camel")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.camel });
        }
        if (p.hasPermission("kit.magma")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.magma });
        }
        if (p.hasPermission("kit.reaper")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.reaper });
        }
        if (p.hasPermission("kit.viper")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.viper });
        }
        if (p.hasPermission("kit.viking")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.viking });
        }
        if (p.hasPermission("kit.poseidon")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.poseidon });
        }
        if (p.hasPermission("kit.snail")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.snail });
        }
        if (p.hasPermission("kit.negresco")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.negresco });
        }
        if (p.hasPermission("kit.ninja")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.ninja });
        }
        if (p.hasPermission("kit.backpacker")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.backpacker });
        }
        if (p.hasPermission("kit.archer")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.archer });
        }
        if (p.hasPermission("kit.demoman")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.Demoman });
        }
        if (p.hasPermission("kit.darkmage")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.darkmage });
        }
        if (p.hasPermission("kit.crack")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.crack });
        }
        if (p.hasPermission("kit.stomper")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.stomper });
        }
        if (p.hasPermission("kit.swords")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.swords });
        }
        if (p.hasPermission("kit.endermage")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.endermage });
        }
        if (p.hasPermission("kit.thor")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.thor });
        }
        if (p.hasPermission("kit.thresh")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.thresh });
        }
        if (p.hasPermission("kit.switcher")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.switcher });
        }
        if (p.hasPermission("kit.ryu")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.ryu });
        }
        if (p.hasPermission("kit.flash")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.flash });
        }
        if (p.hasPermission("kit.firer")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.firer });
        }
        if (p.hasPermission("kit.gladiator")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.gladiator });
        }
        if (p.hasPermission("kit.hulk")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.hulk });
        }
        if (p.hasPermission("kit.blink")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.blink });
        }
        if (p.hasPermission("kit.c4")) {
            kit.removeItem(new ItemStack[] { KitSelector.vidro });
            kit.addItem(new ItemStack[] { KitSelector.c4 });
        }
        p.openInventory(kit);
        return false;
    }
}
