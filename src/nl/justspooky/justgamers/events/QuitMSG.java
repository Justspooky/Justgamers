package nl.justspooky.justgamers.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitMSG implements Listener {

@EventHandler
public void onplayerquit(PlayerQuitEvent e){
	if(e.getPlayer().hasPermission("justgamers.member")){
	String name = ChatColor.YELLOW + e.getPlayer().getName() + " ";
	e.setQuitMessage(ChatColor.GRAY + "(" + ChatColor.RED + "-" + ChatColor.GRAY + ")  " +  ChatColor.BLUE + ">> " + name);
	}
	if(e.getPlayer().hasPermission("justgamers.staff")){

	String sname = ChatColor.AQUA + e.getPlayer().getName() + " ";
	e.setQuitMessage(ChatColor.GRAY + "(" + ChatColor.GREEN + "-" + ChatColor.GRAY + ")  " +  ChatColor.BLUE + ">> " + sname);
}
	if(e.getPlayer().hasPermission("justgamers.owner")){
	String oname = ChatColor.GREEN + e.getPlayer().getName() + " ";
	e.setQuitMessage(ChatColor.GRAY + "(" + ChatColor.GOLD + "-" + ChatColor.GRAY + ")  " +  ChatColor.BLUE + ">> " + oname);
}
}
	
}
