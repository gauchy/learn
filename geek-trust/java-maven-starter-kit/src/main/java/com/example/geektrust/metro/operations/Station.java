package com.example.geektrust.metro.operations;

import java.util.HashMap;
import java.util.Map;

/**
 * ashwrai
 * 11-12-2022
 **/
public class Station {

    private String name;
    private Map<PassengerType, Integer> passengers;
    private int discount;
    private int charges;

    public Station(String name) {

        this.name = name;
        passengers = new HashMap<>();
        discount = 0;
        charges = 0;
    }

    public String getName() {
        return name;
    }

    public void addPassenger(PassengerType passengerType)
    {
        if(passengers.get(passengerType) == null)
        {
            passengers.put(passengerType,0);
        }

        int currentCount = passengers.get(passengerType);
        passengers.put(passengerType, currentCount+1);

    }

    public Map<PassengerType, Integer> getPassengers() {
        return passengers;
    }


    public int getDiscount() {
        return discount;
    }

    public void addDiscount(int pDiscount) {
        this.discount = discount + pDiscount;
    }

    public int getCharges() {
        return charges;
    }

    public void addCharges(int pCharges) {
        this.charges = charges + pCharges;
    }
}
