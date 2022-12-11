package com.example.geektrust.metro;

import com.example.geektrust.metro.operations.OperationsHelper;
import com.example.geektrust.metro.operations.PassengerType;
import com.example.geektrust.metro.operations.Station;
import com.example.geektrust.metro.rev.RideHelper;

import java.util.*;

/**
 * ashwrai
 * 11-12-2022
 **/
public class Operations {

    public static void initialize()
    {
        initializeStations();
        initializePassengerTypes();
    }

    public static void addCard(String name, int balance)
    {
        OperationsHelper.addCard(name,balance);
    }


    public static void addRide(String cardName, String passengerType, String stationName) {

        RideHelper.addRide(cardName,passengerType, stationName);

    }


    public static void printSummary() {

        printSummaryOfStation("CENTRAL");
        printSummaryOfStation("AIRPORT");

    }


    private static void initializePassengerTypes() {

        OperationsHelper.addPassengerType("ADULT", 200);
        OperationsHelper.addPassengerType("SENIOR_CITIZEN", 100);
        OperationsHelper.addPassengerType("KID", 50);

    }

    private static void initializeStations() {
        OperationsHelper.addStation("CENTRAL");
        OperationsHelper.addStation("AIRPORT");
    }


    private static void printSummaryOfStation(String stationName) {

        Station station = OperationsHelper.getStation(stationName);
        System.out.println("TOTAL_COLLECTION " + stationName + " " + station.getCharges() + " " + station.getDiscount() );
        printPassengersInOrder(station);
    }

    private static void printPassengersInOrder(Station station) {

        Map<PassengerType, Integer> sortedMap = getSortedMap(station);

        System.out.println("PASSENGER_TYPE_SUMMARY");
        for(Map.Entry<PassengerType,Integer> entry : sortedMap.entrySet())
        {
            System.out.println(entry.getKey().getType() + " " + entry.getValue());
        }
    }

    private static Map<PassengerType, Integer> getSortedMap(Station station) {

        Map<PassengerType, Integer> sortedMap = new LinkedHashMap<>();

        Map<PassengerType, Integer> tmpMap = new HashMap<>(station.getPassengers());
        List<Integer> lst = new ArrayList<>(tmpMap.values());
        Collections.sort(lst , Collections.reverseOrder());

        for(Integer count : lst)
        {
            PassengerType passengerType = null;
            for(PassengerType p : tmpMap.keySet())
            {
                if(tmpMap.get(p).equals(count))
                {
                    passengerType = p;
                }
            }

            sortedMap.put(passengerType, count);
            tmpMap.remove(passengerType);
        }

        return sortedMap;

    }


}
