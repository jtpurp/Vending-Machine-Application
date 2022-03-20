package com.techelevator;

import com.techelevator.view.Menu;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class VendingMachineCLI {


	public static void main(String[] args) {

		File overwriteLogFile = new File("Log.txt");

		try (PrintWriter overwriteLog = new PrintWriter(overwriteLogFile)) {
			overwriteLog.write("");
		} catch (FileNotFoundException fnf){
			System.out.println("Something Went Wrong:" + fnf.getMessage());
		}

		Menu menu = new Menu(System.in, System.out);
		MoneyManager moneyManager = new MoneyManager();
		VendingMachineCLI cli = new VendingMachineCLI(menu, moneyManager);
		cli.run();
	}

	//Main Menu
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase"; //Selecting this option will go to Purchase Menu Options
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	//Purchasing Menu
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	//Feed Menu
	private static final String FEED_ONE_DOLLAR = "Feed $1";
	private static final String FEED_TWO_DOLLAR = "Feed $2";
	private static final String FEED_FIVE_DOLLAR = "Feed $5";
	private static final String FEED_TEN_DOLLAR = "Feed $10";

	//Menu Arrays
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
	private static final String[] FEED_MENU_OPTIONS = {FEED_ONE_DOLLAR, FEED_TWO_DOLLAR, FEED_FIVE_DOLLAR, FEED_TEN_DOLLAR};

	//Instantiations
	private static File inventoryFile = new File("./vendingmachine.csv");
	private static InventoryDisplay display = new InventoryDisplay(inventoryFile);

	private Menu menu;
	private MoneyManager moneyManager;

	//Constructor
	public VendingMachineCLI(Menu menu, MoneyManager moneyManager) {
		this.menu = menu;
		this.moneyManager = moneyManager;
	}

	public void run() {

		while (true) {

			boolean runningPurchase = true;
			boolean runningBalance = true;

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				System.out.println("Slot ID | Item Name | Price | Item Type | Stock");
				System.out.println("*********************************");
				display.readInventory(inventoryFile);

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				if (runningBalance) {
					System.out.println();
					System.out.println("You have $" + moneyManager.getBalance() + " in the machine");
					runningBalance = false;
				}
				// Purchase Menu
				while (runningPurchase) {
					choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					// Feed Money
					if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						choice = (String) menu.getChoiceFromOptions(FEED_MENU_OPTIONS);

						if (choice.equals(FEED_ONE_DOLLAR)) {
							moneyManager.feedMoney(choice);
						} else if (choice.equals(FEED_TWO_DOLLAR)) {
							moneyManager.feedMoney(choice);
						} else if (choice.equals(FEED_FIVE_DOLLAR)) {
							moneyManager.feedMoney(choice);
						} else if (choice.equals(FEED_TEN_DOLLAR)) {
							moneyManager.feedMoney(choice);
						}
					// Purchase
					} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
							System.out.println();
							System.out.println("Slot ID | Item Name | Price | Item Type | Stock");
							System.out.println("***********************************************");
							display.readInventory(inventoryFile);

							Scanner userInputScanner=new Scanner(System.in);
							System.out.println();
							System.out.print("Please Select Slot ID >>> ");
							String userInput = userInputScanner.nextLine();

							if(display.getInventory().containsKey(userInput)){
								moneyManager.purchase(display.getInventory().get(userInput).getSlotID());
							} else {
								System.out.println();
								System.out.println("Invalid Slot ID");
							}
					// Finish Transaction
					} else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						moneyManager.giveChange();
						runningPurchase = false;
					}

					System.out.println();
					System.out.println("You have $" + moneyManager.getBalance() + " in the machine");

				}

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println();
				System.out.println("Y'all come back now, ya hear!");
				System.exit(0);
			}
		}
	}

}

