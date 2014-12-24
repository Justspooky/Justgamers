package nl.justspooky.justgamers.events;


import nl.justspooky.justgamers.SettingsManager;

import org.bukkit.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;



public class JoinMSG implements Listener {

	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onplayerjoin(PlayerJoinEvent e){
		Player target = e.getPlayer();
		Object level = settings.getData().get(e.getPlayer().getName());
		
		
		int l = Integer.parseInt(level.toString());
		
		String news = settings.getConfig().getString("news");
		news = news.replaceAll("&", "§");
		
		target.sendMessage(ChatColor.DARK_BLUE + "------------------" + ChatColor.GOLD + "JustGamers Server"+ ChatColor.DARK_BLUE + "------------------");
		target.sendMessage(ChatColor.YELLOW + "Have Fun on the server");
		target.sendMessage(ChatColor.GREEN + "Vote on the server and get nice rewards do /vote for more information");
		target.sendMessage(ChatColor.RED + "News: " + news);
		
		if (l == 0){
		target.sendMessage(ChatColor.AQUA + "You have no warnings " + ChatColor.RED + target.getName() + ChatColor.AQUA + " You are a good player.");
		}
		if (l == 1){
		target.sendMessage(ChatColor.LIGHT_PURPLE + "You have " + ChatColor.DARK_RED + settings.getData().get(target.getName()) + ChatColor.LIGHT_PURPLE +  " Warning");
		}
		if (l == 2){
			target.sendMessage(ChatColor.LIGHT_PURPLE + "You have " + ChatColor.DARK_RED + settings.getData().get(target.getName()) + ChatColor.LIGHT_PURPLE +  " Warnings");
		}
		if (l == 3){
			target.sendMessage(ChatColor.LIGHT_PURPLE + "You have " + ChatColor.DARK_RED + settings.getData().get(target.getName()) + ChatColor.LIGHT_PURPLE +  " Warnings");
			target.sendMessage(ChatColor.RED + "Watch out by the next warning you wil be tempbanned for 2 hours");
		}
		if (l == 4){
			target.sendMessage(ChatColor.LIGHT_PURPLE + "You have " + ChatColor.DARK_RED + settings.getData().get(target.getName()) + ChatColor.LIGHT_PURPLE +  " Warnings");
			target.sendMessage(ChatColor.RED + "Watch out by the next warning you wil be permanently banned from the server");
		}
		if (target.hasPermission("justgamers.staff")){
			target.sendMessage(ChatColor.AQUA + "You are a staff member thanks for that");
		}
	}

	
}