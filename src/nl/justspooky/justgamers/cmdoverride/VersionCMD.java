package nl.justspooky.justgamers.cmdoverride;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class VersionCMD implements Listener {

	
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onCommandPreProcess(PlayerCommandPreprocessEvent e)
	{
		if (e.getMessage().equalsIgnoreCase("/version") || e.getMessage().equalsIgnoreCase("version"))
		{
			e.getPlayer().sendMessage(
						ChatColor.WHITE + "Justgamers Server Version: " + 
			ChatColor.DARK_RED + "0.0.1" + 
											ChatColor.YELLOW  + 
																" Alpha" );
				e.setCancelled(true);
			}
		
		
		if (e.getMessage().equalsIgnoreCase("/about") || e.getMessage().equalsIgnoreCase("about"))
		{
			e.getPlayer().sendMessage(
						ChatColor.WHITE + "Justgamers Server Version: " + 
			ChatColor.DARK_RED + "0.0.1" + 
											ChatColor.YELLOW  + 
																" Alpha" );
				e.setCancelled(true);
			}
	
		}
	}

