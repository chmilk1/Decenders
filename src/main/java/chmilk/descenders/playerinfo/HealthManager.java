/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.playerinfo;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class HealthManager {
    public static HashMap<UUID, PlayerStats> playerInfo;
    static void setPlayerHealthMaxHealth(Player player){
        player.getUniqueId();
    }
}
