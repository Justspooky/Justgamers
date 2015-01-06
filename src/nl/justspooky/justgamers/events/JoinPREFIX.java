package nl.justspooky.justgamers.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinPREFIX implements Listener {

	@EventHandler (priority = EventPriority.HIGHEST)
	public void playerjoin(PlayerJoinEvent e){
		if(e.getPlayer().hasPermission("justgamers.member")){
		String name = ChatColor.YELLOW + e.getPlayer().getName() + " ";
		e.setJoinMessage(name + ChatColor.BLUE + ">> " + ChatColor.GRAY + "Joined the server");
		}
		if(e.getPlayer().hasPermission("justgamers.staff")){
			String Stafftag = ChatColor.GRAY + "[" + ChatColor.RED + ChatColor.BOLD + "Staff" + ChatColor.GRAY + "] " + ChatColor.BLUE + ">> ";
		String sname = ChatColor.AQUA + e.getPlayer().getName() + " ";
		e.setJoinMessage(Stafftag + sname + ChatColor.GRAY + "Joined the server");
	}
		if(e.getPlayer().hasPermission("justgamers.owner")){
			String ownertag = ChatColor.GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "Owner" + ChatColor.GRAY + "] " + ChatColor.BLUE + ">> ";
		String oname = ChatColor.GREEN + e.getPlayer().getName() + " ";
		e.setJoinMessage(ownertag + oname + ChatColor.GRAY + "Joined the server");
	}
}
	
}
