package com.example.geektrust.metro.rev.fare.discount;

import com.example.geektrust.metro.rev.fare.RideBill;

/**
 * ashwrai
 * 11-12-2022
 **/
public abstract class AbstractDiscountPolicy {

    abstract public void applyDiscount(RideBill rideBill);
}
