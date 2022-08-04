/*
 * Copyright (c) 2022 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class Kits {
    public static void giveStarter(Player player){
        player.getInventory().addItem(ItemBuilder.createWeapon(
                (player.getDisplayName() + "'s Training Sword"),null, Material.WOODEN_SWORD,5,2,false,
                new WeaponEnchantments(0,0,1,0,0,0,0,0,0,0,0,0)));

        player.getInventory().addItem(ItemBuilder.createBow(player.getDisplayName() + "'s Basic Bow" ,null,false,false,null));
        player.getInventory().addItem(new ItemStack(Material.ARROW, 12));

        player.getInventory().addItem(new ItemStack(Material.MELON, 5));

        player.getInventory().addItem(ItemBuilder.createArmour(
                "Starter Chestplate",null,Material.CHAINMAIL_CHESTPLATE,3,false,null));
        player.getInventory().addItem(ItemBuilder.createArmour(
                "Starter Leggings",null,Material.LEATHER_LEGGINGS,2,false,null));
        player.getInventory().addItem(ItemBuilder.createArmour(
                "Starter Boots",null,Material.LEATHER_BOOTS,1,false,null));
    }
}
