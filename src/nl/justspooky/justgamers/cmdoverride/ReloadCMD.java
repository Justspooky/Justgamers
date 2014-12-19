package nl.justspooky.justgamers.cmdoverride;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ReloadCMD implements Listener {

	private static String no = ChatColor.BOLD + "No !!" + ChatColor.RESET ;
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onCommandPreProcess(PlayerCommandPreprocessEvent e)
	{
		if (e.getMessage().startsWith("/reload" + e.getMessage().endsWith(e.getMessage())) || e.getMessage().equalsIgnoreCase("reload" + e.getMessage().endsWith(e.getMessage())))
		{
			if (!e.getPlayer().hasPermission("justgamers.admin.reload")) 
			{
				e.getPlayer().sendMessage(
						ChatColor.DARK_RED + no + ChatColor.RED + " You may not RELOAD the server !");
				e.setCancelled(true);
			}
		}
		if (e.getMessage().startsWith("/reload") || e.getMessage().equalsIgnoreCase("reload"))
		{
			if (!e.getPlayer().hasPermission("justgamers.admin.reload"))
			{
				e.getPlayer().sendMessage(
						ChatColor.DARK_RED + no + ChatColor.RED + " You may not RELOAD the server !");
				e.setCancelled(true);
			}
		}
	
	
		}
	}
