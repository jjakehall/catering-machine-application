package com.techelevator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
public class PurchaseLog {

        //Makes a file Audit.txt
        public void logUser(String transactionType, Double balance ) throws IOException {
            String filename = "Audit.txt";
            Calendar calender = Calendar.getInstance();
            try(PrintWriter writeToFile = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)))){
                Date transactionTime = calender.getTime();
                String loggedBalance = balance.toString();
                writeToFile.println(transactionTime + " " + String.format("%-20s", transactionType)  + String.format("%-20s", loggedBalance));
                writeToFile.close();
                writeToFile.flush();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }

        }



    }

