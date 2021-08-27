package me.RaidzDev.Eventos;

import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import me.RaidzDev.Comandos.*;
import org.bukkit.inventory.*;
import org.bukkit.potion.*;
import me.RaidzDev.Habilidades.*;
import me.RaidzDev.Utils.*;
import org.bukkit.*;
import me.RaidzDev.*;
import org.bukkit.event.entity.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import net.minecraft.server.v1_7_R4.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;

public class Join implements Listener
{
    @EventHandler
    public void ClicasrInventario(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (KitAPI.getkit(p) == "Sem Classe") {
            if (p.getGameMode() == GameMode.ADVENTURE || p.getGameMode() == GameMode.SURVIVAL) {
                e.setCancelled(true);
            }
            else if (p.getGameMode() == GameMode.CREATIVE) {
                e.setCancelled(false);
            }
            else {
                e.setCancelled(false);
            }
        }
    }
    
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        final Player jogador = e.getPlayer();
        Player[] arrayOfPlayer;
        for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
            final Player s = arrayOfPlayer[i];
            if (jogador.hasPermission("guikits.admin") && Admin.admin.contains(s.getName())) {
                jogador.hidePlayer(s);
            }
        }
        API.setWarp(jogador, "Spawn");
        e.setJoinMessage("§7[§e+§7] §7" + jogador.getName());
        jogador.getInventory().clear();
        jogador.setMaxHealth(20.0);
        jogador.setHealth(20.0);
        KitAPI.RemoveKit(jogador);
        jogador.setFoodLevel(20);
        jogador.setLevel(0);
        ScoreBoard.onScoreboard(jogador);
        jogador.getInventory().clear();
        jogador.getInventory().setArmorContents((ItemStack[])null);
        jogador.getInventory().setBoots(new ItemStack(Material.AIR));
        jogador.getInventory().setChestplate(new ItemStack(Material.AIR));
        jogador.getInventory().setLeggings(new ItemStack(Material.AIR));
        jogador.getInventory().setHelmet(new ItemStack(Material.AIR));
        jogador.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
        jogador.removePotionEffect(PotionEffectType.POISON);
        jogador.teleport(jogador.getWorld().getSpawnLocation());
        jogador.setGameMode(GameMode.ADVENTURE);
        AntiMoveAPI.AntiMove1.remove(jogador.getName());
        Timelord.cooldown.remove(jogador.getName());
        jogador.sendMessage(" ");
        jogador.sendMessage(" ");
        jogador.sendMessage(" ");
        jogador.sendMessage(" ");
        jogador.sendMessage(" ");
        jogador.sendMessage("§7Bem-Vindo ao " + Config.svs + "§7 !");
        Eventos.sendTitle(jogador, "§7Bem-Vindo");
        Eventos.sendSubTitle(jogador, Config.svs);
        Inventario.limpar(jogador);
        jogador.getPlayer().getWorld().playEffect(jogador.getPlayer().getLocation(), Effect.FIREWORKS_SPARK, 3, 0);
        jogador.playSound(jogador.getLocation(), Sound.FIREWORK_BLAST, 2.0f, 2.0f);
        jogador.playSound(jogador.getLocation(), Sound.FIREWORK_BLAST2, 2.0f, 2.0f);
        if (!Main.instance.status.contains(jogador.getName().toLowerCase())) {
            Main.instance.status.set(String.valueOf(jogador.getName().toLowerCase()) + ".Kills", (Object)0);
            Main.instance.status.set(String.valueOf(jogador.getName().toLowerCase()) + ".Deaths", (Object)0);
            Main.instance.status.set(String.valueOf(jogador.getName().toLowerCase()) + ".Money", (Object)0);
            Main.instance.save();
        }
    }
    
    @EventHandler
    public void aoSair(final PlayerQuitEvent e) {
        e.setQuitMessage((String)null);
    }
    
    @EventHandler
    public void death(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final CraftPlayer cp = (CraftPlayer)p;
                final EntityPlayer ep = cp.getHandle();
                final PlayerConnection c = ep.playerConnection;
                final PacketPlayInClientCommand pk = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
                c.a(pk);
            }
        }, 1L);
    }
    
    @EventHandler
    private void respawn(final PlayerRespawnEvent e) {
        final Player jogador = e.getPlayer();
        Inventario.limpar(jogador);
        KitAPI.RemoveKit(jogador);
    }
    
    @EventHandler
    public void Matanca(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        if (e.getEntity().getKiller() instanceof Player) {
            final Player t = p.getKiller();
            e.setDeathMessage((String)null);
            p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
            p.removePotionEffect(PotionEffectType.POISON);
            Status.addDeaths(p);
            Status.addKill(t);
            Status.addMoney(t);
            ScoreBoard.onScoreboard(p);
            ScoreBoard.onScoreboard(t);
            KitAPI.RemoveKit(p);
            Status.removeMoney(p);
            p.getInventory().clear();
            p.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea morreu para " + Config.cor + t.getName());
            t.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea matou " + Config.cor + p.getName());
        }
        else {
            e.setDeathMessage((String)null);
            KitAPI.RemoveKit(p);
            p.sendMessage(String.valueOf(Config.prefix) + Config.cor + "Voc\u00ea Morreu!");
            p.setLevel(0);
            ScoreBoard.onScoreboard(p);
        }
    }
}
