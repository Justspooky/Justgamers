package nl.justspooky.justgamers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.connorlinfoot.titleapi.TitleAPI;

public class Title implements Listener {

	SettingsManager settings = SettingsManager.getInstance();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onplayerjoin(PlayerJoinEvent e){
		
	String head = settings.getConfig().getString("title.head");
	head = head.replaceAll("&", "§");
	
	String subtitle = settings.getConfig().getString("title.subsitle");
	subtitle = subtitle.replaceAll("&", "§");
	
	int time = settings.getConfig().getInt("title.time");
		
		
		TitleAPI.sendFullTitle(e.getPlayer(), 20, time, 20, head, subtitle);
	}
	
}
