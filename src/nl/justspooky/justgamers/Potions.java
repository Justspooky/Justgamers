package nl.justspooky.justgamers;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Potions {

	private static String prefix = ChatColor.AQUA + "[" + ChatColor.YELLOW + "Justgamers" + ChatColor.AQUA + "]" +ChatColor.WHITE + ": " + ChatColor.RED;
	
	public static void speed (CommandSender sender){
		Player p = (Player) sender;
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED , 200 , 2 , false));
		p.sendMessage(prefix + ChatColor.RED + "Je hebt je speed potion gekregen");
	}
	
}
