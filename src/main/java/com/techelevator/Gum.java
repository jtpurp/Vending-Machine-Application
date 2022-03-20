package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item {

    //Constant Variable
    public static final String GUM_SOUND = "Chew Chew Yum!";

    //Instance Variables
    private String sound = GUM_SOUND;
    private static int stock = 5;

    //Constructor
    public Gum(String slotID, String itemName, BigDecimal price, String type) {
        super(slotID, itemName, price, type);
    }

    @Override
    public int getStock(){
        return this.stock;
    }

    @Override
    public int setStock(){;
        return this.stock--;
    }

    @Override
    public String getSound() { return sound; }


}