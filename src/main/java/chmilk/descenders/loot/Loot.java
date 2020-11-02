/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.loot;

import org.bukkit.Location;

public abstract class Loot {
    String type;
    public abstract Location getLocation();
    public abstract int addLoot(int lootPoints);
    public abstract void clearItems();

    public boolean isSameLocation(Loot loot){
        return getLocation().equals(loot.getLocation());
    }

    @Override
    public String toString() {
        return type + " " + getLocation().toString();
    }
}
