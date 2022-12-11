package com.example.geektrust.metro.rev.fare.charges;

import com.example.geektrust.metro.rev.fare.RideBill;

/**
 * ashwrai
 * 11-12-2022
 **/
public class ServiceFeeChargePolicy extends AbstractChargePolicy{
    @Override
    public void applyCharges(RideBill rideBill) {

        int currentBalance = rideBill.getMetroCard().getBalance();
        if( currentBalance < 0)
        {
            int moneyToAdd = currentBalance * -1;
            int serviceCharge = (int)(moneyToAdd * .02);
            rideBill.addCharges("Service Charge" , serviceCharge);
            rideBill.getMetroCard().addBalance(moneyToAdd);
        }

    }
}
