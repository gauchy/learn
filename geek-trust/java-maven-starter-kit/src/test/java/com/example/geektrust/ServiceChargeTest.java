package com.example.geektrust;

import com.example.geektrust.metro.operations.MetroCard;
import com.example.geektrust.metro.operations.PassengerType;
import com.example.geektrust.metro.operations.Station;
import com.example.geektrust.metro.rev.fare.RideBill;
import com.example.geektrust.metro.rev.fare.charges.ServiceFeeChargePolicy;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;

/**
 * ashwrai
 * 11-12-2022
 **/
public class ServiceChargeTest {

    @Test
    public void testNoServiceCharge()
    {
        Station s1 = new Station("S1");
        Station s2 = new Station("S2");
        MetroCard metroCard = new MetroCard("MC1", 100);

        RideBill rideBill = new RideBill(metroCard, s1, new PassengerType("p1", 100));
        ServiceFeeChargePolicy serviceFeeChargePolicy = new ServiceFeeChargePolicy();
        serviceFeeChargePolicy.applyCharges(rideBill);

        assertEquals(rideBill.getCharges().size(),0);
    }

    @Test
    public void testTwoPercentServiceCharge()
    {
        Station s1 = new Station("S1");
        Station s2 = new Station("S2");
        MetroCard metroCard = new MetroCard("MC1", 0);

        RideBill rideBill = new RideBill(metroCard, s1, new PassengerType("p1", 100));
        ServiceFeeChargePolicy serviceFeeChargePolicy = new ServiceFeeChargePolicy();
        serviceFeeChargePolicy.applyCharges(rideBill);

        for(Integer v : rideBill.getCharges().values())
        {
            assertEquals(Optional.ofNullable(v), 2);
        }
    }
}
