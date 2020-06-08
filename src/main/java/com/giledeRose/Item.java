package com.giledeRose;

import static com.sun.deploy.util.SecurityBaseline.isExpired;

/**
 * create by ssmao
 * 2020.06.08
 */
public class Item {

    public String name;
    public int sellIn;
    public int quality;

    static public Item createBackstagePass(int sellIn, int quality){
        return new Item("Backstage passes to a TAFKAL80ETC concert",sellIn,quality);
    }

    static public Item createNormalItem(String name,int sellIn, int quality){
        return new Item(name,sellIn,quality);
    }


    private Item(String name, int sellIn, int quality){
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString(){
        return this.name + ","+this.sellIn+","+this.quality;
    }

    boolean isBackstagePass(){
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public void passOneDay(){
        updateSellInDays();
        updateQuality();

        if (isExpired()){
            updateQualityAfterExpiration();
        }
    }

    private void updateQuality(){

    }

    private void updateSellInDays(){


    }

    private void updateQualityAfterExpiration(){

    }

    private boolean isExpired(){
        return sellIn < 0;
    }




}
