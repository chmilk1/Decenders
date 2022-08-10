/*
 * Copyright (c) 2022 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockHandler implements Listener {

    @EventHandler
    public void blockBreak(BlockBreakEvent event){
        if(!(event.getPlayer().getGameMode().equals(GameMode.CREATIVE) // || event.getPlayer().isOp()
        )){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void blockPlace(BlockPlaceEvent event){
        if(!(event.getPlayer().getGameMode().equals(GameMode.CREATIVE) // || event.getPlayer().isOp()
        )){
            event.setCancelled(true);
        }
    }
}
