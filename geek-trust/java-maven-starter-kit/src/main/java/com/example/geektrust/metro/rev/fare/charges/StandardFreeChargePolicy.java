package com.example.geektrust.metro.rev.fare.charges;

import com.example.geektrust.metro.rev.fare.RideBill;

/**
 * ashwrai
 * 11-12-2022
 **/
public class StandardFreeChargePolicy  extends AbstractChargePolicy{

    @Override
    public void applyCharges(RideBill rideBill) {

        int fare = rideBill.getEffectiveFare();
        rideBill.getMetroCard().deduct(fare);
        rideBill.addCharges("Standard Charges" , fare);
    }
}
