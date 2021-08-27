package me.RaidzDev.Eventos;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.block.*;
import me.RaidzDev.*;
import org.bukkit.*;

public class PlacaFacil implements Listener
{
    @EventHandler
    public void Escrever(final SignChangeEvent e) {
        final Player p = e.getPlayer();
        if (p.hasPermission("placa.facil") && e.getLine(0).equalsIgnoreCase("facil")) {
            e.setLine(0, "�e---------");
            e.setLine(1, "�eChallenge");
            e.setLine(2, "�6Facil");
            e.setLine(3, "�e---------");
        }
    }
    
    @EventHandler
    public void inv(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null && (e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN_POST)) {
            final Sign s = (Sign)e.getClickedBlock().getState();
            final String[] lines = s.getLines();
            if (lines.length > 0 && lines[0].equals("�e---------") && lines.length > 1 && lines[1].equals("�eChallenge") && lines.length > 2 && lines[2].equals("�6Facil") && lines.length > 3 && lines[3].equals("�e---------")) {
                Status.addMoney1(p, 10);
                ScoreBoard.onScoreboard(p);
                p.sendMessage(String.valueOf(Config.prefix) + "Voc\u00ea completou a lava challenge �cfacil�7!");
                final World w = Bukkit.getServer().getWorld(Main.instance.warps.getString("ChallengeWorld"));
                final double x = Main.instance.warps.getDouble("ChallengeX");
                final double y = Main.instance.warps.getDouble("ChallengeY");
                final double z = Main.instance.warps.getDouble("ChallengeZ");
                p.teleport(new Location(w, x, y, z));
                p.updateInventory();
            }
        }
    }
}
