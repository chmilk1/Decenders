/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.loot;

import chmilk.descenders.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class LootManager {
    public static ItemStack createWeapon(int lootPoints, int power){
        return ItemBuilder.createWeapon("God-Slayer", null, Material.IRON_AXE, 200, 3, 50, true, true);
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
