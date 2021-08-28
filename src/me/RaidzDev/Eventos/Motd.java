package me.RaidzDev.Eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.RaidzDev.Main;

public class Motd implements Listener {
	@EventHandler
	public void Listar(final ServerListPingEvent e) {
		e.setMotd(Main.instance.configuracoes.getString("Motd").replace("&", "§").replace("<linha>", "\n"));
	}
}
