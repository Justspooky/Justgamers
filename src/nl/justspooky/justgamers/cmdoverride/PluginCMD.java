package nl.justspooky.justgamers.cmdoverride;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PluginCMD implements Listener {
	
private static String plmessage = ChatColor.RED + "You may not see the plugin list !";


	@EventHandler(priority=EventPriority.HIGHEST)
	public void onCommandPreProcess(PlayerCommandPreprocessEvent e)
	{
		
		if (e.getMessage().startsWith("/pl" + e.getMessage().endsWith(e.getMessage())) || e.getMessage().equalsIgnoreCase("pl" + e.getMessage().endsWith(e.getMessage())))
		{
			if (!e.getPlayer().hasPermission("justgamers.admin.pl")) {
			e.getPlayer().sendMessage(
						ChatColor.WHITE + "Plugins (1): " + plmessage);
				e.setCancelled(true);
			}}
		
		if (e.getMessage().startsWith("/plugins" + e.getMessage().endsWith(e.getMessage())) || e.getMessage().equalsIgnoreCase("plugins" + e.getMessage().endsWith(e.getMessage())))
		{
			if (!e.getPlayer().hasPermission("justgamers.admin.pl")) {
		
			e.getPlayer().sendMessage(
						ChatColor.WHITE + "Plugins (1): " + plmessage);
				e.setCancelled(true);
			}}
		
		if (e.getMessage().startsWith("/pl") || e.getMessage().equalsIgnoreCase("pl"))
		{
			if (!e.getPlayer().hasPermission("justgamers.admin.pl")) {
		
			e.getPlayer().sendMessage(
						ChatColor.WHITE + "Plugins (1): " + plmessage);
				e.setCancelled(true);
			}}
		
		//if (e.getMessage().startsWith("/plugins") || e.getMessage().equalsIgnoreCase("plugins"))
		//{
			//if (!e.getPlayer().hasPermission("justgamers.admin.pl")) {
		
			//e.getPlayer().sendMessage(
				//		ChatColor.WHITE + "Plugins (1): " + plmessage);
				//e.setCancelled(true);
			//}}
		}
	}

