package me.RaidzDev.Utils;

import org.bukkit.entity.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.*;
import me.RaidzDev.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import java.util.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.command.*;

public class Selector_Caixa implements Listener, CommandExecutor
{
    private static HashMap<String, Long> cooldown;
    public static ArrayList<String> moneycaixaaladdin;
    public static ArrayList<String> moneycaixawaterbender;
    public static ArrayList<String> moneycaixafirebender;
    public static ArrayList<String> kitdiraioironman;
    public static ArrayList<String> gladiator;
    public static ArrayList<String> moneycaixalumberjack;
    public static ArrayList<String> moneycaixamerlin;
    public static ArrayList<String> moneycaixakangaroo;
    public static ArrayList<String> moneycaixagladiator;
    public static ArrayList<String> moneycaixagrappler;
    public static ArrayList<String> setandokit;
    public static ArrayList<String> moneycaixaglad;
    
    static {
        Selector_Caixa.cooldown = new HashMap<String, Long>();
        Selector_Caixa.moneycaixaaladdin = new ArrayList<String>();
        Selector_Caixa.moneycaixawaterbender = new ArrayList<String>();
        Selector_Caixa.moneycaixafirebender = new ArrayList<String>();
        Selector_Caixa.kitdiraioironman = new ArrayList<String>();
        Selector_Caixa.gladiator = new ArrayList<String>();
        Selector_Caixa.moneycaixalumberjack = new ArrayList<String>();
        Selector_Caixa.moneycaixamerlin = new ArrayList<String>();
        Selector_Caixa.moneycaixakangaroo = new ArrayList<String>();
        Selector_Caixa.moneycaixagladiator = new ArrayList<String>();
        Selector_Caixa.moneycaixagrappler = new ArrayList<String>();
        Selector_Caixa.setandokit = new ArrayList<String>();
        Selector_Caixa.moneycaixaglad = new ArrayList<String>();
    }
    
    public void playFirework(final Location location, final FireworkEffect effecta, final Player p) {
        final Firework firework = (Firework)location.getWorld().spawn(location, (Class)Firework.class);
        final FireworkMeta fMeta = firework.getFireworkMeta();
        fMeta.addEffect(effecta);
        firework.setFireworkMeta(fMeta);
    }
    
    @EventHandler
    public void aoClicarNoInv(final InventoryClickEvent e) {
        final Player jogador = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§7» " + Config.cor + "Informa\u00e7\u00e3o§7 «") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            final Player p = (Player)e.getWhoClicked();
            if (e.getInventory().getTitle().equalsIgnoreCase(String.valueOf(Config.cor) + "Caixa") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
                e.setCancelled(true);
            }
        }
    }
    
    public static void Inventario(final Player jogador) {
        final Inventory random = Bukkit.createInventory((InventoryHolder)jogador, 27, String.valueOf(Config.cor) + "Caixa");
        final ItemStack vidro = new ItemStack(Material.getMaterial(160));
        final ItemMeta zvidro = vidro.getItemMeta();
        zvidro.setDisplayName("§7§o-");
        vidro.setItemMeta(zvidro);
        final ItemStack gerando = new ItemStack(Material.CHEST);
        final ItemMeta zgerando = gerando.getItemMeta();
        zgerando.setDisplayName("§aGERANDO..");
        gerando.setItemMeta(zgerando);
        final ItemStack vidro2 = new ItemStack(Material.getMaterial(160));
        final ItemMeta zvidro2 = vidro2.getItemMeta();
        zvidro2.setDisplayName("§7§o-");
        vidro2.setItemMeta(zvidro2);
        final ItemStack v = new ItemStack(Material.getMaterial(160));
        final ItemMeta zv = vidro2.getItemMeta();
        zv.setDisplayName("§7§o-");
        v.setItemMeta(zv);
        final ItemStack n = new ItemStack(Material.getMaterial(160), 1, (short)15);
        final ItemMeta zn = n.getItemMeta();
        zn.setDisplayName("§7§o-");
        n.setItemMeta(zn);
        final ItemStack vidropreto = new ItemStack(Material.NETHER_STAR);
        vidropreto.setDurability((short)0);
        final ItemMeta vidropretoa = vidropreto.getItemMeta();
        vidropretoa.setDisplayName("§7§o-");
        vidropreto.setItemMeta(vidropretoa);
        final ItemStack espadademadeira = new ItemStack(Material.EXP_BOTTLE);
        final ItemMeta espadademadeiraa = espadademadeira.getItemMeta();
        espadademadeiraa.setDisplayName(String.valueOf(Config.cor) + "150");
        espadademadeira.setItemMeta(espadademadeiraa);
        final ItemStack sopa = new ItemStack(Material.EXP_BOTTLE);
        final ItemMeta sopaa = sopa.getItemMeta();
        sopaa.setDisplayName(String.valueOf(Config.cor) + "345");
        sopa.setItemMeta(sopaa);
        final ItemStack macadourada = new ItemStack(Material.EXP_BOTTLE);
        final ItemMeta macadouradaa = macadourada.getItemMeta();
        macadouradaa.setDisplayName(String.valueOf(Config.cor) + "50");
        macadourada.setItemMeta(macadouradaa);
        final ItemStack espadadepedra = new ItemStack(Material.EXP_BOTTLE);
        final ItemMeta espadadepedraa = espadadepedra.getItemMeta();
        espadadepedraa.setDisplayName(String.valueOf(Config.cor) + "400");
        espadadepedra.setItemMeta(espadadepedraa);
        final ItemStack xp = new ItemStack(Material.EXP_BOTTLE);
        final ItemMeta xpa = xp.getItemMeta();
        xpa.setDisplayName(String.valueOf(Config.cor) + "250");
        xp.setItemMeta(xpa);
        final ItemStack lumberjack = new ItemStack(Material.EXP_BOTTLE);
        final ItemMeta lumberjacka = lumberjack.getItemMeta();
        lumberjacka.setDisplayName(String.valueOf(Config.cor) + "600");
        lumberjack.setItemMeta(lumberjacka);
        final ItemStack enderperal = new ItemStack(Material.EXP_BOTTLE);
        final ItemMeta enderperala = enderperal.getItemMeta();
        enderperala.setDisplayName(String.valueOf(Config.cor) + "100");
        enderperal.setItemMeta(enderperala);
        final ItemStack grappler = new ItemStack(Material.EXP_BOTTLE);
        final ItemMeta grapplera = grappler.getItemMeta();
        grapplera.setDisplayName(String.valueOf(Config.cor) + "1000");
        grappler.setItemMeta(grapplera);
        final ItemStack glad = new ItemStack(Material.IRON_FENCE);
        final ItemMeta zglad = glad.getItemMeta();
        zglad.setDisplayName(String.valueOf(Config.cor) + "Gladiator");
        glad.setItemMeta(zglad);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(0, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 1L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(1, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 2L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(2, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 3L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(3, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 4L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(4, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 5L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(5, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 6L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(6, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 7L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(7, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 8L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(8, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 9L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(9, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 10L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(10, n);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 11L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(11, n);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 12L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(12, n);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 13L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 14L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(14, n);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 15L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(15, n);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 16L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(16, n);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 17L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(17, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 18L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(18, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 19L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(19, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 20L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(20, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 21L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(21, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 22L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(22, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 23L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(23, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 24L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(24, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 25L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(25, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 26L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(26, v);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 27L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 32L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 36L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 40L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 45L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 55L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 65L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 70L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 75L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 80L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 85L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 90L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 95L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 5.0f, 5.0f);
            }
        }, 100L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                random.setItem(13, gerando);
                jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            }
        }, 105L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                final Random r = new Random();
                final int gg = r.nextInt(8) + 1;
                if (gg == 1) {
                    jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                    random.setItem(13, espadademadeira);
                    Selector_Caixa.moneycaixafirebender.add(jogador.getName());
                    jogador.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea ganhou 150 de coins.");
                    Status.addMoney1(jogador, 150);
                    ScoreBoard.onScoreboard(jogador);
                }
                if (gg == 2) {
                    jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                    random.setItem(13, sopa);
                    Selector_Caixa.moneycaixaaladdin.add(jogador.getName());
                    jogador.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea ganhou 345 de coins.");
                    Status.addMoney1(jogador, 345);
                    ScoreBoard.onScoreboard(jogador);
                }
                if (gg == 3) {
                    jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                    random.setItem(13, macadourada);
                    Selector_Caixa.moneycaixawaterbender.add(jogador.getName());
                    jogador.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea ganhou 50 de coins.");
                    Status.addMoney1(jogador, 50);
                    ScoreBoard.onScoreboard(jogador);
                }
                if (gg == 4) {
                    jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                    random.setItem(13, xp);
                    Selector_Caixa.kitdiraioironman.add(jogador.getName());
                    jogador.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea ganhou 250 de coins.");
                    Status.addMoney1(jogador, 250);
                    ScoreBoard.onScoreboard(jogador);
                }
                if (gg == 5) {
                    jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                    random.setItem(13, espadadepedra);
                    Selector_Caixa.moneycaixagladiator.add(jogador.getName());
                    jogador.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea ganhou 400 de coins.");
                    Status.addMoney1(jogador, 400);
                    ScoreBoard.onScoreboard(jogador);
                }
                if (gg == 6) {
                    jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                    random.setItem(13, lumberjack);
                    Selector_Caixa.moneycaixalumberjack.add(jogador.getName());
                    jogador.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea ganhou 600 de coins.");
                    Status.addMoney1(jogador, 600);
                    ScoreBoard.onScoreboard(jogador);
                }
                if (gg == 7) {
                    jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                    random.setItem(13, enderperal);
                    Selector_Caixa.moneycaixakangaroo.add(jogador.getName());
                    jogador.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea ganhou 100 de coins.");
                    Status.addMoney1(jogador, 100);
                    ScoreBoard.onScoreboard(jogador);
                }
                if (gg == 8) {
                    jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                    random.setItem(13, grappler);
                    Selector_Caixa.moneycaixagrappler.add(jogador.getName());
                    jogador.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea ganhou 1000 de coins.");
                    Status.addMoney1(jogador, 1000);
                    ScoreBoard.onScoreboard(jogador);
                }
                if (gg == 9) {
                    jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                    random.setItem(13, glad);
                    Selector_Caixa.moneycaixaglad.add(jogador.getName());
                    jogador.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea ganhou o kit Gladiator.");
                    Main.instance.getServer().dispatchCommand((CommandSender)Main.instance.getServer().getConsoleSender(), "pex user " + jogador.getName() + " add kit.gladiator");
                }
            }
        }, 110L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                jogador.closeInventory();
            }
        }, 130L);
        jogador.openInventory(random);
    }
    
    @EventHandler
    public void asadasS(final InventoryClickEvent e) {
        if (e.getInventory().getTitle().equalsIgnoreCase(String.valueOf(Config.cor) + "Caixa") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void aoInteragir(final PlayerInteractEvent evento) {
        final Player jogador = evento.getPlayer();
        if (jogador.getItemInHand().getType() == Material.STORAGE_MINECART && (evento.getAction() == Action.RIGHT_CLICK_AIR || evento.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (Selector_Caixa.setandokit.contains(jogador.getName())) {
                jogador.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea ja pegou a caixa de hoje.");
                return;
            }
            evento.setCancelled(true);
            Inventario(jogador);
            Selector_Caixa.setandokit.add(jogador.getName());
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player jogador = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("caixa")) {
            if (Selector_Caixa.setandokit.contains(jogador.getName())) {
                jogador.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea ja pegou a caixa de hoje.");
                return true;
            }
            Inventario(jogador);
            Selector_Caixa.setandokit.add(jogador.getName());
        }
        return false;
    }
    
    public static void guiKits(final Player jogador) {
    }
}
