/*
 * Copyright (c) 2022 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.util;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class WeaponEnchantments{
    int mend; //Mending
    int unbreaking; //Unbreaking
    int unbreakable; //Applies the Unbreakable type

    int vanish; //Curse of Vanishing

    int fire; //Fire Aspect
    int baneofarth; //Bane of Arthropods
    int knock; //Knockback
    int sharp; //Sharpness
    int smite; //Smite
    int sweep; //Sweeping Edge

    int poision;
    int withering;

    public WeaponEnchantments(int mend, int unbreaking, int unbreakable, int vanish, int fire, int baneofarth, int knock, int sharp, int smite, int sweep, int poision, int withering) {
        this.mend = mend;
        this.unbreaking = unbreaking;
        this.unbreakable = unbreakable;
        this.vanish = vanish;
        this.fire = fire;
        this.baneofarth = baneofarth;
        this.knock = knock;
        this.sharp = sharp;
        this.smite = smite;
        this.sweep = sweep;
        this.poision = poision;
        this.withering = withering;
    }

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

        //melee
        if(fire > 0){
            meta.addEnchant(Enchantment.FIRE_ASPECT, fire, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Fire Aspect " + fire);
        }
        if(baneofarth > 0){
            meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, baneofarth, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Bane of Arthropods " + baneofarth);
        }
        if(knock > 0){
            meta.addEnchant(Enchantment.KNOCKBACK, knock, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Knockback " + knock);
        }
        if(sharp > 0){
            meta.addEnchant(Enchantment.DAMAGE_ALL, sharp, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Sharpness " + sharp);
        }
        if(smite > 0){
            meta.addEnchant(Enchantment.DAMAGE_UNDEAD, smite, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Smite " + smite);
        }
        if(sweep > 0){
            meta.addEnchant(Enchantment.KNOCKBACK, sweep, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Sweeping " + sweep);
        }
    }
}
