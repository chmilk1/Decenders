/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.util;

import java.util.Random;

public class HistoryGenerator {
    static Random rand = new Random();

    public static enum Trait{
        BLUNT, SHARP, FLAMING, COLD, PIERCE
    }

    public String getIngTrait(Trait trait){
        switch (trait){
            case FLAMING:
                switch (rand.nextInt(3)){
                    case 0:
                        return "Flaming";
                    case 1:
                        return "Scorching";
                    case 2:
                        return "Searing";
                }
            case COLD:
                return "Freezing";
            case SHARP:
                switch (rand.nextInt(3)){
                    case 0:
                        return "Cutting";
                    case 1:
                        return "Slashing";
                    case 2:
                        return "Stabbing";
                }
            case BLUNT:
                switch (rand.nextInt(3)){
                    case 0:
                        return "Bruising";
                    case 1:
                        return "Bashing";
                    case 2:
                        return "Smashing";
                }
            case PIERCE:
                return "PIERCING";
        }
        return "";
    }

    public static enum NameQuality{
        KING, NOBLE, MERCHANT, PEASANT
    }

    //there are only two :)
    public static enum Gender{
        MALE,FEMALE
    }

    public String generateSwordHistory(Trait trait, String weaponType, Gender gender){
        StringBuilder name = new StringBuilder();

        int type = rand.nextInt(4);
        //type 0: Name’s Trait Weapon + of Place
        if(type == 0){
            //full name
            if(rand.nextBoolean()){
                name.append(getFirstName(gender) + " ");
            }
            //last name
            name.append(getLastName() + "'s ");

            //trait
            if(rand.nextBoolean()){
                name.append(getIngTrait(trait) + " ");
            }

            //weapon type
            name.append(weaponType);

            //place
            if(rand.nextInt(5) == 2){
                name.append(" of " + getPlace());
            }
        //type 1: Name Type of Trait
        } else if (type == 1){
            if(rand.nextBoolean()){
                if(rand.nextBoolean()){
                    name.append("The " + getLastName() + " Family ");
                } else {

                }
            }
        } else if (type == 2){

        } else if (type == 3){

        }
        return name.toString();
    }

    private String getPlace() {
        return Names.townNames[rand.nextInt(Names.townNames.length)];
    }

    public String generateArmourHistory(){
        return null;
    }

    public String generateArtifactHistory(){
        return null;
    }

    public String getFancyName(Gender gender, NameQuality nameQuality){
        String name = "";
        switch (nameQuality){
            case KING:
                if (rand.nextInt(100) < 60){
                    switch (gender){
                        case MALE:
                            name = "King";
                            break;
                        case FEMALE:
                            name = "Queen";
                            break;
                    }
                } else if (rand.nextInt(100) < 60){
                    name = "Warlord";
                }
                break;
            case NOBLE:
                if (rand.nextInt(100) < 35){
                    switch (gender){
                        case MALE:
                            name = "Sir";
                            break;
                        case FEMALE:
                            name = "Mis";
                            break;
                    }
                } else if(rand.nextInt(100) < 40){
                    name = "Nobel";
                }
                break;
            case MERCHANT:
                break;
            case PEASANT:
        }
        return name + " " + getFirstName(gender) + " " + getLastName();
    }

    public String getFirstName(Gender gender){
        switch (gender){
            case MALE:
                return Names.firstNamesM[rand.nextInt(Names.firstNamesM.length)];
            case FEMALE:
                return Names.firstNamesFM[rand.nextInt(Names.firstNamesFM.length)];
        }
        return "James";
    }

    public String getLastName(){
        String lastName = Names.lastNames[rand.nextInt(Names.lastNames.length)];
        lastName = (lastName.charAt(0)+"").toUpperCase() + lastName.substring(1, lastName.length()).toLowerCase();
        return lastName;
    }

}
