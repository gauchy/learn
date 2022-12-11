package com.example.geektrust.metro.rev.fare.charges;

import com.example.geektrust.metro.rev.fare.RideBill;

/**
 * ashwrai
 * 11-12-2022
 **/
public abstract class AbstractChargePolicy {

    abstract public void applyCharges(RideBill rideBill);
}
