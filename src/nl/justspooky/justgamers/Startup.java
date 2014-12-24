package nl.justspooky.justgamers;


import java.util.logging.Logger;

import nl.justspooky.justgamers.cmdoverride.OpCMD;
import nl.justspooky.justgamers.cmdoverride.PluginCMD;
import nl.justspooky.justgamers.cmdoverride.ReloadCMD;
import nl.justspooky.justgamers.cmdoverride.RulesCMD;
import nl.justspooky.justgamers.cmdoverride.StopCMD;
import nl.justspooky.justgamers.cmdoverride.VersionCMD;
import nl.justspooky.justgamers.events.BanMSG;
import nl.justspooky.justgamers.events.Chatmessage;
import nl.justspooky.justgamers.events.JoinMSG;
import nl.justspooky.justgamers.events.JoinPREFIX;
//import nl.justspooky.justgamers.events.Motd;
import nl.justspooky.justgamers.events.PlayerTag;
import nl.justspooky.justgamers.events.QuitMSG;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
//import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.kitteh.tag.TagAPI;

public class Startup extends JavaPlugin {

	public final Logger l = Logger.getLogger("Minecraft");	
	
	private static String prefix = ChatColor.AQUA + "[" + ChatColor.YELLOW + "Justgamers" + ChatColor.AQUA + "]" +ChatColor.WHITE + ": " + ChatColor.RED;
	
	SettingsManager settings = SettingsManager.getInstance();
	
	

	
	@Override
	public void onEnable(){
		Crafting.firerecipe();
		if (Bukkit.getServer().getPluginManager().getPlugin("TagAPI") == null){
			l.warning("TagAPI is not in the server the plugin wil not work without TagAPI");
		}
		l.info("-----------------------------------------------------");
		l.info("De Justgamers server is opgestart.");
		l.info("Developer: Kevin Wilmsen http://www.kevinwilmsen.nl");
		l.info("Version: " + getDescription().getVersion());
		l.info("Authors: " + getDescription().getAuthors());
		l.info("-----------------------------------------------------");
		PluginManager manager = this.getServer().getPluginManager();
		
		
		//Config create
		
		settings.setup(this);
		settings.saveConfig();
		
		// Commands overides
				manager.registerEvents(new PluginCMD(), this);
				manager.registerEvents(new VersionCMD(), this);
				manager.registerEvents(new OpCMD(), this);
				manager.registerEvents(new ReloadCMD(), this);
				manager.registerEvents(new StopCMD(), this);
				manager.registerEvents(new RulesCMD(), this);
				
			// Event
				manager.registerEvents(new Chatmessage(), this);
				manager.registerEvents(new JoinMSG(), this);
				manager.registerEvents(new BanMSG(), this);
				//manager.registerEvents(new Motd(), this);
				manager.registerEvents(new PlayerTag(), this);
				manager.registerEvents(new Title(), this);
				// JoinPrefix
				manager.registerEvents(new JoinPREFIX(), this);
				manager.registerEvents(new QuitMSG(), this);
				
	} 
	
	// ** Fix the warning messages and create a join message

	@Override
	public void onDisable(){
		l.info("-----------------------------------------------------");
		l.info("De Justgamers server is Afgesloten.");
		l.info("Developer: Kevin Wilmsen http://www.kevinwilmsen.nl");
		l.info("Version: " + getDescription().getVersion());
		l.info("Authors: " + getDescription().getAuthors());
		l.info("-----------------------------------------------------");
	}
	
	BanList bukkitBanList = Bukkit.getBanList(BanList.Type.NAME);
	BanList serverBanList = getServer().getBanList(BanList.Type.NAME);


@SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	if (cmd.getName().equalsIgnoreCase("staff")){
		if (sender.hasPermission("justgamers.staff")){
		Commandregister.Staffhelp(sender);
		}
		Commandregister.noperm(sender);
	}
	
	if (!(sender instanceof Player)) {
		sender.sendMessage("Only ingame players can set the shop location");
	}else
	if (cmd.getName().equalsIgnoreCase("setshop")) {
		 if (!sender.hasPermission("justgamers.staff.setshop")){
	        	sender.sendMessage(prefix + ChatColor.RED + "You dont have the permission to teleport to the shop.");
	        }
		 Player p = (Player) sender;
		 Commandregister.setshop(p);
         return true;
 }
		 
	 if (cmd.getName().equalsIgnoreCase("shop")) {
        if (!sender.hasPermission("justgamers.member.shop")){
        	sender.sendMessage(prefix + ChatColor.RED + "You dont have the permission to teleport to the shop.");
        }
        Player p = (Player) sender;
        Commandregister.shopttp(p);
         return true;
 }
        
	 
if (cmd.getName().equalsIgnoreCase("tag")){
	Player p = (Player) sender;
	TagAPI.refreshPlayer(p);
	p.sendMessage(prefix + ChatColor.RED + "Name tag reset.");
}
	if (cmd.getName().equalsIgnoreCase("setmotd")) {
		if (!sender.hasPermission("justgamers.admin.motd")) {
			sender.sendMessage(prefix + ChatColor.RED + "You are not permitted to do this!");
			return true;
		}
		if (args.length == 0) {
			String motd = settings.getConfig().getString("motd");
			motd = motd.replaceAll("&", "§");
			sender.sendMessage(prefix + ChatColor.GREEN + "The motd now is: " + motd);
			sender.sendMessage(prefix + ChatColor.BLUE + "Please specify a message!");
			return true;
		}
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			str.append(args[i] + " ");
		}
		String motd = str.toString();
		settings.getConfig().set("motd", motd);
		settings.saveConfig();
		String server = settings.getConfig().getString("motd");
		server = server.replaceAll("&", "§");
		sender.sendMessage(ChatColor.GREEN + "MOTD set to: " + server);
		return true;
	}
	
	if(cmd.getName().equalsIgnoreCase("facebook")){
		Commandregister.facebook(sender);
		return true;
	}
	if (cmd.getName().equalsIgnoreCase("twitter")){
		Commandregister.twitter(sender);
		return true;
	}
	if (cmd.getName().equalsIgnoreCase("website")){
		Commandregister.website(sender);
		return true;
	}
	if (cmd.getName().equalsIgnoreCase("regels")){
		Commandregister.regels(sender);
		return true;
	}
	if (cmd.getName().equalsIgnoreCase("donate")){
		Commandregister.donate(sender);
		return true;
	}
	
	// Check my own warnings \\
	if ( cmd.getName().equalsIgnoreCase("mywarns")){
		if(!sender.hasPermission("justgamers.user.warns")){
			sender.sendMessage(prefix + ChatColor.RED + "You may not check your own warnings");
		}else
		if (sender instanceof Player) {
			Commandregister.mywarns(sender);
		}else
			sender.sendMessage(ChatColor.GREEN + "This command is only for ingame players.");
		return true;
	}
	
	// Check a player his warnings \\
	
	if (!sender.hasPermission("justgamers.staff.checkwarns")){
		sender.sendMessage(prefix + ChatColor.RED + "You may not check the warnings of a player");
	}else	
		if (sender instanceof Player) {
	if (cmd.getName().equalsIgnoreCase("warnings")) {
        if (args.length < 1) {
                sender.sendMessage(prefix + ChatColor.GOLD + "/warnings <player>");
                return true;
        }
       
		final Player t = Bukkit.getServer().getPlayer(args[0]);
       
        if (t == null) {
                sender.sendMessage(prefix + ChatColor.GOLD + "Could not find player " + args[0]);
                return true;
        }
        Object level1 = settings.getData().get(t.getName());
        
        int le = Integer.parseInt(level1.toString());
        if (le == 0){
        	sender.sendMessage(ChatColor.GOLD + "-----------------------------------------------------");
    		sender.sendMessage(ChatColor.GREEN + t.getName() + ChatColor.YELLOW + " Has no warnings he is a good player");
    		sender.sendMessage(ChatColor.GOLD + "-----------------------------------------------------");
    		return true;
        }
	if (le > 0){
		sender.sendMessage(ChatColor.GOLD + "-----------------------------------------------------");
		sender.sendMessage(ChatColor.GREEN + t.getName() + ChatColor.YELLOW + " Has " + ChatColor.DARK_PURPLE + settings.getData().get(t.getName()) + ChatColor.YELLOW + " Warnings");
		sender.sendMessage(ChatColor.GOLD + "-----------------------------------------------------");
	return true;
	}else
		sender.sendMessage(ChatColor.GREEN + "This command is only for online players");
	return true;
	}
	}
	
	// Warn command \\
	
	if (!sender.hasPermission("justgamers.staff.warn")){
		sender.sendMessage(prefix + ChatColor.RED + "You may not warn a player");
	}else
	if (sender instanceof Player) {
		
	if (cmd.getName().equalsIgnoreCase("warn")) {
        // Check for perms
        if (args.length < 2) {
                sender.sendMessage(prefix + ChatColor.GREEN + "/warn <player> <reason>");
                return true;
        }
       
		final Player target = Bukkit.getServer().getPlayer(args[0]);
       
        if (target == null) {
                sender.sendMessage(prefix + ChatColor.GOLD + "Could not find player " + ChatColor.RED + args[0]);
                return true;
        }
       
        String msg = "";
        for (int i = 1; i < args.length; i++) {
                msg += args[i] + " ";
        }
       
        Object level = settings.getData().get(target.getName());
       
        int l = Integer.parseInt(level.toString());
       
        if (l == 0) { //message\\
            target.sendMessage(prefix + ChatColor.BLUE + "You have Received a warning from " + ChatColor.AQUA  + sender.getName() );
            target.sendMessage(ChatColor.BLUE + "Reason: " + ChatColor.RED + msg); 
            settings.getData().set(target.getName(), 1);
            settings.saveData();
            target.sendMessage(prefix + ChatColor.BLUE + "You have now: " +
            ChatColor.RED + settings.getData().get(target.getName()) + ChatColor.YELLOW + " Warning");
            return true;
    }
        if (l == 1) { //message\\
        	target.sendMessage(prefix + ChatColor.BLUE + "You have Received a warning from " + ChatColor.AQUA  + sender.getName() );
            target.sendMessage(ChatColor.BLUE + "Reason: " + ChatColor.RED + msg); 
               settings.getData().set(target.getName(), 2);
               settings.saveData();
               target.sendMessage(prefix + ChatColor.BLUE + "You have now: " +
               ChatColor.RED + settings.getData().get(target.getName()) + ChatColor.YELLOW + " Warnings");
                return true;
        }
        if (l == 2) { //kick\\  
        	
            target.kickPlayer(prefix + ChatColor.BLUE + "You have Received a warning from " + ChatColor.AQUA  +
            		sender.getName() + ChatColor.BLUE + " And you has een kicked" + ChatColor.YELLOW + " With reason: " + ChatColor.RED + msg);
            settings.getData().set(target.getName(), 3);
            settings.saveData();
            return true;
    }
       
        if (l == 3) { //TempBan\\
        	target.kickPlayer(prefix + ChatColor.BLUE + "You have Received a warning from " + ChatColor.AQUA  +
            		sender.getName() + ChatColor.BLUE + " Reason: " + ChatColor.RED + msg + ChatColor.YELLOW +
            		" You been tempbanned for 2 hours now because you have 4 warnings");target.kickPlayer(prefix + ChatColor.BLUE + "You have Received a warning from " + ChatColor.AQUA  +
                    		sender.getName() + ChatColor.BLUE + " Reason: " + ChatColor.RED + msg + ChatColor.YELLOW +
                    		" You been tempbanned for 2 hours now because you have 4 warnings");
            		
                serverBanList.addBan(target.getName(), null, null, null);
               
                settings.getData().set(target.getName(), 4);
                settings.saveData();
                
                settings.getBans().set(target.getName(), "You been tempbanned for 2 hours with reason: " + msg);
                settings.saveBans();
                
                
                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                	@Override
                        public void run() {
                		serverBanList.pardon(target.getName());
                        }
                }, 120 * 1200);
               
                return true;
        }
        if (l == 4) { //permban\\ 
            
            target.kickPlayer(prefix + ChatColor.BLUE + "You have Received a warning from " + ChatColor.AQUA  +
            		sender.getName() + ChatColor.BLUE + "Reason: " + ChatColor.RED + msg +
            		" You been permanently banned now because you have 5 warnings");
            serverBanList.addBan(target.getName(), null, null, null);
            
            settings.getData().set(target.getName(), 5);
            settings.saveData();
            
            settings.getBans().set(target.getName(), "You has been permanently banned with reason: " + msg);
            settings.saveBans();
            return true;     
        }
        }
	
	}else
		sender.sendMessage("This command can only be used by a player");
	


	 
return true;
}


} 
