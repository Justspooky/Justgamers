package nl.justspooky.justgamers.events;

import nl.justspooky.justgamers.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class Chatmessage implements Listener {

	private static String prefix = ChatColor.AQUA + "[" + ChatColor.YELLOW + "Justgamers" + ChatColor.AQUA + "]" +ChatColor.WHITE + ": " + ChatColor.RED;
	
	SettingsManager settings = SettingsManager.getInstance();

	
	@EventHandler
	public void onplayerchat(PlayerChatEvent e){
		
		
		 
		 
		if (!e.getPlayer().hasPermission("justgamers.staff") || e.getPlayer().isOp()) 
		{
		if (e.getMessage().contains("kanker")){
			e.getPlayer().sendMessage(prefix + "You may not Swear !!");
			e.setMessage("***");	
			}
		if (e.getMessage().contains("tering")){
			e.getPlayer().sendMessage(prefix + "You may not Swear !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("jood")){
			e.getPlayer().sendMessage(prefix + "You may not Swear !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("k.anker")){
			e.getPlayer().sendMessage(prefix + "You may not Swear !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("ka.nker")){
			e.getPlayer().sendMessage(prefix + "You may not Swear !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("kan.ker")){
			e.getPlayer().sendMessage(prefix + "You may not Swear !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("kank.er")){
			e.getPlayer().sendMessage(prefix + "You may not Swear !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("kanke.r")){
			e.getPlayer().sendMessage(prefix + "You may not Swear !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("kanker.")){
			e.getPlayer().sendMessage(prefix + "You may not Swear !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains(".kanker")){
			e.getPlayer().sendMessage(prefix + "You may not Swear !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("join now")){
			e.getPlayer().kickPlayer(prefix + "You may not Advertise !!");
			e.setMessage("***");	
			Bukkit.broadcastMessage(prefix + ChatColor.BLUE + e.getPlayer().getName()+ ChatColor.AQUA +" Has been kicked from the server");
		}
		if (e.getMessage().contains("join nu")){
			e.getPlayer().kickPlayer(prefix + "You may not Advertise !!");
			e.setMessage("***");
			Bukkit.broadcastMessage(prefix + ChatColor.BLUE + e.getPlayer().getName()+ ChatColor.AQUA +" Has been kicked from the server");
		}
		if (e.getMessage().contains("knolpower")){
			e.getPlayer().sendMessage(prefix + "Fuck enzoknol we hate him !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains(".net")){
			e.getPlayer().sendMessage(prefix + "You may not advertise !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains(".com")){
			e.getPlayer().sendMessage(prefix + " You may not advertise !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains(".nl")){
			e.getPlayer().sendMessage(prefix + " You may not advertise !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains(".nu")){
			e.getPlayer().sendMessage(prefix + " You may not advertise !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("www.")){
			e.getPlayer().sendMessage(prefix + " You may not advertise !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("http://")){
			e.getPlayer().sendMessage(prefix + " You may not advertise !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("https://")){
			e.getPlayer().sendMessage(prefix + " You may not advertise !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("kingdom")){
			e.getPlayer().sendMessage(prefix + " kingdom is owned by DDG and we are not interested in your fake kingdom server  !!");
			e.setMessage("***");	
		}
		if (e.getMessage().contains("#")){
			e.getPlayer().sendMessage(prefix + " We are not twitter we are a minecraft server !!");
			e.setMessage("***");	
		}
		}
	}
}
