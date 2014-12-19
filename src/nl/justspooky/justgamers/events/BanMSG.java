package nl.justspooky.justgamers.events;

import nl.justspooky.justgamers.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class BanMSG implements Listener {

	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerBanned(PlayerLoginEvent e) {
	
		Player player = e.getPlayer();
		Object level = settings.getData().get(e.getPlayer().getName());
		
		if (settings.getData().get(e.getPlayer().getName()) == null){
			
			settings.getData().set(e.getPlayer().getName(), 0);
			settings.saveData();
		}
		
		int l = Integer.parseInt(level.toString());	
		
	Object bm = settings.getBans().get(player.getName());
	if (e.getResult() == Result.KICK_BANNED) {
	if(bm != null){
		if(l > 4){
	e.setKickMessage(ChatColor.RED + "Banned: " + ChatColor.AQUA + bm);
   }
	}
	 }
	  }
       }
