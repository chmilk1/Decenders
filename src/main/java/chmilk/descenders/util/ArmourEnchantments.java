/*
 * Copyright (c) 2022 James K. Maron
 * Contact jamesmaron87@gmail.com for licensing.
 */

package chmilk.descenders.util;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ArmourEnchantments {
    int mend; //Mending
    int unbreaking; //Unbreaking
    int unbreakable; //Applies the Unbreakable type

    int vanish; //Curse of Vanishing

    int aqua; //Aqua Affinity
    int blast; //Blast Protection
    int strider; //Depth Strider
    int falling; //Feather Falling
    int fire; //Fire Protection
    int proj; //Projectile Protection
    int prot; //Protection
    int resp; //Respiration
    int thorns; //Thorns

    public ArmourEnchantments(int mend, int unbreaking, int unbreakable, int vanish, int aqua, int blast, int strider, int falling, int fire, int proj, int prot, int resp, int thorns) {
        this.mend = mend;
        this.unbreaking = unbreaking;
        this.unbreakable = unbreakable;
        this.vanish = vanish;
        this.aqua = aqua;
        this.blast = blast;
        this.strider = strider;
        this.falling = falling;
        this.fire = fire;
        this.proj = proj;
        this.prot = prot;
        this.resp = resp;
        this.thorns = thorns;
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

    public int getAqua() {
        return aqua;
    }

    public void setAqua(int aqua) {
        this.aqua = aqua;
    }

    public int getBlast() {
        return blast;
    }

    public void setBlast(int blast) {
        this.blast = blast;
    }

    public int getStrider() {
        return strider;
    }

    public void setStrider(int strider) {
        this.strider = strider;
    }

    public int getFalling() {
        return falling;
    }

    public void setFalling(int falling) {
        this.falling = falling;
    }

    public int getFire() {
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public int getProj() {
        return proj;
    }

    public void setProj(int proj) {
        this.proj = proj;
    }

    public int getProt() {
        return prot;
    }

    public void setProt(int prot) {
        this.prot = prot;
    }

    public int getResp() {
        return resp;
    }

    public void setResp(int resp) {
        this.resp = resp;
    }

    public int getThorns() {
        return thorns;
    }

    public void setThorns(int thorns) {
        this.thorns = thorns;
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

        //armour
        if(aqua > 0){
            meta.addEnchant(Enchantment.WATER_WORKER, aqua, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Aqua Affinity");
        }
        if(blast > 0){
            meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, blast, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Blast Protection " + blast);
        }
        if(strider > 0){
            meta.addEnchant(Enchantment.DEPTH_STRIDER, strider, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Depth Strider " + strider);
        }
        if(falling > 0){
            meta.addEnchant(Enchantment.PROTECTION_FALL, falling, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Feather Falling " + falling);
        }
        if(fire > 0){
            meta.addEnchant(Enchantment.PROTECTION_FIRE, fire, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Fire Protection " + fire);
        }
        if(proj > 0){
            meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, proj, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Projectile Protection " + proj);
        }
        if(prot > 0){
            meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, prot, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Protection  " + prot);
        }
        if(resp > 0){
            meta.addEnchant(Enchantment.OXYGEN, resp, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Respiration  " + resp);
        }
        if(thorns > 0){
            meta.addEnchant(Enchantment.THORNS, thorns, true);
            lore.add(ChatColor.RESET + "" + ChatColor.YELLOW + "Thorns  " + thorns);
        }


    }
}
