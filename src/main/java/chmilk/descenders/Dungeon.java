/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders;

import chmilk.descenders.loot.Loot;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

import java.io.*;
import java.util.ArrayList;

public class Dungeon {
    ArrayList<Loot> lootSpots;
    boolean inProgress;
    Difficulty difficulty;
    World world;

    String internalName;
    String publicName;
    String description;

    public Dungeon(World world, String internalName, String publicName, String description){
        lootSpots = new ArrayList<Loot>();
        inProgress = false;
        difficulty = Difficulty.VETERAN;
        this.world = world;

        this.internalName = internalName;
        this.publicName = publicName;
        this.description = description;
    }

    public Dungeon(World world, String internalName){
        this(world, internalName, "", "");
    }

    public void save(File file){
        file.delete();
        BufferedWriter fileWriter;
        try {
            fileWriter = new BufferedWriter(new FileWriter(file));

            fileWriter.write("testing");

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(){
        save(new File("./" + internalName + ".txt"));
    }

    public void load(File file){
        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader(file));

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(){
        load(new File("./" + internalName + ".txt"));
    }

    public void addSpot(Loot loot){
        lootSpots.add(loot);
    }

    public void removeSpot(Loot loot){
        lootSpots.remove(loot);
    }

    public void reset(){

    }

    public void printLootSpots(CommandSender sender) {
        for (Loot loot: lootSpots) {
            sender.sendMessage(loot.toString());
        }
    }

    public void clearLoot(){
        for (Loot loot: lootSpots) {
            loot.clearItems();
        }
    }

    public void addLoot(){
        for (Loot loot: lootSpots) {
            loot.addLoot(100);
        }
    }
}
