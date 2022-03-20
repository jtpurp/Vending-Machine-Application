package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item {

    //Constant Variable
    public static final String CANDY_SOUND = "Munch Munch Yum!";

    //Instance Variables
    private String sound = CANDY_SOUND;
    private static int stock = 5;

    //Constructor
    public Candy(String slotID, String itemName, BigDecimal price, String type) {
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
    public String getSound() { return sound; }
}
