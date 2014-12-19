package nl.justspooky.justgamers.events;

import nl.justspooky.justgamers.SettingsManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class Motd implements Listener {
	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onserverping(ServerListPingEvent e){
		String motd = settings.getConfig().getString("motd");
		motd = motd.replaceAll("&", "§");
		e.setMotd(motd);
		settings.saveConfig();
	}
	
	
}
