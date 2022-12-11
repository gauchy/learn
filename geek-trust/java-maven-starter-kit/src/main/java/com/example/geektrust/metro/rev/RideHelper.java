package com.example.geektrust.metro.rev;

import com.example.geektrust.metro.operations.MetroCard;
import com.example.geektrust.metro.operations.OperationsHelper;
import com.example.geektrust.metro.operations.PassengerType;
import com.example.geektrust.metro.operations.Station;
import com.example.geektrust.metro.rev.fare.RideBill;
import com.example.geektrust.metro.rev.fare.charges.ChargesManager;
import com.example.geektrust.metro.rev.fare.discount.DiscountManager;

/**
 * ashwrai
 * 11-12-2022
 **/
public class RideHelper {

    public static void addRide(String cardName, String pType, String stationName)
    {
        MetroCard card = OperationsHelper.getCard(cardName);
        Station station = OperationsHelper.getStation(stationName);
        PassengerType passengerType = OperationsHelper.getPassengetType(pType);
        RideBill rideBill = new RideBill(card, station, passengerType);
        applyFare(rideBill);
        addStationSummary(rideBill);
    }

    private static void addStationSummary(RideBill rideBill) {

        rideBill.getStation().addPassenger(rideBill.getPassengerType());
        int totalDiscount = getTotalDiscount(rideBill);
        int totalCharges = getTotalCharges(rideBill);

        rideBill.getStation().addDiscount(totalDiscount);
        rideBill.getStation().addCharges(totalCharges);

    }

    private static int getTotalCharges(RideBill rideBill) {

        int totalCharges = 0;
        for(Integer charge : rideBill.getCharges().values())
        {
            totalCharges = totalCharges + charge;
        }
        return totalCharges;
    }

    private static int getTotalDiscount(RideBill rideBill) {

        int totalDiscount = 0;
        for(Integer discount : rideBill.getDiscounts().values())
        {
            totalDiscount = totalDiscount + discount;
        }

        return totalDiscount;
    }


    private static void applyFare(RideBill rideBill) {


        applyDiscount(rideBill);
        applyCharges(rideBill);

    }

    private static void applyCharges(RideBill rideBill) {

        ChargesManager chargesManager = new ChargesManager();
        chargesManager.applyCharges(rideBill);
    }

    private static void applyDiscount(RideBill rideBill) {

        DiscountManager discountManager = new DiscountManager();
        discountManager.applyDiscount(rideBill);
    }
}
