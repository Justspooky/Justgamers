package nl.justspooky.justgamers.cmdoverride;

import nl.justspooky.justgamers.Commandregister;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class RulesCMD implements Listener {

	@EventHandler(priority=EventPriority.HIGHEST)
	public void onCommandPreProcess(PlayerCommandPreprocessEvent e)
	{
		if (e.getMessage().equalsIgnoreCase("/rules") || e.getMessage().equalsIgnoreCase("rules")){
			Commandregister.rules(e.getPlayer());
				e.setCancelled(true);
			}
		}
}

