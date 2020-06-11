package com.GiledeRose;

import com.giledeRose.GiledeRose;
import com.giledeRose.Item;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.giledeRose.Item.createBackstagePass;
import static com.giledeRose.Item.createNormalItem;

public class application {
    public static void main(String[] args){
        String baseline = getBaseline(args);
        System.out.println(baseline);
    }

    public static String getBaseline(String[] args) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        printStream.println("InventoryInfo!");


        Item[] items = new Item[]{
                createBackstagePass(15, 20),
                createBackstagePass(10, 49),
                createBackstagePass(5, 49),
                createBackstagePass(1, 20),
                createNormalItem("+5 dexterity vest",10,20),
                createNormalItem("elixir of the mongoose",5,7)
                };

        GiledeRose app = new GiledeRose(items);

        int days = 3;

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }

            printStream.println();
            app.passOneDay();

        }

        String baseline = out.toString();

        System.out.println(baseline);


        return baseline;
    }


}
