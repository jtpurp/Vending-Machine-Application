package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {

    //Instance Variables
    private String itemName;
    private BigDecimal price;
    private String type;
    private String slotID;

    //Getters
    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSlotID() {
        return slotID;
    }

    public String getType() {
        return type;
    }

    //Constructor
    public Item(String slotID, String itemName, BigDecimal price, String type) {
        this.slotID = slotID;
        this.itemName = itemName;
        this.price = price;
        this.type = type;
    }

    //Abstract Method
    public abstract int getStock();
    public abstract int setStock();
    public abstract String getSound();

}
