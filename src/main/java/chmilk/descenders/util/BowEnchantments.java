/*
 * Copyright (c) 2022 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.util;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class BowEnchantments {

    int mend; //Mending
    int unbreaking; //Unbreaking
    int unbreakable; //Applies the Unbreakable type

    int vanish; //Curse of Vanishing

    int flame; //Flame
    int inf; //Infinity
    int multi; //Multishot
    int pierce; //Piercing
    int power; //Power
    int punch; //Punch
    int qc; //Quick Charge

    public void applyEnchants(ItemMeta meta, List<String> lore){
        //general
        if(mend > 0){
            meta.addEnchant(Enchantment.MENDING, mend, true);
            lore.add(ChatColor.RESET + "" + ChatColor.GOLD + "Mending");
        }
        if(unbreaking > 0){
            meta.addEnchant(Enchantment.DURABILITY, unbreaking, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Unbreaking " +unbreaking);
        }
        if(unbreakable > 0){
            meta.setUnbreakable(true);
            lore.add(ChatColor.RESET + "" + ChatColor.GOLD + "Unbreakable");
        }

        //curses
        if(vanish > 0){
            meta.addEnchant(Enchantment.VANISHING_CURSE, vanish, true);
            lore.add(ChatColor.RESET + "" + ChatColor.RED + "Curse of Vanishing");
        }

        //bow
        if(flame > 0){
            meta.addEnchant(Enchantment.ARROW_FIRE, flame, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Flame " +flame);
        }
        if(inf > 0){
            meta.addEnchant(Enchantment.ARROW_INFINITE, inf, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Infinity");
        }
        if(multi > 0){
            meta.addEnchant(Enchantment.MULTISHOT, multi, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Multishot");
        }
        if(pierce > 0){
            meta.addEnchant(Enchantment.PIERCING, pierce, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Piercing" + pierce);
        }
        if(power > 0){
            meta.addEnchant(Enchantment.PIERCING, power, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Power "+ power);
        }
        if(punch > 0){
            meta.addEnchant(Enchantment.ARROW_KNOCKBACK, punch, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Punch "+ punch);
        }
        if(punch > 0){
            meta.addEnchant(Enchantment.ARROW_KNOCKBACK, qc, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Quick Charge "+ qc);
        }

    }
}
