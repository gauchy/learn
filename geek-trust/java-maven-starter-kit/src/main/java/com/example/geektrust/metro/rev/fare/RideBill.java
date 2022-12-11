package com.example.geektrust.metro.rev.fare;

import com.example.geektrust.metro.operations.MetroCard;
import com.example.geektrust.metro.operations.PassengerType;
import com.example.geektrust.metro.operations.Station;

import java.util.HashMap;
import java.util.Map;

/**
 * ashwrai
 * 11-12-2022
 **/
public class RideBill {

    private MetroCard metroCard;
    private Station station;
    private PassengerType passengerType;

    private Map<String, Integer> discounts = new HashMap<>();
    private Map<String, Integer> charges = new HashMap<>();

    private int standardFare;
    private int effectiveFare;

    public RideBill(MetroCard metroCard, Station station, PassengerType passengerType)
    {
        this.metroCard = metroCard;
        this.station = station;
        this.passengerType = passengerType;

        standardFare = passengerType.getFare();
        effectiveFare = standardFare;
    }

    public MetroCard getMetroCard() {
        return metroCard;
    }

    public void setMetroCard(MetroCard metroCard) {
        this.metroCard = metroCard;
    }

    public Station getStation() {
        return station;
    }

    public Map<String, Integer> getDiscounts() {
        return discounts;
    }

    public void addDiscount(String name, int value) {
        discounts.put(name, value);
        effectiveFare = effectiveFare-value;
    }

    public Map<String, Integer> getCharges() {
        return charges;
    }

    public void addCharges(String name, int value) {
        charges.put(name, value);
        effectiveFare = effectiveFare + value;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public int getStandardFare() {
        return standardFare;
    }

    public int getEffectiveFare() {
        return effectiveFare;
    }
}
