package me.RaidzDev.Eventos;

import org.bukkit.event.server.*;
import me.RaidzDev.*;
import org.bukkit.event.*;

public class Motd implements Listener
{
    @EventHandler
    public void Listar(final ServerListPingEvent e) {
        e.setMotd(Main.instance.configuracoes.getString("Motd").replace("&", "§").replace("<linha>", "\n"));
    }
}
