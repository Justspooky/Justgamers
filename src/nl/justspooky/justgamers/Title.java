package nl.justspooky.justgamers;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.connorlinfoot.titleapi.TitleAPI;

public class Title implements Listener {

	SettingsManager settings = SettingsManager.getInstance();
	
	@SuppressWarnings("deprecation")
	@EventHandler
			public void onplayerjoin(PlayerJoinEvent e){		
				TitleAPI.sendFullTitle(e.getPlayer(), 20, 400, 20, ChatColor.GREEN + "Justgamers " + ChatColor.AQUA + "Server", ChatColor.RED + "Website: " + ChatColor.YELLOW + settings.getConfig().getString("website"));
				TitleAPI.sendTabTitle(e.getPlayer(), ChatColor.GOLD + "Justgamers Server", ChatColor.RED + "http://www.justgamers.nl");
				
	}
	
}
