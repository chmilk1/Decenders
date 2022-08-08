/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.loot;

import chmilk.descenders.util.RandomContainer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public abstract class LootContainer extends Loot {

    public static Random rand = RandomContainer.rand;

    public static final int LOOTPOINTS_DEFAULT_MAX = 120;
    public static final double LOOTPOINTS_RARITY_MULTIPLIER = 1.5;

    abstract public void addItem(ItemStack item);

    @Override
    public int addLoot(int lootPoints){
        int localLP;
        int type = 0;
        while(lootPoints > 10){
            localLP = rand.nextInt(Math.min(LOOTPOINTS_DEFAULT_MAX,lootPoints));
            for(int i = 0; i < 3; i++){
                if(rand.nextBoolean()){
                    localLP = (int) (localLP * LOOTPOINTS_RARITY_MULTIPLIER);
                }
            }
            type = rand.nextInt(7);

            if(type < 2){
                addItem(LootManager.createWeapon(localLP,0));
            } else if(type == 2) {
                addItem(LootManager.createArmour(localLP,0));
            } else if(type == 3) {
                addItem(LootManager.createRanged(localLP,0));
            } else if(type == 4) {
                addItem(LootManager.createArtifact(localLP,0));
            } else {
                addItem(LootManager.simpleLoot(localLP,0));
            }

            lootPoints -= localLP;
        }
        return 0;
    }
}
