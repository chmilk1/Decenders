/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.loot;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class LootManager {
    public static ItemStack createWeapon(int lootPoints, int power){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("God-slayer");
        AttributeModifier attackDmg = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 2.0, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        AttributeModifier attackSpeed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -3.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier attackKb = new AttributeModifier(UUID.randomUUID(), "generic.attackKnockback", 3.0, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attackDmg);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackSpeed);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, attackKb);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createArmour(int lootPoints, int power){
        return null;
    }

    public static ItemStack createArtifact(int lootPoints, int power){
        return null;
    }

    public static ItemStack simpleLoot(int lootPoints, int power){
        return null;
    }
}
