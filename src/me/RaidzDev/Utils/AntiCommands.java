package me.RaidzDev.Utils;

import org.bukkit.event.player.*;
import me.RaidzDev.Eventos.*;
import me.RaidzDev.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class AntiCommands implements Listener
{
    @EventHandler
    public void onMe2(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (APIWarp.tanawarp.contains(p.getName()) && (e.getMessage().toLowerCase().startsWith("/fake") || e.getMessage().toLowerCase().startsWith("/fakeoff") || e.getMessage().toLowerCase().startsWith("/shop") || e.getMessage().toLowerCase().startsWith("/loja") || e.getMessage().toLowerCase().startsWith("/kits") || e.getMessage().toLowerCase().startsWith("/kit") || e.getMessage().toLowerCase().startsWith("/challenge") || e.getMessage().toLowerCase().startsWith("/knockback") || e.getMessage().toLowerCase().startsWith("/warp") || e.getMessage().toLowerCase().startsWith("/chamber") || e.getMessage().toLowerCase().startsWith("/1v1") || e.getMessage().toLowerCase().startsWith("/loja") || e.getMessage().toLowerCase().startsWith("/fps") || e.getMessage().toLowerCase().startsWith("/chamber") || e.getMessage().toLowerCase().startsWith("/mdr") || e.getMessage().toLowerCase().startsWith("/rdm") || e.getMessage().toLowerCase().startsWith("/ct") || e.getMessage().toLowerCase().startsWith("/tp") || e.getMessage().toLowerCase().startsWith("/fly") || e.getMessage().toLowerCase().startsWith("/kits2"))) {
            e.setCancelled(true);
            p.sendMessage(String.valueOf(Config.Aviso) + " §7Voc\u00ea j\u00e1 est\u00e1 em uma warp!");
            p.sendMessage(String.valueOf(Config.dica) + " §7/spawn");
        }
    }
}
