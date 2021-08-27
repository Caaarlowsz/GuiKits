package me.RaidzDev.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.RaidzDev.*;
import me.RaidzDev.Eventos.*;

public class Kit implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§e[§eErro§e] §eApenas jogadores podem usar isso");
            return true;
        }
        final Player p = (Player)sender;
        if (args.length == 0) {
            p.sendMessage("§aUse: /kit (kit) ou /kits");
            return true;
        }
        if (args[0].equalsIgnoreCase("pvp")) {
            if (!p.hasPermission("kit.pvp")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.PvP(p);
                SetArena.TeleportArenaRandom(p);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " PvP");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("kangaroo")) {
            if (!p.hasPermission("kit.kangaroo")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Kangaroo(p);
                ScoreBoard.onScoreboard(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Kangaroo");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Bomber")) {
            if (!p.hasPermission("kit.Bomber")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Bomber(p);
                ScoreBoard.onScoreboard(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Bomber");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Sumo")) {
            if (!p.hasPermission("kit.Sumo")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Sumo(p);
                ScoreBoard.onScoreboard(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Sumo");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Strong")) {
            if (!p.hasPermission("kit.Strong")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Strong(p);
                ScoreBoard.onScoreboard(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Strong");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Lavaman")) {
            if (!p.hasPermission("kit.Lavaman")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Lavaman(p);
                ScoreBoard.onScoreboard(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Lavaman");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Thresh")) {
            if (!p.hasPermission("kit.Thresh")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Thresh(p);
                SetArena.TeleportArenaRandom(p);
                ScoreBoard.onScoreboard(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Thresh");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Specialist")) {
            if (!p.hasPermission("kit.Specialist")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Specialist(p);
                SetArena.TeleportArenaRandom(p);
                ScoreBoard.onScoreboard(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Specialist");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Flash")) {
            if (!p.hasPermission("kit.Flash")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Flash(p);
                SetArena.TeleportArenaRandom(p);
                ScoreBoard.onScoreboard(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Flash");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Ajnin")) {
            if (!p.hasPermission("kit.Ajnin")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Ajnin(p);
                SetArena.TeleportArenaRandom(p);
                ScoreBoard.onScoreboard(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Ajnin");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Thresh")) {
            if (!p.hasPermission("kit.Thresh")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Thresh(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Thresh");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("§c4")) {
            if (!p.hasPermission("kit.C4")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.C4(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " C4");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("ForceField")) {
            if (!p.hasPermission("kit.Forcefield")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.ForceField(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Forcefield");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Magma")) {
            if (!p.hasPermission("kit.Magma")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Magma(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Magma");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Blink")) {
            if (!p.hasPermission("kit.Blink")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Blink(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Blink");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Hulk")) {
            if (!p.hasPermission("kit.Hulk")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Hulk(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Hulk");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Swords")) {
            if (!p.hasPermission("kit.Swords")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Swords(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Swords");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Ryu")) {
            if (!p.hasPermission("kit.Ryu")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Ryu(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Ryu");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Endermage")) {
            if (!p.hasPermission("kit.Endermage")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Endermage(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Endermage");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Snail")) {
            if (!p.hasPermission("kit.Snail")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Snail(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Snail");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Timelord")) {
            if (!p.hasPermission("kit.Timelord")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Timelord(p);
                ScoreBoard.onScoreboard(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Timelord");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Achilles")) {
            if (!p.hasPermission("kit.Achilles")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Achilles(p);
                ScoreBoard.onScoreboard(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Achilles");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Phantom")) {
            if (!p.hasPermission("kit.Phantom")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Phantom(p);
                ScoreBoard.onScoreboard(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Phantom");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Switcher")) {
            if (!p.hasPermission("kit.Switcher")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Switcher(p);
                SetArena.TeleportArenaRandom(p);
                ScoreBoard.onScoreboard(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Switcher");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Stomper")) {
            if (!p.hasPermission("kit.Stomper")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Stomper(p);
                SetArena.TeleportArenaRandom(p);
                ScoreBoard.onScoreboard(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Stomper");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Thor")) {
            if (!p.hasPermission("kit.Thor")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Thor(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Thor");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Viking")) {
            if (!p.hasPermission("kit.Viking")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Viking(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Viking");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Firer")) {
            if (!p.hasPermission("kit.Firer")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Firer(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Firer");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Sonic")) {
            if (!p.hasPermission("kit.Sonic")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Sonic(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Sonic");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("§crack")) {
            if (!p.hasPermission("kit.Crack")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Crack(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Crack");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Reaper")) {
            if (!p.hasPermission("kit.Reaper")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Reaper(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Reaper");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Archer")) {
            if (!p.hasPermission("kit.Archer")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Archer(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Archer");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("§critical")) {
            if (!p.hasPermission("kit.Critical")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Critical(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Critical");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Demoman")) {
            if (!p.hasPermission("kit.Demoman")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Demoman(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Demoman");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Viper")) {
            if (!p.hasPermission("kit.Viper")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Viper(p);
                ScoreBoard.onScoreboard(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Viper");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Anchor")) {
            if (!p.hasPermission("kit.Anchor")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Anchor(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Anchor");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Negresco")) {
            if (!p.hasPermission("kit.Negresco")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Negresco(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Negresco");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("DeshFire")) {
            if (!p.hasPermission("kit.DeshFire")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Deshfire(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Deshfire");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Backpacker")) {
            if (!p.hasPermission("kit.Backpacker")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Backpacker(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Backpacker");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Ninja")) {
            if (!p.hasPermission("kit.Ninja")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Ninja(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Ninja");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Fisherman")) {
            if (!p.hasPermission("kit.Fisherman")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Fisherman(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Fisherman");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Avatar")) {
            if (!p.hasPermission("kit.Avatar")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Avatar(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Avatar");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Turtle")) {
            if (!p.hasPermission("kit.Turtle")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Turtle(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Turtle");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Barbarian")) {
            if (!p.hasPermission("kit.Barbarian")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Barbarian(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Barbarian");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Grappler")) {
            if (!p.hasPermission("kit.Grappler")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Grappler(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Grappler");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("DarkMage")) {
            if (!p.hasPermission("kit.DarkMage")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.DarkMage(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " DarkMage");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Berserker")) {
            if (!p.hasPermission("kit.Berserker")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Berserker(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Berserker");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("Gladiator")) {
            if (!p.hasPermission("kit.Gladiator")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Gladiator(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Gladiator");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("§camel")) {
            if (!p.hasPermission("kit.Camel")) {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
                return true;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Camel(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Camel");
                return true;
            }
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
            return true;
        }
        else {
            if (!args[0].equalsIgnoreCase("Poseidon") || !p.hasPermission("kit.Poseidon")) {
                return false;
            }
            if (KitAPI.getkit(p) == "Sem Classe") {
                KitAPI.Poseidon(p);
                SetArena.TeleportArenaRandom(p);
                Eventos.sendTitle(p, "§c" + args[0]);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.pegarkit) + Config.cor + " Poseidon");
                p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com uma classe!");
                return true;
            }
            p.sendMessage("§cVoc\u00ea n\u00e3o tem essa classe!");
            return true;
        }
    }
}
