/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.loot;

import org.bukkit.Location;
import org.bukkit.block.Barrel;
import org.bukkit.inventory.ItemStack;

public class LootBarrel extends LootContainer {
    Barrel barrel;
    Location location;

    @Override
    public String getType() {
        return "Barrel";
    }

    public LootBarrel(Barrel barrel) {
        this.barrel = barrel;
    }

    public LootBarrel(Location location){
        this.barrel = (Barrel) location.getBlock().getState();
    }

    public void addItem(ItemStack item){
        barrel.getInventory().addItem(item);
    }

    public void clearItems() {
        barrel.getInventory().clear();
    }

    @Override
    public Location getLocation() {
        return barrel.getLocation();
    }
}
