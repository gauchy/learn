package com.example.geektrust.metro.rev.fare.charges;

import com.example.geektrust.metro.rev.fare.RideBill;

import java.util.ArrayList;
import java.util.List;

/**
 * ashwrai
 * 11-12-2022
 **/
public class ChargesManager {

    private List<AbstractChargePolicy> chargePolicyList  = new ArrayList<>();
    public ChargesManager()
    {
        chargePolicyList.add(new StandardFreeChargePolicy());
        chargePolicyList.add(new ServiceFeeChargePolicy());
    }

    public void applyCharges(RideBill rideBill)
    {
        for(AbstractChargePolicy charges : chargePolicyList)
        {
            charges.applyCharges(rideBill);
        }
    }
}
