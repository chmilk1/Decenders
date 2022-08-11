/*
 * Copyright (c) 2022 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.loot;

import chmilk.descenders.util.RandomContainer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Ore {
    Block block;

    boolean coal;

    boolean copper;
    boolean iron;
    boolean gold;

    boolean redstone;
    boolean lapiz;
    boolean diamond;
    boolean emerald;

    public Ore(Block block, boolean coal, boolean copper, boolean iron, boolean gold, boolean redstone, boolean lapiz, boolean diamond, boolean emerald) {
        this.block = block;
        this.coal = coal;
        this.copper = copper;
        this.iron = iron;
        this.gold = gold;
        this.redstone = redstone;
        this.lapiz = lapiz;
        this.diamond = diamond;
        this.emerald = emerald;
    }

    public Ore(Block block, String args){
        this();
        this.block = block;
        parseOreFlags(args);
    }

    public Ore(Block block){
        this();
        this.block = block;
    }

    public Ore(){
        this.block = null;
        this.coal = true;
        this.copper = true;
        this.iron = true;
        this.gold = true;
        this.redstone = true;
        this.lapiz = true;
        this.diamond = true;
        this.emerald = true;
    }

    public void refillOre(){
        int oreNum = RandomContainer.rand.nextInt(100);
        if(oreNum < 4 && emerald){
            block.setType(Material.EMERALD_ORE);
        } else if(oreNum < 10 && diamond){
            block.setType(Material.DIAMOND_ORE);
        } else if(oreNum < 18 && lapiz){
            block.setType(Material.LAPIS_ORE);
        } else if(oreNum < 30 && gold){
            block.setType(Material.GOLD_ORE);
        } else if(oreNum < 48 && redstone){
            block.setType(Material.REDSTONE_ORE);
        } else if(oreNum < 68 && iron){
            block.setType(Material.IRON_ORE);
        } else if(oreNum < 88 && copper){
            block.setType(Material.COPPER_ORE);
        } else if(oreNum < 101 && coal){
            block.setType(Material.COAL_ORE);
        } else {
            if(coal){
                block.setType(Material.COAL_ORE);
            } else if(copper){
                block.setType(Material.COPPER_ORE);
            } else if(iron){
                block.setType(Material.IRON_ORE);
            } else if(redstone){
                block.setType(Material.REDSTONE_ORE);
            } else if(gold){
                block.setType(Material.GOLD_ORE);
            } else if(lapiz){
                block.setType(Material.LAPIS_ORE);
            } else if(diamond){
                block.setType(Material.DIAMOND_ORE);
            } else if(emerald){
                block.setType(Material.EMERALD_ORE);
            }
        }

    }

    public String getOreFlags(){
        return coal + " " + copper + " " + iron + " " + gold + " " + redstone + " " + lapiz + " " + diamond + " " + emerald;
    }

    public void parseOreFlags(String s){
        String[] flags = s.split(s);
        coal = Boolean.parseBoolean(flags[0]);
        copper = Boolean.parseBoolean(flags[1]);
        iron = Boolean.parseBoolean(flags[2]);
        gold = Boolean.parseBoolean(flags[3]);
        redstone = Boolean.parseBoolean(flags[4]);
        lapiz = Boolean.parseBoolean(flags[5]);
        diamond = Boolean.parseBoolean(flags[6]);
        emerald = Boolean.parseBoolean(flags[7]);
    }

    public Location getLocation() {
        return block.getLocation();
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public boolean isCoal() {
        return coal;
    }

    public void setCoal(boolean coal) {
        this.coal = coal;
    }

    public boolean isCopper() {
        return copper;
    }

    public void setCopper(boolean copper) {
        this.copper = copper;
    }

    public boolean isIron() {
        return iron;
    }

    public void setIron(boolean iron) {
        this.iron = iron;
    }

    public boolean isGold() {
        return gold;
    }

    public void setGold(boolean gold) {
        this.gold = gold;
    }

    public boolean isRedstone() {
        return redstone;
    }

    public void setRedstone(boolean redstone) {
        this.redstone = redstone;
    }

    public boolean isLapiz() {
        return lapiz;
    }

    public void setLapiz(boolean lapiz) {
        this.lapiz = lapiz;
    }

    public boolean isDiamond() {
        return diamond;
    }

    public void setDiamond(boolean diamond) {
        this.diamond = diamond;
    }

    public boolean isEmerald() {
        return emerald;
    }

    public void setEmerald(boolean emerald) {
        this.emerald = emerald;
    }

    @Override
    public String toString() {
        return "Ore " + block.getLocation().getBlockX() + " " + block.getLocation().getBlockY() + " " + block.getLocation().getBlockZ() + " " + getOreFlags();
    }
}
