package me.RaidzDev.Utils;

import org.bukkit.entity.*;
import me.RaidzDev.Comandos.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import me.RaidzDev.*;
import org.bukkit.inventory.meta.*;

public class Inventario
{
    public static void limpar(final Player jogador) {
        if (Admin.admin.contains(jogador)) {
            Admin.admin.remove(jogador);
        }
        jogador.getInventory().clear();
        jogador.setGameMode(GameMode.ADVENTURE);
        jogador.setExp(0.0f);
        jogador.setHealth(20.0);
        jogador.setLevel(0);
        jogador.setFoodLevel(20);
        jogador.setFlySpeed(0.1f);
        jogador.getInventory().clear();
        jogador.getInventory().setArmorContents((ItemStack[])null);
        final ItemStack classe = new ItemStack(Material.ENDER_CHEST);
        final ItemMeta zclasse = classe.getItemMeta();
        zclasse.setDisplayName("§7» " + Config.cor + "Classes§7 «");
        classe.setItemMeta(zclasse);
        final ItemStack warp = new ItemStack(Material.PAPER);
        final ItemMeta zwarp = warp.getItemMeta();
        zwarp.setDisplayName("§7» " + Config.cor + "Warps§7 «");
        warp.setItemMeta(zwarp);
        final ItemStack loja = new ItemStack(Material.EMERALD);
        final ItemMeta zloja = loja.getItemMeta();
        zloja.setDisplayName("§7» " + Config.cor + "Loja§7 «");
        loja.setItemMeta(zloja);
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE);
        final ItemMeta zvidro = vidro.getItemMeta();
        zvidro.setDisplayName("§7§o-");
        vidro.setItemMeta(zvidro);
        final ItemStack barra = new ItemStack(Material.IRON_FENCE);
        final ItemMeta zbarra = barra.getItemMeta();
        zbarra.setDisplayName("§7§o-");
        barra.setItemMeta(zbarra);
        final ItemStack uvu = new ItemStack(Material.BLAZE_ROD);
        final ItemMeta zuvu = uvu.getItemMeta();
        zuvu.setDisplayName("§7» " + Config.cor + "1v1§7 «");
        uvu.setItemMeta(zuvu);
        final ItemStack book = new ItemStack(Material.BOOK);
        final ItemMeta zbook = book.getItemMeta();
        zbook.setDisplayName("§7» " + Config.cor + "Informa\u00e7\u00e3o§7 «");
        book.setItemMeta(zbook);
        jogador.getInventory().setItem(1, warp);
        jogador.getInventory().setItem(2, vidro);
        jogador.getInventory().setItem(3, uvu);
        jogador.getInventory().setItem(4, classe);
        jogador.getInventory().setItem(5, book);
        jogador.getInventory().setItem(6, vidro);
        jogador.getInventory().setItem(7, loja);
    }
}
