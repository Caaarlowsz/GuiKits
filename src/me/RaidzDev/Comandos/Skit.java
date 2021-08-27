package me.RaidzDev.Comandos;

import org.bukkit.event.*;
import org.bukkit.inventory.*;
import org.bukkit.command.*;
import me.RaidzDev.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;

public class Skit implements Listener, CommandExecutor
{
    public HashMap<String, ItemStack[]> kits;
    public HashMap<String, ItemStack[]> armor;
    
    public Skit() {
        this.kits = new HashMap<String, ItemStack[]>();
        this.armor = new HashMap<String, ItemStack[]>();
    }
    
    public boolean isInt(final String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("skit") && (p.hasPermission("guikits.skit") || p.isOp())) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.AQUA + "Como criar um skit(kit para eventos):");
                p.sendMessage(ChatColor.GRAY + "1 §7- Monte seu inventario da maneira como quer que os jogadores recebam");
                p.sendMessage(ChatColor.GRAY + "2 §7- Digite /skit criar <nome>");
                p.sendMessage(ChatColor.RED + " ");
                p.sendMessage(String.valueOf(Config.cor) + "Como aplicar um skit:");
                p.sendMessage(ChatColor.GRAY + "1 §7- Digite /skit aplicar <nome> <raio>");
                p.sendMessage(ChatColor.RED + "OBS:" + ChatColor.GRAY + " O kit precisa ter sido criado previamente!");
                return true;
            }
            if (args[0].equalsIgnoreCase("criar")) {
                if (args.length == 1) {
                    p.sendMessage(ChatColor.AQUA + "Como criar um skit:");
                    p.sendMessage(ChatColor.GRAY + "1§7 - Monte seu inventario da maneira como quer que os jogadores recebam");
                    p.sendMessage(ChatColor.GRAY + "2§7 - Digite /skit criar <nome>");
                    return true;
                }
                final String name = args[1];
                this.kits.put(name, p.getInventory().getContents());
                this.armor.put(name, p.getInventory().getArmorContents());
                p.sendMessage(String.valueOf(Config.cor) + "Kit " + args[1] + " criado com sucesso!");
                return true;
            }
            else if (args[0].equalsIgnoreCase("aplicar")) {
                if (args.length <= 2) {
                    p.sendMessage(String.valueOf(Config.cor) + "Como aplicar um skit:");
                    p.sendMessage(ChatColor.GRAY + "1§7 - Digite /skit aplicar <nome> <raio>");
                    p.sendMessage(ChatColor.RED + "OBS:" + ChatColor.GRAY + " O kit precisa ter sido criado previamente!");
                    return true;
                }
                final String name = args[1];
                if (!this.kits.containsKey(name) && !this.armor.containsKey(name)) {
                    p.sendMessage(ChatColor.RED + "Kit " + name + " nao encontrado!");
                    return true;
                }
                if (this.isInt(args[2])) {
                    final int numero = Integer.parseInt(args[2]);
                    for (final Entity ent : p.getNearbyEntities((double)numero, (double)numero, (double)numero)) {
                        if (ent instanceof Player) {
                            final Player plr = (Player)ent;
                            plr.getInventory().setArmorContents((ItemStack[])this.armor.get(name));
                            plr.getInventory().setContents((ItemStack[])this.kits.get(name));
                        }
                    }
                    Bukkit.getServer().broadcastMessage(String.valueOf(Config.cor) + "Kit " + name + " aplicado para jogadores em um raio de " + numero + " blocos");
                    p.sendMessage(String.valueOf(Config.cor) + "Kit " + name + " aplicado para jogadores em um raio de " + numero + " blocos");
                    return true;
                }
                return true;
            }
        }
        return false;
    }
}
