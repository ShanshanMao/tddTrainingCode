package com.giledeRose;

public class GiledeRose {
    Item[] items;

    public GiledeRose(Item[] items){
        this.items = items;
    }

    public void passOneDay(){
        for (Item item : items){
             item.passOneDay();
        }
    }

}
