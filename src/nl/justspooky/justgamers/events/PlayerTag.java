package nl.justspooky.justgamers.events;

import nl.justspooky.justgamers.SettingsManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;
import org.kitteh.tag.TagAPI;


public class PlayerTag implements Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
     public void onPlayerTag(AsyncPlayerReceiveNameTagEvent e) {
             Player p = e.getNamedPlayer();
             if (!p.isOp()){
             if (p.hasPermission("justgamers.member")){
            	 String membercolor = settings.getConfig().getString("membercolor");
             	membercolor = membercolor.replaceAll("&", "§");
             	e.setTag(membercolor + p.getName());
             }
             if(p.hasPermission("justgamers.staff")){
            	 
            	String staffcolor = settings.getConfig().getString("staffcolor");
            	staffcolor = staffcolor.replaceAll("&", "§");
            	 e.setTag(staffcolor + p.getName());
            	 
             }}
             if(p.hasPermission("justgamers.owner")){
            	 
              	String ownercolor = settings.getConfig().getString("ownercolor");
              	ownercolor = ownercolor.replaceAll("&", "§");
              	 e.setTag(ownercolor + p.getName());
              	 
               }
            	 
     }
	
	@EventHandler
	public void onplayerjoin(PlayerJoinEvent e){
		TagAPI.refreshPlayer(e.getPlayer());
	}
}
