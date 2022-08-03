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
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        if(lore == null){
            lore = new ArrayList<String>();
        }
        meta.setDisplayName(ChatColor.RESET + Name);

        if(enchanted){
            meta.addEnchant(Enchantment.LUCK,1, true);
        }

        AttributeModifier attackDmgA = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", attackDmg-1, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attackDmgA);
        lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Attack Damage " + attackDmg);

        AttributeModifier attackSpeedA = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", (1/4)*attackSpeed, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackSpeedA);
        lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Attack Speed " + attackSpeed);

//        AttributeModifier attackKbA = new AttributeModifier(UUID.randomUUID(), "generic.attackKnockback", knockback, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
//        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, attackKbA);
//        if(knockback > 1){
//            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW +"Knockback  " + knockback*100 + "%");
//        }

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
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
        }
        meta.setDisplayName(ChatColor.RESET + Name);

        if(enchanted){
            meta.addEnchant(Enchantment.LUCK,1, true);
        }

        if(returning){
            meta.addEnchant(Enchantment.LOYALTY, 1, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Loyalty");
        }

        AttributeModifier attackDmgA = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", attackDmg-1, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attackDmgA);
        lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Attack Damage " + attackDmg);

        AttributeModifier attackSpeedA = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", (1/4)*attackSpeed, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackSpeedA);
        lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Attack Speed " + attackSpeed);

//        AttributeModifier attackKbA = new AttributeModifier(UUID.randomUUID(), "generic.attackKnockback", knockback, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
//        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, attackKbA);
//        if(knockback > 1){
//            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW +"Knockback  " + knockback*100 + "%");
//        }

        meta.setLore(lore);
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

class WeaponEnchantments{
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
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Mending");
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
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Curse of Vanishing");
        }

        //melee expected
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
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Smite " + sweep);
        }
    }
}