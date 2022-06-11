package com.techelevator;

import com.techelevator.view.MenuItems.Dessert;
import com.techelevator.view.MenuItems.Drink;
import com.techelevator.view.MenuItems.Munchy;
import com.techelevator.view.MenuItems.Sandwich;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
;

public class LoadInventory {
    public Map<String, CateringItem> loadInventoryFromFile() throws FileNotFoundException {
        Map<String, CateringItem> cateringItemMap = new TreeMap<String, CateringItem>();

        try (Scanner scanner = new Scanner(new File("catering.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineArray = line.split(",");
                if (lineArray[2].equals("Munchy")) {
                    CateringItem cateringItem = new Munchy(lineArray[0], lineArray[1], lineArray[2], Double.valueOf(lineArray[3]));
                    cateringItemMap.put(lineArray[0], cateringItem);
                }else if (lineArray[2].equals("Sandwich")){
                    CateringItem cateringItem = new Sandwich(lineArray[0], lineArray[1], lineArray[2], Double.valueOf(lineArray[3]));
                    cateringItemMap.put(lineArray[0], cateringItem);
                }else if (lineArray[2].equals("Dessert")){
                    CateringItem cateringItem = new Dessert(lineArray[0], lineArray[1], lineArray[2], Double.valueOf(lineArray[3]));
                    cateringItemMap.put(lineArray[0], cateringItem);
                }else if (lineArray[2].equals("Drink")){
                    CateringItem cateringItem = new Drink(lineArray[0], lineArray[1], lineArray[2], Double.valueOf(lineArray[3]));
                    cateringItemMap.put(lineArray[0], cateringItem);}

                }
            }
        return cateringItemMap;

    }
}








