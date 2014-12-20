package nl.justspooky.justgamers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.connorlinfoot.titleapi.TitleAPI;

public class Title implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onplayerjoin(PlayerJoinEvent e){
		TitleAPI.sendFullTitle(e.getPlayer(), 20, 400, 20, "Welkom op de Justgamers server", "Veel plezier");
	}
	
}
