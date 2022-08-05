/*
 * Copyright (c) 2022 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.util;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class WeaponEnchantments{
    int mend; //Mending 1 3%
    int unbreaking; //Unbreaking 4 15%
    int unbreakable; //Applies the Unbreakable type 1 2%

    int vanish; //Curse of Vanishing 1

    int fire; //Fire Aspect 2 10%
    int baneofarth; //Bane of Arthropods 5 5%
    int knock; //Knockback 4 10%
    int sharp; //Sharpness 5 20%
    int smite; //Smite 3 5%
    int sweep; //Sweeping Edge 3

    int poison; //TODO: implement custom enchantments
    int withering;
    int frost;

    public WeaponEnchantments() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0);
    }

    public WeaponEnchantments(int mend, int unbreaking, int unbreakable, int vanish, int fire, int baneofarth, int knock, int sharp, int smite, int sweep, int poison, int withering, int frost) {
        this.mend = mend;
        this.unbreaking = unbreaking;
        this.unbreakable = unbreakable;
        this.vanish = vanish;
        this.fire = fire;
        this.baneofarth = baneofarth;
        this.knock = knock;
        this.sharp = sharp;
        this.smite = smite;
        this.sweep = sweep;
        this.poison = poison;
        this.withering = withering;
    }

    public int getMend() {
        return mend;
    }

    public void setMend(int mend) {
        this.mend = mend;
    }

    public int getUnbreaking() {
        return unbreaking;
    }

    public void setUnbreaking(int unbreaking) {
        this.unbreaking = unbreaking;
    }

    public int getUnbreakable() {
        return unbreakable;
    }

    public void setUnbreakable(int unbreakable) {
        this.unbreakable = unbreakable;
    }

    public int getVanish() {
        return vanish;
    }

    public void setVanish(int vanish) {
        this.vanish = vanish;
    }

    public int getFire() {
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public int getBaneofarth() {
        return baneofarth;
    }

    public void setBaneofarth(int baneofarth) {
        this.baneofarth = baneofarth;
    }

    public int getKnock() {
        return knock;
    }

    public void setKnock(int knock) {
        this.knock = knock;
    }

    public int getSharp() {
        return sharp;
    }

    public void setSharp(int sharp) {
        this.sharp = sharp;
    }

    public int getSmite() {
        return smite;
    }

    public void setSmite(int smite) {
        this.smite = smite;
    }

    public int getSweep() {
        return sweep;
    }

    public void setSweep(int sweep) {
        this.sweep = sweep;
    }

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }

    public int getWithering() {
        return withering;
    }

    public void setWithering(int withering) {
        this.withering = withering;
    }

    public int getFrost() {
        return frost;
    }

    public void setFrost(int frost) {
        this.frost = frost;
    }

    public void applyEnchants(ItemMeta meta, List<String> lore){
        //general
        if(mend > 0){
            meta.addEnchant(Enchantment.MENDING, mend, true);
            lore.add(ChatColor.RESET + "" + ChatColor.GOLD + "Mending");
        }
        if(unbreaking > 0){
            meta.addEnchant(Enchantment.DURABILITY, unbreaking, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Unbreaking " +unbreaking);
        }
        if(unbreakable > 0){
            meta.setUnbreakable(true);
            lore.add(ChatColor.RESET + "" + ChatColor.GOLD + "Unbreakable");
        }

        //curses
        if(vanish > 0){
            meta.addEnchant(Enchantment.VANISHING_CURSE, vanish, true);
            lore.add(ChatColor.RESET + "" + ChatColor.RED + "Curse of Vanishing");
        }

        //melee
        if(fire > 0){
            meta.addEnchant(Enchantment.FIRE_ASPECT, fire, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Fire Aspect " + fire);
        }
        if(baneofarth > 0){
            meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, baneofarth, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Bane of Arthropods " + baneofarth);
        }
        if(knock > 0){
            meta.addEnchant(Enchantment.KNOCKBACK, knock, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Knockback " + knock);
        }
        if(sharp > 0){
            meta.addEnchant(Enchantment.DAMAGE_ALL, sharp, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Sharpness " + sharp);
        }
        if(smite > 0){
            meta.addEnchant(Enchantment.DAMAGE_UNDEAD, smite, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Smite " + smite);
        }
        if(sweep > 0){
            meta.addEnchant(Enchantment.KNOCKBACK, sweep, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Sweeping " + sweep);
        }
        if(poison > 0){ //custom
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Poison " + poison);
        }
        if(withering > 0){
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Withering " + withering);
        }
        if(frost > 0){
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Frost " + frost);
        }


    }

    public int rollEnchant(int roll){
        if(roll < 2){
            setUnbreakable(1);
            return 5;
        } else if (roll < 5) {
            setMend(1);
            return 2;
        } else if (roll < 20) {
            setUnbreaking((int) ((roll-5d)/15)*4+1 + getUnbreaking());
            return 0;
        } else if (roll < 25) {
            setBaneofarth(roll-20);
            return 0;
        } else if (roll < 30) {
            setSmite((int)(((roll-25d)/5d)*3d+1));
            return 0;
        } else if (roll < 50) {
            setSharp((int)( ((roll-30d)/20d)*5d+1) + getSharp());
            return 5;
        } else if (roll < 60) {
            setKnock((int) (((roll-50d)/10d)*4d+1) + getKnock());
            return 0;
        } else if (roll < 70) {
            setFire((int) (((roll-60d)/10d)*2d+1));
            return 2;
        } else if (roll < 80) {
            setFrost((int) (((roll-70d)/10d)*2d+1));
            return 0;
        } else if (roll < 90) {
            setPoison((int) (((roll-80d)/10d)*2d+1));
            return 2;
        } else if (roll < 95) {
            setWithering((int) (((roll-90d)/5d)*2d+1));
            return 2;
        } else {
            setVanish(1);
            return -20;
        }
    }

    public HistoryGenerator.Trait getTrait(){
        if (getFire()>0) {
            return HistoryGenerator.Trait.FLAMING;
        } else if(getPoison()>0){
            return HistoryGenerator.Trait.POISION;
        } else if(getFrost()>0){
            return HistoryGenerator.Trait.COLD;
        } else if(getSharp()>2 || getWithering() > 0){
            return HistoryGenerator.Trait.PIERCE;
        } else if(getSharp()>0 || sweep>0){
            return HistoryGenerator.Trait.SHARP;
        }
        return HistoryGenerator.Trait.BLUNT;
    }
}
