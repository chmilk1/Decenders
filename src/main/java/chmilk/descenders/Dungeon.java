/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders;

import chmilk.descenders.loot.Loot;
import chmilk.descenders.loot.LootBarrel;
import chmilk.descenders.loot.LootChest;
import chmilk.descenders.loot.Ore;
import org.bukkit.World;
import org.bukkit.block.Barrel;
import org.bukkit.block.Chest;
import org.bukkit.command.CommandSender;

import java.io.*;
import java.util.ArrayList;

public class Dungeon {
    ArrayList<Loot> lootSpots;
    ArrayList<Ore> oreSpots;
    boolean inProgress;
    Difficulty difficulty;
    World world;

    String internalName;
    String publicName;
    String description;

    public Dungeon(World world, String internalName, String publicName, String description){
        lootSpots = new ArrayList<Loot>();
        oreSpots = new ArrayList<Ore>();
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
        System.out.println("... Deleting File");
        file.delete();
        System.out.println("File Deleted");
        BufferedWriter fileWriter;
        try {
            file.createNewFile();
            System.out.println("Created New file");
            fileWriter = new BufferedWriter(new FileWriter(file));
            System.out.println("Init Buffered Writer");
            fileWriter.write(internalName + " " + publicName + " " + description);

            System.out.println("... Saving Loot Spots");
            for (Loot loot: lootSpots) {
                fileWriter.newLine();
                fileWriter.write(loot.getType() + " " + (int) loot.getLocation().getX() + " " + (int) loot.getLocation().getY() + " " + (int) loot.getLocation().getZ());
            }
            System.out.println("Loot Spots Saved");

            System.out.println("... Saving Ore Spots");
            for (Ore ore: oreSpots) {
                fileWriter.newLine();
                fileWriter.write(ore.toString());
            }
            System.out.println("Ore Spots Saved");

            fileWriter.close();
            System.out.println("File Closed");
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
                    } else if(words[0].equals("Ore")){
                        oreSpots.add(new Ore(world.getBlockAt(x,y,z),
                                Boolean.parseBoolean(words[4]),Boolean.parseBoolean(words[5]),Boolean.parseBoolean(words[6]),Boolean.parseBoolean(words[7]),
                                Boolean.parseBoolean(words[8]),Boolean.parseBoolean(words[9]),Boolean.parseBoolean(words[10]),Boolean.parseBoolean(words[11])));
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

    public void addOreSpot(Ore ore){
        oreSpots.add(ore);
    }

    public void removeOreSpot(Ore ore){
        oreSpots.remove(ore);
    }
    public void reset(){

    }

    public void printLootSpots(CommandSender sender) {
        for (Loot loot: lootSpots) {
            sender.sendMessage(loot.toString());
        }
    }

    public void printOreSpots(CommandSender sender) {
        for (Ore ore: oreSpots) {
            sender.sendMessage(ore.toString());
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

        for (Ore ore: oreSpots) {
            ore.refillOre();
        }
    }

    public void deleteSpots(){
        lootSpots.clear();
        oreSpots.clear();
    }
}
