/*
 * Copyright (c) 2022 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Kits {
    public static void giveStarter(Player player){
        player.getInventory().addItem(ItemBuilder.createWeapon(
                (player.getDisplayName() + "'s Starter Axe"),null, Material.WOODEN_AXE,5,2,false,
                new WeaponEnchantments(0,0,1,0,0,0,0,0,0,0,0,0)))
    }
}
