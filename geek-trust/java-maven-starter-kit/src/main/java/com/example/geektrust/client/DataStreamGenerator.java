package com.example.geektrust.client;

import com.example.geektrust.metro.Operations;

/**
 * ashwrai
 * 11-12-2022
 **/
public class DataStreamGenerator {

    public DataStreamGenerator()
    {
        Operations.initialize();
    }

    public void addToStream(String input)
    {
        try {
            if (input.startsWith("BALANCE")) {
                addCard(input);
            } else if (input.startsWith("CHECK_IN")) {
                addRide(input);
            } else if (input.trim().equals("PRINT_SUMMARY")) {
                printSummary();
            } else {
                System.err.println("Invalid input " + input);
            }
        }
        catch (Exception e)
        {
            System.err.println("Error occurred while processing data, please try again!");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void printSummary() {

        Operations.printSummary();

    }

    private void addRide(String input) {

        String[] arr = input.split(" ");
        String cardName = arr[1];
        String passengerType = arr[2];
        String stationName = arr[3];
        Operations.addRide(cardName, passengerType, stationName);

    }

    private void addCard(String input) {

        String[] arr = input.split(" ");
        String cardName = arr[1];
        int balance = Integer.parseInt(arr[2]);

        Operations.addCard(cardName, balance);


    }
}
