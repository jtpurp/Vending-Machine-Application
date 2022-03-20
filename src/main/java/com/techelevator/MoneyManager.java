package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.Map;

public class MoneyManager {

    //Instantiate Log Class
    private static final Log updateLog = new Log();

    //Instantiate InventoryDisplay CLass
    private static File inventoryFile = new File("./vendingmachine.csv");
    private static InventoryDisplay inventory = new InventoryDisplay(inventoryFile);

    //Define Balance
    private BigDecimal balance =  new BigDecimal("0.00");
    private BigDecimal previousBalance = new BigDecimal("0.00");

    //Define Bills accepted
    private static final BigDecimal dollarBill = new BigDecimal("1.00");
    private static final BigDecimal twoDollarBill = new BigDecimal("2.00");
    private static final BigDecimal fiveDollarBill = new BigDecimal("5.00");
    private static final BigDecimal tenDollarBill = new BigDecimal("10.00");

    //Getter
    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal feedMoney(String choice) {

    if (choice.equals("Feed $1")) {
        balance = balance.add(dollarBill);
        try {
            updateLog.setLog("FEED MONEY:", dollarBill, balance);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    } else if (choice.equals("Feed $2")) {
        balance = balance.add(twoDollarBill);
        try {
            updateLog.setLog("FEED MONEY:", twoDollarBill, balance);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    } else if (choice.equals("Feed $5")) {
            balance = balance.add(fiveDollarBill);
        try {
            updateLog.setLog("FEED MONEY:", fiveDollarBill, balance);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    } else if (choice.equals("Feed $10")) {
        balance = balance.add(tenDollarBill);
        try {
            updateLog.setLog("FEED MONEY:", tenDollarBill, balance);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
        return balance;
    }

    public void purchase(String key){

        previousBalance = balance;

        if (balance.compareTo(inventory.getInventory().get(key).getPrice()) < 0 ) {
            System.out.println();
            System.out.println("Not enough money! Please give me more!");
        } else if (inventory.getInventory().get(key).getStock() == 0) {
            System.out.println();
            System.out.println(inventory.getInventory().get(key).getItemName() + " is SOLD OUT!");
        } else {
            balance = balance.subtract(inventory.getInventory().get(key).getPrice());
            inventory.getInventory().get(key).setStock(); //TODO: HELP!

            System.out.println();
            System.out.println("Dispensing " + inventory.getInventory().get(key).getItemName() + " ... ");
            System.out.println(inventory.getInventory().get(key).getSound());
            //Audit Logger
            try {
                updateLog.setLog(inventory.getInventory().get(key).getItemName() + " " + inventory.getInventory().get(key).getSlotID(), previousBalance, balance);
            }catch (Exception e){
                System.out.println(e.getMessage());

            }
        }
    }

    public void giveChange(){
        int quarters = 0;
        int dimes = 0;
        int nickles = 0;
        BigDecimal quarterValue = new BigDecimal(".25");
        BigDecimal dimeValue = new BigDecimal(".10");
        BigDecimal nickleWorth = new BigDecimal(".05");

        previousBalance = balance;

        while (balance.compareTo(quarterValue) > 0 || balance.compareTo(quarterValue) == 0) {
            balance = balance.subtract(quarterValue);
            quarters++;
        }
        while (balance.compareTo(dimeValue) > 0 || balance.compareTo(dimeValue) == 0) {
            balance = balance.subtract(dimeValue);
            dimes++;
        }
        while (balance.compareTo(nickleWorth) > 0 || balance.compareTo(nickleWorth) == 0) {
            balance = balance.subtract(nickleWorth);
            nickles++;
        }

        //Audit Logger
        try {
            updateLog.setLog("GIVE CHANGE:", previousBalance, balance);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Your change is " + quarters + " quarter(s), " + dimes + " dime(s), & " + nickles + " nickle(s)");
        System.out.println("for a total amount of $" + quarterValue.multiply(BigDecimal.valueOf(quarters)).add(dimeValue.multiply(BigDecimal.valueOf(dimes))).add(nickleWorth.multiply(BigDecimal.valueOf(nickles))));
    }


}
