package com.example.geektrust.metro.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ashwrai
 * 11-12-2022
 *
 * holds all station & metro card objects
 **/
public class OperationsHelper {

    private static Map<String, Station> stations = new HashMap<>();
    private static Map<String, MetroCard> metroCards = new HashMap<>();
    private static Map<String, PassengerType> passengerTypes = new HashMap<>();

    public static List<Station> getAllStations()
    {
        return new ArrayList<>(stations.values());
    }

    public static Station getStation(String name)
    {
        return stations.get(name);
    }
    public static MetroCard getCard(String name)
    {
        return metroCards.get(name);
    }

    public static void addPassengerType(String type, int fare)
    {
        passengerTypes.put(type, new PassengerType(type, fare));
    }

    public static PassengerType getPassengetType(String type)
    {
        return passengerTypes.get(type);
    }
    public static void addCard(String name, int balance)
    {
        metroCards.put(name, new MetroCard(name, balance));
    }

    public static void addStation(String name)
    {
        stations.put(name, new Station(name));
    }

}
