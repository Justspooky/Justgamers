package nl.justspooky.justgamers;

import java.io.File;
import java.io.IOException;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
 
public class SettingsManager {
 
        private SettingsManager() { }
       
        static SettingsManager instance = new SettingsManager();
       
        public static SettingsManager getInstance() {
                return instance;
        }
       
        Plugin p;
       
        FileConfiguration config;
        File cfile;
       
        FileConfiguration warnings;
        File dfile;
        
        FileConfiguration bans;
        File bfile;
       
        public void setup(Plugin p) {
                cfile = new File(p.getDataFolder(), "config.yml");
                config = p.getConfig();
                config.options().copyDefaults(true);
                saveConfig();
               
                if (!p.getDataFolder().exists()) {
                        p.getDataFolder().mkdir();
                }
               
                dfile = new File(p.getDataFolder(), "warnings.yml");
               
               
                
                if (!dfile.exists()) {
                        try {
                                dfile.createNewFile();
                        }
                        catch (IOException e) {
                                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create warnings.yml!");
                        }
                }
               
                warnings = YamlConfiguration.loadConfiguration(dfile);
        
                
                // ban file
                bfile = new File(p.getDataFolder(), "bans.yml");
                
                if (!bfile.exists()) {
                        try {
                                bfile.createNewFile();
                        }
                        catch (IOException e) {
                                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create bans.yml!");
                        }
                }
               
                bans = YamlConfiguration.loadConfiguration(bfile);
}
       
        public FileConfiguration getData() {
                return warnings;
        }
       
        public void saveData() {
                try {
                	warnings.save(dfile);
                }
                catch (IOException e) {
                        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save warnings.yml!");
                }
        }
       
        public void reloadData() {
        	warnings = YamlConfiguration.loadConfiguration(dfile);
        }
       
        
        public FileConfiguration getConfig() {
                return config;
        }
       
        public void saveConfig() {
                try {
                        config.save(cfile);
                }
                catch (IOException e) {
                        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
                }
        }
       
        public void reloadConfig() {
                config = YamlConfiguration.loadConfiguration(cfile);
        }
       
        public PluginDescriptionFile getDesc() {
                return p.getDescription();
        }
        
     // bans
        public FileConfiguration getBans() {
            return bans;
    }
   
    public void saveBans() {
            try {
            	bans.save(bfile);
            }
            catch (IOException e) {
                    Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save bans.yml!");
            }
    }
   
    public void reloadBans() {
    	bans = YamlConfiguration.loadConfiguration(bfile);
    }
   
}