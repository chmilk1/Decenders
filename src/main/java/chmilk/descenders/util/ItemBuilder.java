/*
 * Copyright (c) 2022 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.util;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.UUID;

public class ItemBuilder {
    public static ItemStack createWeapon(String Name, List<String> lore, double attackDmg, double attackSpeed, double knockback){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("God-slayer");
        meta.setLore(lore);
        AttributeModifier attackDmgA = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 2.0, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        AttributeModifier attackSpeedA = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -3.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier attackKbA = new AttributeModifier(UUID.randomUUID(), "generic.attackKnockback", 3.0, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attackDmgA);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackSpeedA);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, attackKbA);
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
