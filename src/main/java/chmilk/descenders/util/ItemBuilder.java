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
     * @param knockback Knockback Modifier (Scalar)
     * @param unbreakable makes a tool unbreakable
     * @param enchanted makes a tool shiny!
     * @return The completed item.
     */
    public static ItemStack createWeapon(String Name, List<String> lore, Material mat, double attackDmg, double attackSpeed, double knockback, boolean unbreakable, boolean enchanted){
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        if(lore == null){
            lore = new ArrayList<String>();
        }
        meta.setDisplayName(ChatColor.RESET + Name);

        if(enchanted){
            meta.addEnchant(Enchantment.LUCK,1, true);
        }

        AttributeModifier attackDmgA = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", attackDmg, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attackDmgA);
        lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Attack Damage " + attackDmg);

        AttributeModifier attackSpeedA = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", (1/4)*attackSpeed, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackSpeedA);
        lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Attack Speed " + attackSpeed);

        AttributeModifier attackKbA = new AttributeModifier(UUID.randomUUID(), "generic.attackKnockback", knockback, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, attackKbA);
        if(knockback > 1){
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW +"Knockback  " + knockback*100 + "%");
        }

        meta.setLore(lore);
        meta.setUnbreakable(unbreakable);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createArmour(){
        return null;
    }

    public static ItemStack createArtifact(){
        return null;
    }

    public static ItemStack simpleLoot(){
        return null;
    }
}
