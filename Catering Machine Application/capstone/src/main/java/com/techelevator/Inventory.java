package com.techelevator;

import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {
    //Map contains inventory of catering items
    private Map<String, CateringItem> cateringInventory;

    public Inventory() throws FileNotFoundException {
        LoadInventory loader = new LoadInventory();
        cateringInventory = loader.loadInventoryFromFile();

    }

    //This method returns a list of all the catering items.
    public List<CateringItem> retrieveListOfCateringItems(){
        List<CateringItem> cateringItemList = new ArrayList<CateringItem>();
        Set<String> keys = cateringInventory.keySet();

        for (String key : keys) {

            cateringItemList.add(cateringInventory.get(key));

        }


        return cateringItemList;



    }

    public Map <String, CateringItem>getInventoryMap(){
        Map<String, CateringItem>inventoryMap = new HashMap<String, CateringItem>();
        inventoryMap.putAll(cateringInventory);
        return inventoryMap;

    }

    }



