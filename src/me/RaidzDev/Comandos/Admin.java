package me.RaidzDev.Comandos;

import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.entity.*;
import me.RaidzDev.*;
import org.bukkit.plugin.*;
import org.bukkit.metadata.*;
import org.bukkit.scheduler.*;
import org.bukkit.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.inventory.meta.*;

public class Admin implements Listener, CommandExecutor
{
    public static ArrayList<String> admin;
    public static HashMap<String, ItemStack[]> salvarinv;
    
    static {
        Admin.admin = new ArrayList<String>();
        Admin.salvarinv = new HashMap<String, ItemStack[]>();
    }
    
    @EventHandler
    public void abririnv(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.AIR && Admin.admin.contains(p.getName()) && p.hasPermission("guikits.admin")) {
            final Player t = (Player)e.getRightClicked();
            p.openInventory((Inventory)t.getInventory());
        }
    }
    
    @EventHandler
    public void crash1s(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        final Player rr = (Player)e.getRightClicked();
        if (p.getItemInHand().getType().equals((Object)Material.IRON_INGOT) && Admin.admin.contains(p)) {
            final int x = rr.getLocation().getBlockX() + 2;
            final int y = rr.getLocation().getBlockY();
            final int z = rr.getLocation().getBlockZ() + 2;
            final Location loc = new Location(rr.getWorld(), (double)x, (double)y, (double)z);
            final Bat morcego1 = (Bat)p.getWorld().spawnEntity(loc, EntityType.BAT);
            morcego1.setMetadata("Morcego", (MetadataValue)new FixedMetadataValue((Plugin)Main.getInstance(), (Object)true));
            morcego1.setCustomName("§aMorcego");
            morcego1.setCustomNameVisible(true);
            morcego1.setHealth(2.5);
            new BukkitRunnable() {
                public void run() {
                    if (!morcego1.isDead()) {
                        morcego1.remove();
                    }
                    morcego1.remove();
                }
            }.runTaskLater((Plugin)Main.getInstance(), 20L);
        }
        else if (p.getItemInHand().getType() == Material.FEATHER && Admin.admin.contains(p)) {
            final Vector vector = rr.getLocation().getDirection();
            vector.multiply(0.0f);
            vector.setY(2.0f);
            rr.setVelocity(vector);
        }
    }
    
    @EventHandler
    public void aoInteragir(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Admin.admin.contains(p.getName()) && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)) {
            if (p.getItemInHand().getType() == Material.SLIME_BALL) {
                p.chat("/admin");
            }
            if (e.getMaterial() == Material.MAGMA_CREAM && Admin.admin.contains(p.getName()) && p.hasPermission("guikits.admin")) {
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                    final Player s = onlinePlayers[i];
                    s.showPlayer(p);
                    p.setGameMode(GameMode.ADVENTURE);
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Player[] onlinePlayers;
                        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                            final Player s = onlinePlayers[i];
                            if (p.hasPermission("guikits.admin")) {
                                s.hidePlayer(p);
                                p.setGameMode(GameMode.CREATIVE);
                            }
                        }
                    }
                }, 20L);
            }
        }
    }
    
    @EventHandler
    public void autosoup(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.STICK && Admin.admin.contains(e.getPlayer().getName())) {
            final Player t = (Player)e.getRightClicked();
            e.getPlayer().chat("/autosoup " + t.getName());
        }
    }
    
    @EventHandler
    public void arena(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.IRON_FENCE && Admin.admin.contains(e.getPlayer().getName())) {
            final Player t = (Player)e.getRightClicked();
            e.getPlayer().chat("/arena " + t.getName());
        }
    }
    
    @EventHandler
    public void ff(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.IRON_INGOT && Admin.admin.contains(e.getPlayer().getName())) {
            final Player t = (Player)e.getRightClicked();
            e.getPlayer().chat("/f " + t.getName());
        }
    }
    
    @EventHandler
    public void nofall(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.FEATHER && Admin.admin.contains(e.getPlayer().getName())) {
            final Player t = (Player)e.getRightClicked();
            e.getPlayer().chat("/nofall " + t.getName());
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§eVoc\u00ea precisa estar online para dar o comando!");
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("admin")) {
            if (!p.hasPermission("guikits.admin")) {
                return true;
            }
            if (Admin.admin.contains(p.getName())) {
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                    final Player all = onlinePlayers[i];
                    all.showPlayer(p);
                    if (all.hasPermission("guikits.admin")) {
                        all.sendMessage("§c" + p.getName() + " §7Voc\u00ea saiu do modo admin.");
                    }
                    else {
                        all.sendMessage(" ");
                    }
                }
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage("§c" + p.getName() + " §7saiu do modo admin.");
                Admin.admin.remove(p.getName());
                p.getInventory().setContents((ItemStack[])Admin.salvarinv.get(p.getName()));
                p.updateInventory();
            }
            else {
                Admin.admin.add(p.getName());
                Player[] onlinePlayers2;
                for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
                    final Player all = onlinePlayers2[j];
                    all.hidePlayer(p);
                    if (all.hasPermission("guikits.admin")) {
                        all.sendMessage("§c" + p.getName() + " §7 entrou no modo admin!");
                    }
                    else {
                        all.sendMessage(" ");
                    }
                }
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage("§c §7Voc\u00ea entrou no modo admin!");
                Admin.salvarinv.put(p.getName(), p.getInventory().getContents());
                p.getInventory().clear();
                final ItemStack sair = new ItemStack(Material.SLIME_BALL);
                final ItemMeta zsair = sair.getItemMeta();
                zsair.setDisplayName("§eSair do Admin");
                sair.setItemMeta(zsair);
                final ItemStack ff = new ItemStack(Material.IRON_INGOT);
                final ItemMeta zff = ff.getItemMeta();
                zff.setDisplayName("§eTeste de Forcefield");
                ff.setItemMeta(zff);
                final ItemStack nofall = new ItemStack(Material.FEATHER);
                final ItemMeta znofall = nofall.getItemMeta();
                znofall.setDisplayName("§eTeste de Nofall");
                nofall.setItemMeta(znofall);
                final ItemStack Arena = new ItemStack(Material.IRON_FENCE);
                final ItemMeta zArena = Arena.getItemMeta();
                zArena.setDisplayName("§ePuxar Arena");
                Arena.setItemMeta(zArena);
                final ItemStack auto = new ItemStack(Material.STICK);
                final ItemMeta zauto = auto.getItemMeta();
                zauto.setDisplayName("§eTestar AutoSoup");
                auto.setItemMeta(zauto);
                final ItemStack rapido = new ItemStack(Material.MAGMA_CREAM);
                final ItemMeta zrapido = rapido.getItemMeta();
                zrapido.setDisplayName("§eSair e voltar rapidamente");
                rapido.setItemMeta(zrapido);
                p.getInventory().addItem(new ItemStack[] { rapido });
                p.getInventory().addItem(new ItemStack[] { auto });
                p.getInventory().addItem(new ItemStack[] { Arena });
                p.getInventory().addItem(new ItemStack[] { sair });
                p.getInventory().addItem(new ItemStack[] { ff });
                p.getInventory().addItem(new ItemStack[] { nofall });
            }
        }
        return true;
    }
}
