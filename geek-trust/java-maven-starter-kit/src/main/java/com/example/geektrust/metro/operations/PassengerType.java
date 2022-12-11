package com.example.geektrust.metro.operations;

/**
 * ashwrai
 * 11-12-2022
 **/
public class PassengerType {

    private String type;
    private int fare;

    public PassengerType(String type, int fare)
    {
        this.type = type;
        this.fare = fare;
    }


    public String getType() {
        return type;
    }

    public int getFare() {
        return fare;
    }
}
