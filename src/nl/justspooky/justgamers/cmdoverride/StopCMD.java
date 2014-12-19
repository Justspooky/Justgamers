package nl.justspooky.justgamers.cmdoverride;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class StopCMD implements Listener {

	
	private static String no = ChatColor.BOLD + "No !!" + ChatColor.RESET ;
	
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onCommandPreProcess(PlayerCommandPreprocessEvent e)
	{
		
		if (e.getMessage().startsWith("/stop" + e.getMessage().endsWith(e.getMessage())) || e.getMessage().equalsIgnoreCase("stop" + e.getMessage().endsWith(e.getMessage())))
		{
			if (!e.getPlayer().hasPermission("justgamers.admin.stop"))
			{
				e.getPlayer().sendMessage(
						ChatColor.DARK_RED + no + ChatColor.RED + " You may not STOP the server !");
				e.setCancelled(true);
			}
		}
		if (e.getMessage().startsWith("/stop") || e.getMessage().equalsIgnoreCase("stop"))
		{
			if (!e.getPlayer().hasPermission("justgamers.admin.stop"))
			{
				e.getPlayer().sendMessage(
						ChatColor.DARK_RED + no + ChatColor.RED + " You may not STOP the server !");
				e.setCancelled(true);
			}
		}
	
	
		}
	}

