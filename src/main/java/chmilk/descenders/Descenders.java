/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders;

import chmilk.descenders.loot.LootBarrel;
import chmilk.descenders.loot.LootChest;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Barrel;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Descenders extends JavaPlugin {

    public static Plugin plugin;

    HashMap<String, Dungeon> dungeons = new HashMap<>();

    static String TEST_DUNGEON = "test";

    @Override
    public  void onEnable(){
        plugin = this;

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
            /*
            fills a single chest with loot
             */
            if (label.equalsIgnoreCase("fillchest") && sender.isOp()) {
                if(player.getTargetBlock(null,5).getBlockData().getMaterial().equals(Material.CHEST)){
                    LootChest lc = new LootChest((Chest) player.getTargetBlock(null,5).getState());
                    lc.addLoot(1);
                    sender.sendMessage(ChatColor.YELLOW + "Chest filled");
                    return true;
                } else if (player.getTargetBlock(null, 5).getBlockData().getMaterial().equals(Material.BARREL)){
                    LootBarrel lc = new LootBarrel((Barrel) player.getTargetBlock(null,5).getState());
                    lc.addLoot(1);
                    sender.sendMessage(ChatColor.YELLOW + "Barrel filled");
                    return true;
                }
                sender.sendMessage(ChatColor.RED + "invalid block type");
                return true;

            /*
            empties a single chest with loot
             */
            } else if (label.equalsIgnoreCase("emptychest") && sender.isOp()) {
                if(player.getTargetBlock(null,5).getBlockData().getMaterial().equals(Material.CHEST)){
                    LootChest lc = new LootChest((Chest) player.getTargetBlock(null,5).getState());
                    sender.sendMessage(ChatColor.YELLOW + "Chest emptied");
                    lc.clearItems();
                    return true;
                } else if (player.getTargetBlock(null, 5).getBlockData().getMaterial().equals(Material.BARREL)){
                    LootBarrel lc = new LootBarrel((Barrel) player.getTargetBlock(null,5).getState());
                    lc.clearItems();
                    sender.sendMessage(ChatColor.YELLOW + "Barrel emptied");
                    return true;
                }
                sender.sendMessage(ChatColor.RED + "invalid block type");
                return true;
            /*
            adds a chest to a dungeon
             */
            } else if (label.equalsIgnoreCase("addChest") && sender.isOp()){
                if(args.length > 0) {
                    if (player.getTargetBlock(null, 5).getBlockData().getMaterial().equals(Material.CHEST)) {
                        dungeons.get(args[0]).addSpot(new LootChest((Chest) player.getTargetBlock(null, 5).getState()));
                        sender.sendMessage(ChatColor.GREEN + "Chest added to " + args[0]);
                        return true;
                    } else if (player.getTargetBlock(null, 5).getBlockData().getMaterial().equals(Material.BARREL)){
                        dungeons.get(args[0]).addSpot(new LootBarrel((Barrel) player.getTargetBlock(null, 5).getState()));
                        sender.sendMessage(ChatColor.GREEN + "Barrel added to " + args[0]);
                        return true;
                    }
                    sender.sendMessage(ChatColor.RED + "invalid block type");
                    return true;
                }
                sender.sendMessage(ChatColor.RED + "not enough arguments, add dungeon name.");
                return true;
            /*
            removes a chest from a dungeon
             */
            } else if (label.equalsIgnoreCase("removeChest") && sender.isOp()){
                if(args.length > 0) {
                    if (player.getTargetBlock(null, 5).getBlockData().getMaterial().equals(Material.CHEST)) {
                        dungeons.get(args[0]).addSpot(new LootChest((Chest) player.getTargetBlock(null, 5).getState()));
                        sender.sendMessage(ChatColor.GREEN + "Chest removed from " + args[0]);
                        return true;
                    } else if (player.getTargetBlock(null, 5).getBlockData().getMaterial().equals(Material.BARREL)){
                        dungeons.get(args[0]).addSpot(new LootBarrel((Barrel) player.getTargetBlock(null, 5).getState()));
                        sender.sendMessage(ChatColor.GREEN +"Barrel removed from " + args[0]);
                        return true;
                    }
                    sender.sendMessage(ChatColor.RED + "invalid block type");
                    return true;
                }
                sender.sendMessage(ChatColor.RED + "not enough arguments, add dungeon name.");
                return true;
            }
        }
        /*
        prints the loot spots of a dungeon
         */
        if(label.equalsIgnoreCase("printLootSpots") && sender.isOp()) {
            if(args.length > 0) {
                dungeons.get(args[0]).printLootSpots(sender);
                return true;
            }
            sender.sendMessage(ChatColor.RED + "not enough arguments, add dungeon name.");
            return true;
        /*
        fills the loot of a dungeon
         */
        } else if(label.equalsIgnoreCase("fillLootSpots") && sender.isOp()) {
            if(args.length > 0) {
                dungeons.get(args[0]).addLoot();
                sender.sendMessage(ChatColor.GREEN + "Dungeon " + args[0] + " filled with loot!");
                return true;
            }
            sender.sendMessage(ChatColor.RED + "not enough arguments, add dungeon name.");
            return true;
        /*
        empties all the loot spots of a dungeon
         */
        } else if(label.equalsIgnoreCase("emptyLootSpots") && sender.isOp()) {
            if(args.length > 0) {
                dungeons.get(args[0]).clearLoot();
                sender.sendMessage(ChatColor.GREEN +"Dungeon " + args[0] + " emptied!");
                return true;
            }
            sender.sendMessage(ChatColor.RED + "not enough arguments, add dungeon name.");
            return true;
        /*
        saves the loot spots of a dungeon
         */
        } else if(label.equalsIgnoreCase("saveDungeon") && sender.isOp()) {
            if(args.length > 0) {
                dungeons.get(args[0]).save();
                sender.sendMessage(ChatColor.GREEN +"Dungeon " + args[0] + " saved!");
                return true;
            }
            sender.sendMessage(ChatColor.RED + "not enough arguments, add dungeon name.");
            return true;
        /*
        loads the loot spots of a dungeon
         */
        } else if(label.equalsIgnoreCase("reloadDungeon") && sender.isOp()) {
            if(args.length > 0) {
                dungeons.get(args[0]).deleteSpots();
                dungeons.get(args[0]).load();
                sender.sendMessage(ChatColor.GREEN +"Dungeon " + args[0] + " loaded!");
                return true;
            }
            sender.sendMessage(ChatColor.RED + "not enough arguments, add dungeon name.");
            return true;
        /*
        clears dungeon
         */
        } else if(label.equalsIgnoreCase("clearDungeon") && sender.isOp()) {
            if (args.length > 0) {
                dungeons.get(args[0]).deleteSpots();
                sender.sendMessage(ChatColor.GREEN + "Dungeon " + args[0] + " loaded!");
                return true;
            }
            sender.sendMessage(ChatColor.RED + "not enough arguments, add dungeon name.");
            return true;
        }
        return false;
    }
}
