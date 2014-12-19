package nl.justspooky.justgamers.cmdoverride;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class OpCMD implements Listener {

private static String no = ChatColor.BOLD + "No !!" + ChatColor.RESET ;
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onCommandPreProcess(PlayerCommandPreprocessEvent e)
	{
		if (e.getMessage().equalsIgnoreCase("/op") || e.getMessage().equalsIgnoreCase("op"))
		{
			if (!e.getPlayer().hasPermission("justgamers.admin.op"))
			{
				e.getPlayer().sendMessage(
						ChatColor.DARK_RED + no + ChatColor.DARK_RED + " You may not use the OP command");
				e.setCancelled(true);
			}
		}
		
		if (e.getMessage().equalsIgnoreCase("/deop") || e.getMessage().equalsIgnoreCase("deop"))
		{
			if (!e.getPlayer().hasPermission("justgamers.admin.deop"))
			{
				e.getPlayer().sendMessage(
						ChatColor.DARK_RED + no + ChatColor.DARK_RED + " You may not use the DEOP command");
				e.setCancelled(true);
			}
		}
	}
	
	
}
