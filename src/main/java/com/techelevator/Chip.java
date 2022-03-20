package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Item {

    //Constant Variable
    public static final String CHIP_SOUND = "Crunch Crunch Yum!";

    //Instance Variables
    private String sound = CHIP_SOUND;
    private static int stock = 5;

    //Constructor
    public Chip(String slotID, String itemName, BigDecimal price, String type) {
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