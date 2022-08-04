/*
 * Copyright (c) 2022 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemBuilder {

    /**
     * This is the main method which makes use of addNum method.
     * @param Name Item Name
     * @param lore Flavor Text for an item
     * @param mat Material for the weapon
     * @param attackDmg Attack Damage in hearts
     * @param attackSpeed Attack Speed in swinds per second
     * @param enchanted makes a tool shiny!
     * @return The completed item.
     */
    public static ItemStack createWeapon(String Name, List<String> lore, Material mat, double attackDmg, double attackSpeed, boolean enchanted){
        return createWeapon(Name, lore, mat, attackDmg, attackSpeed, enchanted, null);
    }

    /**
     * This is the main method which makes use of addNum method.
     * @param Name Item Name
     * @param lore Flavor Text for an item
     * @param mat Material for the weapon
     * @param attackDmg Attack Damage in hearts
     * @param attackSpeed Attack Speed in swinds per second
     * @param enchanted makes a tool shiny!
     * @param enchant weap enchant class for fine tuned controll
     * @return The completed item.
     */
    public static ItemStack createWeapon(String Name, List<String> lore, Material mat, double attackDmg, double attackSpeed, boolean enchanted, WeaponEnchantments enchant){
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        if(lore == null){
            lore = new ArrayList<String>();
        } else {
            lore.add("");
        }
        meta.setDisplayName(ChatColor.RESET + Name);

        if(enchanted){
            meta.addEnchant(Enchantment.LUCK,1, true);
        }

        if(enchant != null){
            enchant.applyEnchants(meta, lore);
        }

        AttributeModifier attackDmgA = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", attackDmg-1, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
        lore.add(ChatColor.RESET + "" + ChatColor.BLUE + "Attack Damage " + attackDmg);

        AttributeModifier attackSpeedA = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", attackSpeed-4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        lore.add(ChatColor.RESET + "" + ChatColor.BLUE + "Attack Speed " + attackSpeed);

//        AttributeModifier attackKbA = new AttributeModifier(UUID.randomUUID(), "generic.attackKnockback", knockback, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
//        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, attackKbA);
//        if(knockback > 1){
//            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW +"Knockback  " + knockback*100 + "%");
//        }

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attackDmgA);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackSpeedA);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * This is the main method which makes use of addNum method.
     * @param Name Item Name
     * @param lore Flavor Text for an item
     * @param attackDmg Attack Damage in hearts
     * @param attackSpeed Attack Speed in swinds per second
     * @param enchanted makes a tool shiny!
     * @param returning adds the loyalty enchantment
     * @return The completed item.
     */
    public static ItemStack createTrident(String Name, List<String> lore, double attackDmg, double attackSpeed, boolean enchanted, boolean returning){
        ItemStack item = new ItemStack(Material.TRIDENT);
        ItemMeta meta = item.getItemMeta();
        if(lore == null){
            lore = new ArrayList<String>();
        } else {
            lore.add("");
        }
        meta.setDisplayName(ChatColor.RESET + Name);

        if(enchanted){
            meta.addEnchant(Enchantment.LUCK,1, true);
        }

        if(returning){
            meta.addEnchant(Enchantment.LOYALTY, 1, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Loyalty");
        }

        AttributeModifier attackDmgA = new AttributeModifier("generic.attackDamage", attackDmg-1, AttributeModifier.Operation.MULTIPLY_SCALAR_1);
        lore.add(ChatColor.RESET + "" + ChatColor.BLUE + "Attack Damage " + attackDmg);

        AttributeModifier attackSpeedA = new AttributeModifier("generic.attackSpeed", attackSpeed-4, AttributeModifier.Operation.ADD_NUMBER);
        lore.add(ChatColor.RESET + "" + ChatColor.BLUE + "Attack Speed " + attackSpeed);

//        AttributeModifier attackKbA = new AttributeModifier(UUID.randomUUID(), "generic.attackKnockback", knockback, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
//        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, attackKbA);
//        if(knockback > 1){
//            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW +"Knockback  " + knockback*100 + "%");
//        }

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attackDmgA);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackSpeedA);
        item.setItemMeta(meta);
        return item;
    }


    /**
     * This is the main method which makes use of addNum method.
     * @param Name Item Name
     * @param lore Flavor Text for an item
     * @param mat The mat of the armour
     * @param armour The armour value of this piece
     * @param enchanted makes a tool shiny!
     * @param enchant adds the enchantments that you want
     * @return The completed item.
     */
    public static ItemStack createArmour(String Name, List<String> lore, Material mat, double armour, boolean enchanted, ArmourEnchantments enchant){
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        if(lore == null){
            lore = new ArrayList<String>();
        } else {
            lore.add("");
        }
        meta.setDisplayName(ChatColor.RESET + Name);

        if(enchanted){
            meta.addEnchant(Enchantment.LUCK,1, true);
        }

        if(enchant != null){
            enchant.applyEnchants(meta, lore);
        }

        AttributeModifier armourA = new AttributeModifier("generic.armour", armour, AttributeModifier.Operation.MULTIPLY_SCALAR_1);
        lore.add(ChatColor.RESET + "" + ChatColor.BLUE + armour + " Armour Points");

        meta.setLore(lore);
        //meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armourA);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createArtifact(){
        return null;
    }

    public static ItemStack simpleLoot(){
        return null;
    }
}

