package com.example.geektrust.metro.rev.fare.discount;

import com.example.geektrust.metro.rev.fare.RideBill;

import java.util.ArrayList;
import java.util.List;

/**
 * ashwrai
 * 11-12-2022
 **/
public class DiscountManager {

    private List<AbstractDiscountPolicy> discountPolicies = new ArrayList<>();

    public DiscountManager()
    {
        discountPolicies.add(new ReturnJourneyDiscountPolicy());
    }

    public void applyDiscount(RideBill rideBill)
    {
        for(AbstractDiscountPolicy discount : discountPolicies)
        {
            discount.applyDiscount(rideBill);
        }
    }
}
