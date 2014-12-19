package nl.justspooky.justgamers;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Crafting {

	   public static void firerecipe() {
           ItemStack fire = new ItemStack(Material.FIRE, 1);
           ItemMeta meta = fire.getItemMeta();
           meta.setDisplayName(ChatColor.GOLD + "Fire");
           meta.setLore(Arrays.asList("For crafting", "With", "Chainmail Armor."));
           fire.setItemMeta(meta);
          
           ShapedRecipe firerecipe = new ShapedRecipe(fire);
           firerecipe.shape(
                           "@# ",
                           "$  ");
           firerecipe.setIngredient('@', Material.FLINT_AND_STEEL);
           firerecipe.setIngredient('#', Material.DIAMOND);
           firerecipe.setIngredient('$', Material.IRON_INGOT);
           Bukkit.getServer().addRecipe(firerecipe);
   }
	   
}
