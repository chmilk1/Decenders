/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders;

import chmilk.descenders.loot.Loot;
import chmilk.descenders.loot.LootBarrel;
import chmilk.descenders.loot.LootChest;
import org.bukkit.World;
import org.bukkit.block.Barrel;
import org.bukkit.block.Chest;
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
            file.createNewFile();
            fileWriter = new BufferedWriter(new FileWriter(file));

            fileWriter.write(internalName + " " + publicName + " " + description);

            for (Loot loot:
                 lootSpots) {
                fileWriter.newLine();
                fileWriter.write(loot.getType() + " " + (int) loot.getLocation().getX() + " " + (int) loot.getLocation().getY() + " " + (int) loot.getLocation().getZ());
            }

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
            fileReader.readLine();

            String line;

            while(fileReader.ready()){
                line = fileReader.readLine();
                String[] words = line.split(" ");
                if(words.length > 3){
                    String type = words[0];
                    int x = Integer.parseInt(words[1]);
                    int y = Integer.parseInt(words[2]);
                    int z = Integer.parseInt(words[3]);

                    if(words[0].equals("Chest")){
                        lootSpots.add(new LootChest((Chest) world.getBlockAt(x,y,z).getState()));
                    } else if(words[0].equals("Barrel")){
                        lootSpots.add(new LootBarrel((Barrel) world.getBlockAt(x,y,z).getState()));
                    }
                }
            }

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
            loot.addLoot(250);
        }
    }

    public void deleteSpots(){
        lootSpots.clear();
    }
}
