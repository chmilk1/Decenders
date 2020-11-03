/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.loot;

import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

public class LootChest extends LootContainer {
    Chest chest;
    Location location;

    public LootChest(Chest chest) {
        this.chest = chest;
    }

    public LootChest(Location location){
        this.chest = (Chest) location.getBlock().getState();
    }

    public void addItem(ItemStack item){
        chest.getInventory().addItem(item);
    }

    public void clearItems() {
        chest.getInventory().clear();
    }

    @Override
    public String getType() {
        return "Chest";
    }

    @Override
    public Location getLocation() {
        return chest.getLocation();
    }
}
