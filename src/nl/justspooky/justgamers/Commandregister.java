package nl.justspooky.justgamers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.connorlinfoot.titleapi.TitleAPI;

public class Commandregister {
	
	static SettingsManager settings = SettingsManager.getInstance();
	private static String prefix = ChatColor.AQUA + "[" + ChatColor.YELLOW + "Justgamers" + ChatColor.AQUA + "]" +ChatColor.WHITE + ": " + ChatColor.RED;
	
	public static void noperm (CommandSender sender){
		sender.sendMessage(prefix + ChatColor.RED + "You dont have permission for this");
	}
	
	public static void website(CommandSender sender){
		sender.sendMessage(prefix + ChatColor.RED + "Onze website is: " + ChatColor.GREEN + settings.getConfig().getString("website"));	
	}
	public static void twitter(CommandSender sender){
		sender.sendMessage(prefix + ChatColor.RED + "Ons Twitter account is: " + ChatColor.GREEN + "@" + settings.getConfig().getString("twitter"));
	}
	public static void facebook(CommandSender sender){
		sender.sendMessage(prefix + ChatColor.RED + "Ons Facebook acoount is: " + ChatColor.GREEN + settings.getConfig().getString("facebook"));
	}
	public static void mywarns(CommandSender sender){
		sender.sendMessage(ChatColor.GOLD + "-----------------------------------------------------");
		sender.sendMessage(ChatColor.GREEN + "You have: " + ChatColor.DARK_PURPLE +  settings.getData().get(sender.getName()) + ChatColor.GREEN + " Warnings");
		sender.sendMessage(ChatColor.GOLD + "-----------------------------------------------------");
	}
	public static void Staffhelp(CommandSender sender){
		sender.sendMessage(ChatColor.GOLD + "----------------------" + ChatColor.DARK_RED + ChatColor.BOLD +" Staff " + ChatColor.GOLD + "----------------------");
		sender.sendMessage(ChatColor.RED + "Warn players with Only for online players !! " + ChatColor.YELLOW + "/warn <Player> <Reason>");
		sender.sendMessage(ChatColor.RED + "Check the Warnings of a player Only for online players !! " + ChatColor.YELLOW + "/warnings <Player>");
		sender.sendMessage(ChatColor.GREEN + "Alliases: ");
		sender.sendMessage(ChatColor.AQUA + "Usage: /staff <allias>");
		sender.sendMessage(ChatColor.GOLD + "-----------------------------------------------------");
	}
	public static void rules(CommandSender sender){
		sender.sendMessage(ChatColor.GOLD + "----------------------" + ChatColor.DARK_RED + ChatColor.BOLD +" Rules " + ChatColor.GOLD + "----------------------");
		sender.sendMessage(ChatColor.WHITE + "1. " + ChatColor.AQUA + "Don't spam, Or use caps");
		sender.sendMessage(ChatColor.WHITE + "2. " + ChatColor.GREEN + "Don't Advertise");
		sender.sendMessage(ChatColor.WHITE + "3. " + ChatColor.AQUA + "Don't Curse");
		sender.sendMessage(ChatColor.WHITE + "4. " + ChatColor.GREEN + "Be Respect full");
		sender.sendMessage(ChatColor.WHITE + "5. " + ChatColor.AQUA + "Don't Camp");
		sender.sendMessage(ChatColor.WHITE + "6. " + ChatColor.GREEN + "Don't use hacks");
		sender.sendMessage(ChatColor.WHITE + "7. " + ChatColor.AQUA + "By 5 Warnings you get a permanent ban");
		sender.sendMessage(ChatColor.WHITE + "8. " + ChatColor.GREEN + "Don't ask for Operator or a rank");
		sender.sendMessage(ChatColor.WHITE + "9. " + ChatColor.AQUA + "Don't scam people");
		sender.sendMessage(ChatColor.WHITE + "10. " + ChatColor.GREEN + "AFK Maschine ars not allowed");
		sender.sendMessage(ChatColor.GOLD + "-----------------------------------------------------");
	}
	public static void regels(CommandSender sender){
		sender.sendMessage(ChatColor.GOLD + "----------------------" + ChatColor.DARK_RED + ChatColor.BOLD +" Regels " + ChatColor.GOLD + "----------------------");
		sender.sendMessage(ChatColor.WHITE + "1. " + ChatColor.AQUA + "Niet spammen en gebuik geen caps");
		sender.sendMessage(ChatColor.WHITE + "2. " + ChatColor.GREEN + "Maak geen reclamen");
		sender.sendMessage(ChatColor.WHITE + "3. " + ChatColor.AQUA + "Niet schelden");
		sender.sendMessage(ChatColor.WHITE + "4. " + ChatColor.GREEN + "Heb respect voor iedereen");
		sender.sendMessage(ChatColor.WHITE + "5. " + ChatColor.AQUA + "Niet campen");
		sender.sendMessage(ChatColor.WHITE + "6. " + ChatColor.GREEN + "Gebruik geen hacks");
		sender.sendMessage(ChatColor.WHITE + "7. " + ChatColor.AQUA + "Bij 5 waarschuwingen krijg je een permanent ban");
		sender.sendMessage(ChatColor.WHITE + "8. " + ChatColor.GREEN + "Vraag niet voor op of om een rank");
		sender.sendMessage(ChatColor.WHITE + "9. " + ChatColor.AQUA + "Geen mensen oplichten");
		sender.sendMessage(ChatColor.WHITE + "10. " + ChatColor.GREEN + "AFK machines zijn niet toegestaan");
		sender.sendMessage(ChatColor.GOLD + "-----------------------------------------------------");
	}
	@SuppressWarnings("deprecation")
	public static void shopttp (CommandSender sender){
		 Player p = (Player) sender;
         World w = Bukkit.getServer().getWorld(settings.getConfig().getString("shop.world"));
         double x = settings.getConfig().getDouble("shop.x");
         double y = settings.getConfig().getDouble("shop.y");
         double z = settings.getConfig().getDouble("shop.z");
         p.teleport(new Location(w, x, y, z));
         p.sendMessage(prefix + ChatColor.RED + "Welcome in the shop!");
         TitleAPI.sendTitle(p, 20, 100, 20, ChatColor.AQUA + "Welcome in the shop");
	}
	public static void setshop (CommandSender sender){
		Player p = (Player) sender;
        settings.getConfig().set("shop.world", p.getLocation().getWorld().getName());
        settings.getConfig().set("shop.x", p.getLocation().getX());
        settings.getConfig().set("shop.y", p.getLocation().getY());
        settings.getConfig().set("shop.z", p.getLocation().getZ());
        settings.saveConfig();
        p.sendMessage(prefix + ChatColor.LIGHT_PURPLE + "Shop Location set");
	}
	@SuppressWarnings("deprecation")
	public static void donate (CommandSender sender){
		Player p = (Player) sender;
		sender.sendMessage(prefix + "Donate on our website to help the server to pay the bills");
		sender.sendMessage(prefix + "http://www.justgamers.nl/donate");
		TitleAPI.sendFullTitle(p, 20, 100, 20, ChatColor.RED + "Donate at our website", ChatColor.YELLOW + "http://www.justgamers.nl/donate");
	}
}
	
