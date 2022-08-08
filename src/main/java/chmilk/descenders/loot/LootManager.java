/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.loot;

import chmilk.descenders.util.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.data.type.Switch;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.units.qual.A;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class LootManager {
    public static Random rand = RandomContainer.rand;
    
    public static final double ENCHANT_CHANCE = 64;
    public static final double ENCHANT_DECAY = 0.7;
    public static final double ENCHANT_WEAPON_DEBUF = 1.0;
    public static final double ENCHANT_RANGED_DEBUF = 0.7;
    public static final double ENCHANT_ARMOUR_DEBUF = 0.7;
    public static final double ENCHANT_LP_CHANCE = 0.01;
    public static final double ENCHANT_LP_MAX = 1.5;

    public static final int ENCHANT_WEAPON_LP = 10;
    public static final int ENCHANT_RANGED_LP = 15;
    public static final int ENCHANT_ARMOUR_LP = 10;

    public static final double DAMAGE_BASE = 6;
    public static final double DAMAGE_AXE_MULTI = 1.5;
    public static final double DAMAGE_PICK_MULTI = 1.8;
    public static final double DAMAGE_DAGGER_MULTI = .5;
    public static final double DAMAGE_SPADE_MULTI = 1.25;
    public static final double DAMAGE_LP_CONVERT = 55;

    public static final double DAMAGE_GOLD = 1.4;
    public static final double DAMAGE_DIAMOND = 1.2;

    public static final double SWING_BASE = 1.5;
    public static final double SWING_AXE_MULTI = 0.6;
    public static final double SWING_PICK_MULTI = 0.4;
    public static final double SWING_DAGGER_MULTI = 3;
    public static final double SWING_SPADE_MULTI = .75;
    public static final double SWING_LP_CONVERT = 125;

    public static final double SWING_WOOD = .95;

    public static final int SIMPLELOOT_GOLDLP = 2;
    public static final int SIMPLELOOT_FOODPERLP = 24;
    public static final double SIMPLELOOT_FOOD_BREAD = 1;
    public static final double SIMPLELOOT_FOOD_MELLON = .6;
    public static final double SIMPLELOOT_FOOD_STEAK = 2;
    public static final double SIMPLELOOT_FOOD_PORK = 2;
    public static final double SIMPLELOOT_FOOD_APPLE = 1;

    public static ItemStack createWeapon(int lootPoints, int power){

        String rarity = rarityChatTags(lootPoints);
        //TODO: remove debug flag for mem optimization
        ArrayList<String> lore = null;
        if(GlobalFlags.LOOTPOINTS_DEBUG){
            lore = new ArrayList<String>();
            lore.add("LP: "+lootPoints);
        }

        //deciding enchantments
        WeaponEnchantments weapEnch = new WeaponEnchantments();
        int enchantments = 0;
        boolean enchantDone = false;
        while(!enchantDone && lootPoints > 0){
            if(rand.nextInt(100) < ENCHANT_CHANCE * Math.pow(ENCHANT_DECAY,enchantments) * ENCHANT_WEAPON_DEBUF * Math.min(lootPoints * ENCHANT_LP_CHANCE,ENCHANT_LP_MAX)){
                enchantments += 1;
                lootPoints -= ENCHANT_WEAPON_LP + weapEnch.rollEnchant(rand.nextInt(100));
            } else {
                enchantDone = true;
            }
        }

        //

        //weapon types
        double damage = DAMAGE_BASE;
        double swing = SWING_BASE;
        Material mat = Material.WOODEN_SWORD;
        String weaponType = "";

        int type = rand.nextInt(6);
        if(type < 2){
            //weapon is a sword
            weaponType = HistoryGenerator.getWeapType(HistoryGenerator.WeaponType.SWORD);

            int matRand = rand.nextInt(5);
            switch (matRand){
                case 0:
                    mat = Material.IRON_SWORD;
                    break;
                case 1:
                    mat = Material.GOLDEN_SWORD;
                    lootPoints = (int) (lootPoints * 0.5);
                    damage*=DAMAGE_GOLD;
                    break;
                case 2:
                    mat = Material.DIAMOND_SWORD;
                    lootPoints = (int) (lootPoints * 0.65);
                    damage*=DAMAGE_DIAMOND;
                    break;
                case 3:
                    mat = Material.WOODEN_SWORD;
                    swing*=SWING_WOOD;
                    break;
                case 4:
                    mat = Material.STONE_SWORD;
                    break;
            }

        } else if(type == 2) {
            //weapon is a dagger
            weaponType = HistoryGenerator.getWeapType(HistoryGenerator.WeaponType.DAGGER);
            damage *= DAMAGE_DAGGER_MULTI;
            swing *= SWING_DAGGER_MULTI;

            int matRand = rand.nextInt(5);
            switch (matRand){
                case 0:
                    mat = Material.IRON_HOE;
                    break;
                case 1:
                    mat = Material.GOLDEN_HOE;
                    lootPoints = (int) (lootPoints * 0.5);
                    damage*=DAMAGE_GOLD;
                    break;
                case 2:
                    mat = Material.DIAMOND_HOE;
                    lootPoints = (int) (lootPoints * 0.65);
                    damage*=DAMAGE_DIAMOND;
                    break;
                case 3:
                    mat = Material.WOODEN_HOE;
                    swing*=SWING_WOOD;
                    break;
                case 4:
                    mat = Material.STONE_HOE;
                    break;
            }

        } else if(type == 3) {
            //weapon is a pick
            weaponType = HistoryGenerator.getWeapType(HistoryGenerator.WeaponType.PICK);
            damage *= DAMAGE_PICK_MULTI;
            swing *= SWING_PICK_MULTI;

            int matRand = rand.nextInt(5);
            switch (matRand){
                case 0:
                    mat = Material.IRON_PICKAXE;
                    break;
                case 1:
                    mat = Material.GOLDEN_PICKAXE;
                    lootPoints = (int) (lootPoints * 0.5);
                    damage*=DAMAGE_GOLD;
                    break;
                case 2:
                    mat = Material.DIAMOND_PICKAXE;
                    lootPoints = (int) (lootPoints * 0.65);
                    damage*=DAMAGE_DIAMOND;
                    break;
                case 3:
                    mat = Material.WOODEN_PICKAXE;
                    swing*=SWING_WOOD;
                    break;
                case 4:
                    mat = Material.STONE_PICKAXE;
                    break;
            }
        } else if(type == 4) {
            //weapon is a axe
            weaponType = HistoryGenerator.getWeapType(HistoryGenerator.WeaponType.AXE);
            damage *= DAMAGE_AXE_MULTI;
            swing *= SWING_AXE_MULTI;

            int matRand = rand.nextInt(5);
            switch (matRand){
                case 0:
                    mat = Material.IRON_AXE;
                    break;
                case 1:
                    mat = Material.GOLDEN_AXE;
                    lootPoints = (int) (lootPoints * 0.5);
                    damage*=DAMAGE_GOLD;
                    break;
                case 2:
                    mat = Material.DIAMOND_AXE;
                    lootPoints = (int) (lootPoints * 0.65);
                    damage*=DAMAGE_DIAMOND;
                    break;
                case 3:
                    mat = Material.WOODEN_AXE;
                    swing*=SWING_WOOD;
                    break;
                case 4:
                    mat = Material.STONE_AXE;
                    break;
            }
        } else if(type == 5) {
            //weapon is a spade
            weaponType = HistoryGenerator.getWeapType(HistoryGenerator.WeaponType.SPADE);
            damage *= DAMAGE_SPADE_MULTI;
            swing *= SWING_SPADE_MULTI;

            int matRand = rand.nextInt(5);
            switch (matRand){
                case 0:
                    mat = Material.IRON_SHOVEL;
                    break;
                case 1:
                    mat = Material.GOLDEN_SHOVEL;
                    damage*=DAMAGE_GOLD;
                    lootPoints = (int) (lootPoints * 0.5);
                    break;
                case 2:
                    mat = Material.DIAMOND_SHOVEL;
                    damage*=DAMAGE_DIAMOND;
                    lootPoints = (int) (lootPoints * 0.65);
                    break;
                case 3:
                    mat = Material.WOODEN_SHOVEL;
                    swing*=SWING_WOOD;
                    break;
                case 4:
                    mat = Material.STONE_SHOVEL;
                    break;
            }
        }

        if (lootPoints > 0) {
            int damageLP = (int) (lootPoints * rand.nextDouble());
            lootPoints -= damageLP;
            damage += ((damageLP) / DAMAGE_LP_CONVERT);
            swing += lootPoints / SWING_LP_CONVERT;
        }
        damage = Math.round(damage);
        swing = Math.round(swing*10d)/10d;

        return ItemBuilder.createWeapon(
                rarity + HistoryGenerator.generateSwordHistory(weapEnch.getTrait(),weaponType, HistoryGenerator.Gender.MALE, HistoryGenerator.NameQuality.NOBLE),
                lore, mat,damage,swing,false,weapEnch);
    }

    public static ItemStack createRanged(int lootPoints, int power){
        return ItemBuilder.createBow("LP:" + lootPoints,null,false,false,null);
    }

    public static ItemStack createArmour(int lootPoints, int power){
        return ItemBuilder.createArmour("LP:" + lootPoints,
                null,Material.LEATHER_BOOTS,4,false,null);
    }

    public static ItemStack createArtifact(int lootPoints, int power){
        return new ItemStack(Material.DIAMOND);
    }

    public static ItemStack simpleLoot(int lootPoints, int power){
        switch (rand.nextInt(3)){
            case 0: //gold
            case 1:
                if(lootPoints < 9 * SIMPLELOOT_GOLDLP){
                    return new ItemStack(Material.GOLD_NUGGET,(lootPoints/SIMPLELOOT_GOLDLP));
                } else {
                    return new ItemStack(Material.GOLD_INGOT,(lootPoints/SIMPLELOOT_GOLDLP/9));
                }
            case 2: //food
                switch (rand.nextInt(5)){
                    case 0: //bread
                        return new ItemStack(Material.BREAD,(int)(lootPoints/SIMPLELOOT_FOODPERLP/SIMPLELOOT_FOOD_BREAD));
                    case 1: //mellon
                        return new ItemStack(Material.MELON_SLICE,(int)(lootPoints/SIMPLELOOT_FOODPERLP/SIMPLELOOT_FOOD_MELLON));
                    case 2: //apple
                        return new ItemStack(Material.APPLE,(int)(lootPoints/SIMPLELOOT_FOODPERLP/SIMPLELOOT_FOOD_APPLE));
                    case 3: //steak
                        return new ItemStack(Material.COOKED_BEEF,(int)(lootPoints/SIMPLELOOT_FOODPERLP/SIMPLELOOT_FOOD_STEAK));
                    case 4: //pork
                        return new ItemStack(Material.COOKED_PORKCHOP,(int)(lootPoints/SIMPLELOOT_FOODPERLP/SIMPLELOOT_FOOD_PORK));
                }
        }
        return new ItemStack(Material.GOLD_INGOT,1);
    }

    public static final int RARITY_UNCOMMON = 60;
    public static final int RARITY_RARE = 125;
    public static final int RARITY_EPIC = 150;

    public static String rarityChatTags(int lootPoints){
        if(lootPoints > RARITY_EPIC){
            return ChatColor.RESET + "" + ChatColor.RED;
        } else if(lootPoints > RARITY_RARE){
            return ChatColor.RESET + "" + ChatColor.GOLD;
        } else if(lootPoints > RARITY_UNCOMMON){
            return ChatColor.RESET + "" + ChatColor.AQUA;
        } else {
            return ChatColor.RESET.toString() + ChatColor.WHITE;
        }
    }
}
