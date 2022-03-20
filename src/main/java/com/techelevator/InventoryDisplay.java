package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryDisplay {

    //Instance Variables
    private static Map<String, Item> inventory;
    private static File inventoryFile = new File("./vendingmachine.csv");

    //Getter
    //TODO: may need to be static
    public Map<String, Item> getInventory() {
        return inventory;
    }

    //Constructor
    public InventoryDisplay(File inventoryFile) {
        this.inventoryFile = inventoryFile;
    }

    //Reading Input File and Assigning Data to inventory Map
    //TODO: may need to be static
    public Map<String, Item> readInventory(File inventoryFile) {

        inventory = new HashMap<>();

        try (Scanner inventoryReading = new Scanner(inventoryFile)) {

            while (inventoryReading.hasNextLine()) {

                String itemLine = inventoryReading.nextLine();
                String[] itemArray = itemLine.split("\\|");

                if (itemArray[3].equals("Chip")) {
                    inventory.put(itemArray[0], new Chip(itemArray[0], itemArray[1], BigDecimal.valueOf(Double.parseDouble(itemArray[2])).setScale(2), itemArray[3]));
                    System.out.println(inventory.get(itemArray[0]).getSlotID() + " | " + inventory.get(itemArray[0]).getItemName() + " | $" + inventory.get(itemArray[0]).getPrice() + " | " + inventory.get(itemArray[0]).getType() + " | " + inventory.get(itemArray[0]).getStock());
                } else if (itemArray[3].equals("Drink")) {
                    inventory.put(itemArray[0], new Drink(itemArray[0], itemArray[1], BigDecimal.valueOf(Double.parseDouble(itemArray[2])).setScale(2), itemArray[3]));
                    System.out.println(inventory.get(itemArray[0]).getSlotID() + " | " + inventory.get(itemArray[0]).getItemName() + " | $" + inventory.get(itemArray[0]).getPrice() + " | " + inventory.get(itemArray[0]).getType() + " | " + inventory.get(itemArray[0]).getStock());
                } else if (itemArray[3].equals("Gum")) {
                    inventory.put(itemArray[0], new Gum(itemArray[0], itemArray[1], BigDecimal.valueOf(Double.parseDouble(itemArray[2])).setScale(2), itemArray[3]));
                    System.out.println(inventory.get(itemArray[0]).getSlotID() + " | " + inventory.get(itemArray[0]).getItemName() + " | $" + inventory.get(itemArray[0]).getPrice() + " | " + inventory.get(itemArray[0]).getType() + " | " + inventory.get(itemArray[0]).getStock());
                } else if (itemArray[3].equals("Candy")) {
                    inventory.put(itemArray[0], new Candy(itemArray[0], itemArray[1], BigDecimal.valueOf(Double.parseDouble(itemArray[2])).setScale(2), itemArray[3]));
                    System.out.println(inventory.get(itemArray[0]).getSlotID() + " | " + inventory.get(itemArray[0]).getItemName() + " | $" + inventory.get(itemArray[0]).getPrice() + " | " + inventory.get(itemArray[0]).getType() + " | " + inventory.get(itemArray[0]).getStock());
                }
            }

        } catch (FileNotFoundException fnf) {
            System.err.println(fnf.getMessage());
        }
        return inventory;
    }

}
