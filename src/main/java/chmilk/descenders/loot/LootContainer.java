/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.loot;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class LootContainer extends Loot {
    abstract public void addItem(ItemStack item);

    @Override
    public int addLoot(int lootPoints){
        addItem(LootManager.createWeapon(0,0));
        return 0;
    }
}
