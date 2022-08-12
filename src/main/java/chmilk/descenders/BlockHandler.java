/*
 * Copyright (c) 2022 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders;

import chmilk.descenders.util.RandomContainer;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockHandler implements Listener {

    @EventHandler
    public void blockBreak(BlockBreakEvent event){
        if(!(event.getPlayer().getGameMode().equals(GameMode.CREATIVE) // || event.getPlayer().isOp()
        )){
            if(isOre(event.getBlock().getType())){
                for(ItemStack is : event.getBlock().getDrops(event.getPlayer().getItemInUse())){
                    if(RandomContainer.rand.nextBoolean()){
                        event.getPlayer().getInventory().addItem(is);
                    }
                    event.getPlayer().getInventory().addItem(is);
                }
                event.getBlock().setType(Material.BEDROCK);
            }
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void blockPlace(BlockPlaceEvent event){
        if(!(event.getPlayer().getGameMode().equals(GameMode.CREATIVE) || event.getPlayer().isOp()
        )){
            event.setCancelled(true);
        }
    }

    public boolean isOre(Material mat){
        switch (mat){
            case COAL_ORE:
            case COPPER_ORE:
            case DIAMOND_ORE:
            case EMERALD_ORE:
            case GOLD_ORE:
            case IRON_ORE:
            case LAPIS_ORE:
            case REDSTONE_ORE:
//            case DEEPSLATE_COAL_ORE:
//            case DEEPSLATE_COPPER_ORE:
//            case DEEPSLATE_DIAMOND_ORE:
//            case DEEPSLATE_EMERALD_ORE:
//            case DEEPSLATE_GOLD_ORE:
//            case DEEPSLATE_IRON_ORE:
//            case DEEPSLATE_LAPIS_ORE:
//            case DEEPSLATE_REDSTONE_ORE:
                return true;
        }
        return false;
    }
}
