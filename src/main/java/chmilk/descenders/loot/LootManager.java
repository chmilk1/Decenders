/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.loot;

import chmilk.descenders.util.HistoryGenerator;
import chmilk.descenders.util.ItemBuilder;
import chmilk.descenders.util.WeaponEnchantments;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class LootManager {
    public static Random rand = new Random();
    
    public static final double ENCHANT_CHANCE = 50;
    public static final double ENCHANT_DECAY = 0.4;
    public static final double ENCHANT_WEAPON_DEBUF = 1.0;
    public static final double ENCHANT_RANGED_DEBUF = 0.7;
    public static final double ENCHANT_ARMOUR_DEBUF = 0.7;

    public static final int ENCHANT_WEAPON_LP = 10;
    public static final int ENCHANT_RANGED_LP = 15;
    public static final int ENCHANT_ARMOUR_LP = 10;

    public static ItemStack createWeapon(int lootPoints, int power){

        //deciding enchantments
        WeaponEnchantments weapEnch = new WeaponEnchantments();
        int enchantments = 0;
        boolean enchantDone = false;
        while(!enchantDone){
            if(rand.nextInt(100) < ENCHANT_CHANCE * Math.pow(ENCHANT_DECAY,1 + enchantments) * ENCHANT_WEAPON_DEBUF){
                enchantments += 1;
                lootPoints -= ENCHANT_WEAPON_LP + weapEnch.rollEnchant(rand.nextInt(100));
            } else {
                enchantDone = true;
            }
        }

        return ItemBuilder.createWeapon(
                HistoryGenerator.generateSwordHistory(weapEnch.getTrait(),"Sword", HistoryGenerator.Gender.MALE, HistoryGenerator.NameQuality.NOBLE),
                null, Material.DIAMOND_PICKAXE,6,1.5,false,weapEnch);
    }

    public static ItemStack createRanged(int lootPoints, int power){

        //deciding enchantments amount
        int enchantments = 0;
        boolean enchantDone = false;
        while(!enchantDone){
            if(rand.nextInt(100) < ENCHANT_CHANCE * Math.pow(ENCHANT_DECAY,1 + enchantments) * ENCHANT_RANGED_DEBUF){
                enchantments += 1;
                lootPoints -= ENCHANT_RANGED_LP;
            } else {
                enchantDone = true;
            }
        }

        return null;
    }

    public static ItemStack createArmour(int lootPoints, int power){
        //deciding enchantments amount
        int enchantments = 0;
        boolean enchantDone = false;
        while(!enchantDone){
            if(rand.nextInt(100) < ENCHANT_CHANCE * Math.pow(ENCHANT_DECAY,1 + enchantments) * ENCHANT_ARMOUR_DEBUF){
                enchantments += 1;
                lootPoints -= ENCHANT_ARMOUR_LP;
            } else {
                enchantDone = true;
            }
        }

        return null;
    }

    public static ItemStack createArtifact(int lootPoints, int power){
        return null;
    }

    public static ItemStack simpleLoot(int lootPoints, int power){
        return null;
    }
}
