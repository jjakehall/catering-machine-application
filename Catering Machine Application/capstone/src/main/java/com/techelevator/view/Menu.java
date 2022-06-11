package com.techelevator.view;

import com.techelevator.CateringItem;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
            scanner = new Scanner(System.in);
        }



        public String printMainMenu() {
            System.out.println();
            System.out.println("************************************");
            System.out.println("****TASTE ELEVATOR CATERING CORP****");
            System.out.println("************************************");


            System.out.println("D. Display Catering Items");
            System.out.println("P. Purchase");
            System.out.println("E. Exit");

            System.out.println("Please select your choice(Letter Only)");

            return scanner.nextLine();
        }
    public void printListOfCateringItems(List<CateringItem> cateringItems) {
        //Group items based on Product codes.
        System.out.println("\n*********** List of Items Available ******************************\n");
        System.out.printf("%-5s | %-20s | %15s | %-5s | %-5s", "Item ID", "Item Name", "Category", "Quantity", "Price $");
        System.out.println("\n--------------------------------------------------------------------\n");


        if (cateringItems.isEmpty()) {
            System.out.println("No Items available!");
            return;
        }

        for (CateringItem cateringitem : cateringItems) {

            printCateringItem(cateringitem);
        }
    }

    public void printCateringItem(CateringItem cateringitem) {
        System.out.printf("%-7s | %-20s | %15s | %-8s | %-5s\n", cateringitem.getItemId(), cateringitem.getName(), cateringitem.getFoodType(), cateringitem.getNumOfCateringItems(), "$" + cateringitem.getPrice());
    }
        public String printPurchasingSubMenu() {

            System.out.println("M. Feed Money");
            System.out.println("S. Select Item");
            System.out.println("F. Finish Transaction");
            System.out.println("R. Return to Previous Menu");
            System.out.println("Please select your choice (Letter only)");

            return scanner.nextLine();
        }


        }










