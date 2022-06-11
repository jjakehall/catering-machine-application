package com.techelevator;

public class CateringItem {

    private double price;
    private String name;
    private int numOfCateringItems;
    private String itemId;
    private String foodType;


    public CateringItem(String itemId, String name, String foodType, double price){
        this.name = name;
        this.price = price;
        this.itemId = itemId;
        this.foodType = foodType;
        this.numOfCateringItems = 7;
    }

    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;

    }
    public int getNumOfCateringItems(){
        return numOfCateringItems;
    }
    public boolean itemAvailable(){
        if(this.numOfCateringItems >=1){
            return true;
        }
        return false;
    }
    public int purchaseItem(int i){
        return numOfCateringItems -=1;
    }

    public String getQuantityString() {
        if (this.getNumOfCateringItems() == 0) {
            return "NO LONGER AVAILABLE";
        } else {
            return String.valueOf(this.getNumOfCateringItems());
        }
    }
        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }



        public String getFoodType() {
            return foodType;
            }

        public String getMessage() {
            if (foodType.equals("Dessert")) {
                System.out.println("Sugar, Sugar, so Sweet!");
                return "Sugar, Sugar, so Sweet!";
            } else if (foodType.equals("Sandwich")) {
                System.out.println("Sandwich So Delicious, Yum!");
                return "Sandwich So Delicious, Yum!";
            } else if (foodType.equals("Munchy")) {
                System.out.println("Munchy, Munchy, so Good!");
                return "Munchy, Munchy, so Good!";
            } else {
                System.out.println("Drinky, Drinky, Slurp Slurp!");
                return "Drinky, Drinky, Slurp Slurp!";
            }
        }

    public void setFoodType(String foodType){
        this.foodType = foodType;

    }
    public void removeItem(int amountToRemove){
        numOfCateringItems -= amountToRemove;
    }
}
