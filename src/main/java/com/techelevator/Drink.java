package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item {

    //Constant Variable
    public static final String DRINK_SOUND = "Glug Glug Yum!";

    //Instance Variables
    private String sound = DRINK_SOUND;
    private static int stock = 5;

    //Constructor
    public Drink(String slotID, String itemName, BigDecimal price, String type) {
        super(slotID, itemName, price, type);
    }

    @Override
    public int getStock(){
        return this.stock;
    }

    @Override
    public int setStock(){
        return this.stock--;
    }

    @Override
    public String getSound() {return sound;}
}
