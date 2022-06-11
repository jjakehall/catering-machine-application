package com.techelevator;

import com.techelevator.view.Menu;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class CaTEringCapstoneCLI {


	private Menu menu;

	private static final String Display_Catering_Items = "D";

	private static final String Purchase = "P";

	private static final String Exit = "E";


	public CaTEringCapstoneCLI(Menu menu) {
		this.menu = menu;
	}

	Transaction transaction = new Transaction();


	Map<String, CateringItem> cateringInventory;
	Scanner scanner = new Scanner(System.in);
	PurchaseLog newPurchaseLog = new PurchaseLog();

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu();
		CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
		cli.run();
	}

	public void run() throws IOException {
		Inventory inventory = new Inventory();


		boolean isRunning = true;

		while (isRunning) {
			String userChoice = menu.printMainMenu();
			if (userChoice.equals(Display_Catering_Items)) {
				List<CateringItem> cateringItems = inventory.retrieveListOfCateringItems();

				menu.printListOfCateringItems(cateringItems);
			} else if (userChoice.equals(Purchase)) {
				subMenu();
			} else if (userChoice.equals(Exit)) {
				isRunning = false;
				System.out.println("Have A Great Day!");
				System.exit(0);
			}
		}




	}
	private void subMenu() throws IOException {
		boolean Looping = true;
		Inventory inventory = new Inventory();

		while (Looping){
			 String subMenuOption = menu.printPurchasingSubMenu();

			 if (subMenuOption.equalsIgnoreCase("M")) {
				 System.out.println("You chose feed money, enter the amount you would like to add!");
				 double credit = Double.parseDouble(scanner.nextLine());
				 transaction.addMoney(credit);
				 newPurchaseLog.logUser("Add Money", transaction.getBalance());
			 } else if (subMenuOption.equalsIgnoreCase("S")){
				 List<CateringItem> cateringItems = inventory.retrieveListOfCateringItems();
				 menu.printListOfCateringItems(cateringItems);
				 cateringInventory = inventory.getInventoryMap();
				 System.out.println("Enter the item's code you want to purchase.");
				 String userInput = scanner.nextLine();
				 String finalUserInput = userInput.toUpperCase();

			  if(cateringInventory.containsKey(finalUserInput)) {

				  if (cateringInventory.get(finalUserInput).itemAvailable() && (transaction.getBalance() >= cateringInventory.get(finalUserInput).getPrice()))
					  ;
				  cateringInventory.get(finalUserInput).purchaseItem(1);
				  double userBalance = transaction.getBalance() - cateringInventory.get(finalUserInput).getPrice();
				  newPurchaseLog.logUser(cateringInventory.get(finalUserInput).getName(), userBalance);
				  System.out.println("Here is your balance: $" + (String.format("%.2f", userBalance)));
				  transaction.getChange(userBalance);
				  System.out.println("Here is your change: $" + (String.format("%.2f", userBalance)));

			  }
		}
			 else {
				 System.out.println("The product code you entered is not available, please try again.");
			 }
			  if (subMenuOption.equalsIgnoreCase("F")){
				System.out.println("Complete transaction");
			  }



			 else {
				System.out.println("Returning to main menu");
				Looping = false;
			}
	}
}}

