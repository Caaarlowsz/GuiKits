package me.RaidzDev.Utils;

import org.bukkit.block.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.scheduler.*;
import me.RaidzDev.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class FeastHandler implements CommandExecutor
{
    public static int time;
    public static int chests;
    
    static {
        FeastHandler.time = 300;
        FeastHandler.chests = 0;
    }
    
    public static void fillAllChests(final String s) {
        Chunk[] arrayOfChunk;
        for (int j = (arrayOfChunk = Main.instance.getServer().getWorld(s).getLoadedChunks()).length, i = 0; i < j; ++i) {
            final Chunk chunk = arrayOfChunk[i];
            BlockState[] tileEntities;
            for (int length = (tileEntities = chunk.getTileEntities()).length, k = 0; k < length; ++k) {
                final BlockState entities = tileEntities[k];
                if (entities instanceof Chest) {
                    final Inventory inv = ((Chest)entities).getInventory();
                    fillChests(inv);
                    ++FeastHandler.chests;
                }
            }
        }
    }
    
    public static void fillChests(final Inventory inv) {
        inv.clear();
        final Random itemnum = new Random();
        for (int items = 3 + itemnum.nextInt(8), i = 1; i < items + 1; ++i) {
            final Random slotnum = new Random();
            final Random itemrand = new Random();
            final int item = 1 + itemrand.nextInt(30);
            final int slot = slotnum.nextInt(inv.getSize());
            final Random stack = new Random();
            final int amount = stack.nextInt(7);
            final ItemStack sword = new ItemStack(Material.WOOD_SWORD);
            final ItemMeta smeta = sword.getItemMeta();
            smeta.setDisplayName("§oEspada");
            sword.setItemMeta(smeta);
            sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
            final ItemStack tracker = new ItemStack(Material.STONE_SWORD);
            final ItemMeta trackerm = tracker.getItemMeta();
            trackerm.setDisplayName("§oEspada");
            tracker.setItemMeta(trackerm);
            final ItemStack ffsword = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1, (short)0);
            final ItemMeta fmfeta = ffsword.getItemMeta();
            fmfeta.setDisplayName("§oPeitoral");
            ffsword.setItemMeta(fmfeta);
            if (item == 1) {
                inv.setItem(slot, new ItemStack(Material.ENDER_PEARL, amount));
            }
            else if (item == 1) {
                inv.setItem(slot, new ItemStack(Material.MUSHROOM_SOUP, amount));
            }
            else if (item == 5) {
                inv.setItem(slot, new ItemStack(Material.MUSHROOM_SOUP, amount));
            }
            else if (item == 6) {
                inv.setItem(slot, ffsword);
            }
            else if (item == 4) {
                inv.setItem(slot, new ItemStack(Material.BROWN_MUSHROOM, amount));
            }
            else if (item == 32) {
                inv.setItem(slot, ffsword);
            }
            else if (item == 1) {
                inv.setItem(slot, ffsword);
            }
            else if (item == 2) {
                inv.setItem(slot, new ItemStack(Material.MUSHROOM_SOUP, amount));
            }
            else if (item == 11) {
                inv.setItem(slot, new ItemStack(Material.POTION, 1, (short)33));
            }
            else if (item == 12) {
                inv.setItem(slot, new ItemStack(Material.POTION, 1, (short)37));
            }
            else if (item == 16) {
                inv.setItem(slot, new ItemStack(Material.POTION, 1, (short)34));
            }
            else if (item == 17) {
                inv.setItem(slot, new ItemStack(Material.POTION, 1, (short)9));
            }
            else if (item == 18) {
                inv.setItem(slot, tracker);
            }
            else if (item == 19) {
                inv.setItem(slot, new ItemStack(Material.POTION, amount, (short)45));
            }
            else if (item == 20) {
                inv.setItem(slot, new ItemStack(Material.MUSHROOM_SOUP, amount));
            }
            else if (item == 23) {
                inv.setItem(slot, tracker);
            }
            else if (item == 24) {
                inv.setItem(slot, new ItemStack(Material.ARROW, amount));
            }
            else if (item == 25) {
                inv.setItem(slot, new ItemStack(Material.BOW, 1));
            }
            else if (item == 26) {
                inv.setItem(slot, new ItemStack(Material.MUSHROOM_SOUP, amount));
            }
            else if (item == 27) {
                inv.setItem(slot, new ItemStack(Material.EXP_BOTTLE, amount));
            }
            else if (item == 28) {
                inv.setItem(slot, new ItemStack(Material.MUSHROOM_SOUP, amount));
            }
        }
    }
    
    public static void start(final String s) {
        new BukkitRunnable() {
            public void run() {
                --FeastHandler.time;
                if (FeastHandler.time == 240) {
                    Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "Os Itens Do Feast Aparecer\u00e3o em 4 Minutos.");
                }
                else if (FeastHandler.time == 180) {
                    Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "Os Itens Do Feast Aparecer\u00e3o em 3 Minutos.");
                }
                else if (FeastHandler.time == 120) {
                    Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "Os Itens Do Feast Aparecer\u00e3o em 2 Minutos.");
                }
                else if (FeastHandler.time == 60) {
                    Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "Os Itens Do Feast Aparecer\u00e3o em 1 Minuto.");
                }
                else if (FeastHandler.time == 30) {
                    Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "Os Itens Do Feast Aparecer\u00e3o em 15 Segundos.");
                }
                else if (FeastHandler.time == 10) {
                    Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "Os Itens Do Feast Aparecer\u00e3o em 10 Segundos.");
                }
                else if (FeastHandler.time <= 5 && FeastHandler.time > 1) {
                    FeastHandler.feastBroadcast(FeastHandler.time);
                }
                else if (FeastHandler.time == 1) {
                    Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "Os Itens Do Feast Aparecer\u00e3o em 1 Segundo.");
                }
                else if (FeastHandler.time == 0) {
                    Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "Os Itens For\u00e3o Spawnados.");
                    FeastHandler.fillAllChests(s);
                    Bukkit.getPluginManager().callEvent((Event)new FeastRefillEvent());
                    FeastHandler.time = 300;
                }
            }
        }.runTaskTimerAsynchronously(Main.plugin, 0L, 20L);
    }
    
    public static void feastBroadcast(final int i) {
        Bukkit.broadcastMessage(String.valueOf(Config.prefix) + "Os Itens Do Feast Aparecer\u00e3o em " + i + " Segundos.");
    }
    
    public boolean onCommand(final CommandSender arg0, final Command arg1, final String arg2, final String[] arg3) {
        final Player p = (Player)arg0;
        if (p.hasPermission("guikits.feast")) {
            FeastHandler.time = 6;
            p.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea For\u00e7ou os Itens do Feast");
        }
        else {
            p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o tem permiss\u00e3o !");
        }
        return false;
    }
}
