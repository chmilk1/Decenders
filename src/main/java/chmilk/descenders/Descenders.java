/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders;

import chmilk.descenders.loot.LootBarrel;
import chmilk.descenders.loot.LootChest;
import org.bukkit.Material;
import org.bukkit.block.Barrel;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Descenders extends JavaPlugin {

    HashMap<String, Dungeon> dungeons = new HashMap<>();

    static String TEST_DUNGEON = "test";

    @Override
    public  void onEnable(){
        dungeons.put(TEST_DUNGEON, new Dungeon(getServer().getWorld("world"),
                TEST_DUNGEON,
                "Test Dungeon",
                "A dungeon for testing"));

        for (Dungeon dungeon:
             dungeons.values()) {
            dungeon.load();
        }
    }

    @Override
    public  void onDisable(){
        for (Dungeon dungeon:
                dungeons.values()) {
            dungeon.save();
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (label.equalsIgnoreCase("fillchest") && sender.isOp()) {
                if(player.getTargetBlock(null,5).getBlockData().getMaterial().equals(Material.CHEST)){
                    LootChest lc = new LootChest((Chest) player.getTargetBlock(null,5).getState());
                    lc.addLoot(1);
                    return true;
                } else if (player.getTargetBlock(null, 5).getBlockData().getMaterial().equals(Material.BARREL)){
                    LootBarrel lc = new LootBarrel((Barrel) player.getTargetBlock(null,5).getState());
                    lc.addLoot(1);
                    return true;
                }
                sender.sendMessage("invalid block type");
                return true;

            } else if (label.equalsIgnoreCase("emptychest") && sender.isOp()) {
                if(player.getTargetBlock(null,5).getBlockData().getMaterial().equals(Material.CHEST)){
                    LootBarrel lc = new LootBarrel((Barrel) player.getTargetBlock(null,5).getState());
                    lc.clearItems();
                    return true;
                } else if (player.getTargetBlock(null, 5).getBlockData().getMaterial().equals(Material.BARREL)){

                }
                sender.sendMessage("invalid block type");
                return true;
            } else if (label.equalsIgnoreCase("addChest") && sender.isOp()){
                if(args.length > 0) {
                    if (player.getTargetBlock(null, 5).getBlockData().getMaterial().equals(Material.CHEST)) {
                        dungeons.get(args[0]).addSpot(new LootChest((Chest) player.getTargetBlock(null, 5).getState()));
                        return true;
                    } else if (player.getTargetBlock(null, 5).getBlockData().getMaterial().equals(Material.BARREL)){

                    }
                    sender.sendMessage("invalid block type");
                    return true;
                }
                sender.sendMessage("not enough arguments, add dungeon name.");
                return true;
            } else if (label.equalsIgnoreCase("removeChest") && sender.isOp()){
                if(args.length > 0) {
                    if (player.getTargetBlock(null, 5).getBlockData().getMaterial().equals(Material.CHEST)) {
                        dungeons.get(args[0]).addSpot(new LootChest((Chest) player.getTargetBlock(null, 5).getState()));
                        return true;
                    } else if (player.getTargetBlock(null, 5).getBlockData().getMaterial().equals(Material.BARREL)){

                    }
                    sender.sendMessage("invalid block type");
                    return true;
                }
                sender.sendMessage("not enough arguments, add dungeon name.");
                return true;
            }
        } else if(label.equalsIgnoreCase("printLootSpots") && sender.isOp()) {
            if(args.length > 0) {
                dungeons.get(args[0]).printLootSpots(sender);
                return true;
            }
        } else if(label.equalsIgnoreCase("fillLootSpots") && sender.isOp()) {
            if(args.length > 0) {
                dungeons.get(args[0]).addLoot();
                return true;
            }
        } else if(label.equalsIgnoreCase("emptyLootSpots") && sender.isOp()) {
            if(args.length > 0) {
                dungeons.get(args[0]).clearLoot();
                return true;
            }
        } else if(label.equalsIgnoreCase("saveDungeon") && sender.isOp()) {
            if(args.length > 0) {
                dungeons.get(args[0]).save();
                return true;
            }
        }
        return false;
    }
}
