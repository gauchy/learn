package com.example.geektrust.metro.rev.fare.discount;

import com.example.geektrust.metro.operations.MetroCard;
import com.example.geektrust.metro.operations.Station;
import com.example.geektrust.metro.rev.fare.RideBill;

/**
 * ashwrai
 * 11-12-2022
 **/
public class ReturnJourneyDiscountPolicy extends AbstractDiscountPolicy{
    @Override
    public void applyDiscount(RideBill rideBill) {

        Station station = rideBill.getStation();
        MetroCard metroCard = rideBill.getMetroCard();

        if(metroCard.getLastStation() != null && !station.getName().equals(metroCard.getLastStation().getName()))
        {
            int standardFare = rideBill.getPassengerType().getFare();
            rideBill.addDiscount("Return Journey" , standardFare/2);
            updateLastRide(metroCard, null);
            return;
        }
        updateLastRide(metroCard, rideBill.getStation());
    }


    private void updateLastRide(MetroCard card, Station station) {

        card.setLastStation(station);
    }
}

