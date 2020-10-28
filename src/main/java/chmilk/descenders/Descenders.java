/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders;

import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Descenders extends JavaPlugin {

    @Override
    public  void onEnable(){
        getLogger().info("Descenders: Starting Up!");
    }

    @Override
    public  void onDisable(){
        getLogger().info("Descenders: Winding Down.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (label.equals("fillchest") && sender.isOp()) {
                if(player.getTargetBlock(null,5).getBlockData().getMaterial().equals(Material.CHEST)){
                    ((Chest) player.getTargetBlock(null, 5).getState()).getInventory().addItem(new ItemStack(Material.IRON_HELMET));
                    return true;
                }

            } else if (label.equals("emptychest") && sender.isOp()) {
                if(player.getTargetBlock(null,5).getBlockData().getMaterial().equals(Material.CHEST)){
                    ((Chest) player.getTargetBlock(null, 5).getState()).getInventory().clear();
                    return true;
                }
            }
        }
        return false;
    }
}
