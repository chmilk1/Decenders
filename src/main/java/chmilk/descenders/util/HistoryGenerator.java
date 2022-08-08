/*
 * Copyright (c) 2020 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.util;

import java.util.Random;

public class HistoryGenerator {
    static Random rand = RandomContainer.rand;

    public static enum Trait {
        BLUNT, SHARP, FLAMING, COLD, PIERCE, POISION
    }

    public static enum WeaponType {
        SWORD, DAGGER, PICK, AXE, SPADE
    }

    public static String getIngTrait(Trait trait) {
        switch (trait) {
            case FLAMING:
                switch (rand.nextInt(3)) {
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
                switch (rand.nextInt(3)) {
                    case 0:
                        return "Cutting";
                    case 1:
                        return "Slashing";
                    case 2:
                        return "Stabbing";
                }
            case BLUNT:
                switch (rand.nextInt(3)) {
                    case 0:
                        return "Bruising";
                    case 1:
                        return "Bashing";
                    case 2:
                        return "Smashing";
                }
            case POISION:
                switch (rand.nextInt(3)) {
                    case 0:
                        return "Infecting";
                    case 1:
                        return "Tainting";
                    case 2:
                        return "Ruining";
                }
            case PIERCE:
                return "Piercing";
        }
        return "";
    }

    public static String getTrait(Trait trait) {
        switch (trait) {
            case FLAMING:
                switch (rand.nextInt(3)) {
                    case 0:
                        return "Flame";
                    case 1:
                        return "Fire";
                    case 2:
                        return "Heat";
                }
            case COLD:
                return "Frost";
            case SHARP:
                switch (rand.nextInt(3)) {
                    case 0:
                        return "Sharpness";
                    case 1:
                        return "Cleaving";
                    case 2:
                        return "Stabbing";
                }
            case POISION:
                switch (rand.nextInt(3)) {
                    case 0:
                        return "Poison";
                    case 1:
                        return "Infected";
                    case 2:
                        return "Deathly";
                }
            case BLUNT:
                switch (rand.nextInt(3)) {
                    case 0:
                        return "Power";
                    case 1:
                        return "Crushing";
                    case 2:
                        return "Smashing";
                }
            case PIERCE:
                return "Armour Piercing";
        }
        return "";
    }

    public static String getWeapType(WeaponType type) {
        switch (type) {
            case SWORD:
                switch (rand.nextInt(3)) {
                    case 0:
                        return "Sword";
                    case 1:
                        return "Blade";
                    case 2:
                        return "Rapier";
                }
            case PICK:
                if(rand.nextBoolean()){
                    return "Pick";
                } else {
                    return "Pickaxe";
                }
            case DAGGER:
                switch (rand.nextInt(3)) {
                    case 0:
                        return "Dagger";
                    case 1:
                        return "Shiv";
                    case 2:
                        return "Knife";
                }
            case SPADE:
                if(rand.nextBoolean()){
                    return "Spade";
                } else {
                    return "Shovel";
                }
            case AXE:
                return "Axe";
        }
        return "Weapon";
    }


    public static enum NameQuality {
        KING, NOBLE, MERCHANT, PEASANT
    }

    //there are only two :)
    public static enum Gender {
        MALE, FEMALE
    }

    public static String generateSwordHistory(Trait trait, String weaponType, Gender gender, NameQuality nameQuality) {
        StringBuilder name = new StringBuilder();

        int type = rand.nextInt(2);
        //type 0: Name’s Trait Weapon + of Place
        if (type == 0) {
            //full name
            if (rand.nextBoolean()) {
                name.append(getFirstName(gender) + "'s ");
            } else if (rand.nextBoolean()) {
                name.append(getLastName() + "'s ");
            } else {
                name.append(getFirstName(gender) + " " + getLastName() + "'s ");
            }
            //last name

            //trait
            if (rand.nextBoolean()) {
                name.append(getIngTrait(trait) + " ");
            }

            //weapon type
            name.append(weaponType);

            //place
            if (rand.nextInt(5) == 2) {
                name.append(" of " + getPlace());
            }

        } else if(type == 1) { //type 1: Trait Type simple
            name.append(getTrait(trait));
            name.append(" ");
            name.append(weaponType);

        } else { //type 2: Name Type of Trait
            if (rand.nextBoolean()) {
                name.append("The " + getLastName() + " Family ");
            } else {
                name.append(getFancyName(gender, nameQuality) + "'s ");
            }

            name.append(weaponType);
            if (rand.nextBoolean()) {
                name.append(" of " + getTrait(trait));
            }
        }
        return name.toString();
    }

    private static String getPlace() {
        return Names.townNames[rand.nextInt(Names.townNames.length)];
    }

    public static String generateArmourHistory() {
        return null;
    }

    public static String generateArtifactHistory() {
        return null;
    }

    public static String getFancyName(Gender gender, NameQuality nameQuality) {
        String name = "";
        switch (nameQuality) {
            case KING:
                if (rand.nextInt(100) < 60) {
                    switch (gender) {
                        case MALE:
                            name = "King ";
                            break;
                        case FEMALE:
                            name = "Queen ";
                            break;
                    }
                } else if (rand.nextInt(100) < 60) {
                    name = "Warlord ";
                }
                break;
            case NOBLE:
                if (rand.nextInt(100) < 35) {
                    switch (gender) {
                        case MALE:
                            name = "Sir ";
                            break;
                        case FEMALE:
                            name = "Mis ";
                            break;
                    }
                } else if (rand.nextInt(100) < 40) {
                    name = "Nobel ";
                }
                break;
            case MERCHANT:
                if (rand.nextInt(100) < 40) {
                    name = "Smith ";
                } else if (rand.nextInt(100) < 40) {
                    name = "Trader ";
                }
                break;
            case PEASANT:
                if (rand.nextInt(100) < 40) {
                    name = "Soldier ";
                } else if (rand.nextInt(100) < 40) {
                    name = "Farmer ";
                }
                break;
        }
        return name + getFirstName(gender) + " " + getLastName();
    }

    public static String getFirstName(Gender gender) {
        switch (gender) {
            case MALE:
                return Names.firstNamesM[rand.nextInt(Names.firstNamesM.length)];
            case FEMALE:
                return Names.firstNamesFM[rand.nextInt(Names.firstNamesFM.length)];
        }
        return "James";
    }

    public static String getLastName() {
        String lastName = Names.lastNames[rand.nextInt(Names.lastNames.length)];
        lastName = (lastName.charAt(0) + "").toUpperCase() + lastName.substring(1, lastName.length()).toLowerCase();
        return lastName;
    }

}
