package com.example.geektrust;

import com.example.geektrust.metro.operations.MetroCard;
import com.example.geektrust.metro.operations.PassengerType;
import com.example.geektrust.metro.operations.Station;
import com.example.geektrust.metro.rev.fare.RideBill;
import com.example.geektrust.metro.rev.fare.discount.ReturnJourneyDiscountPolicy;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class DiscountTest {

    @Test
    public void testNoDiscount()
    {
        Station s1 = new Station("S1");
        Station s2 = new Station("S2");
        MetroCard metroCard = new MetroCard("MC1", 100);

        RideBill rideBill = new RideBill(metroCard, s1, new PassengerType("p1", 100));
        ReturnJourneyDiscountPolicy returnJourneyDiscountPolicy = new ReturnJourneyDiscountPolicy();
        returnJourneyDiscountPolicy.applyDiscount(rideBill);

        assertEquals(rideBill.getDiscounts().size(), 0);
    }

    /**
     * if someone travelled from S1 to S2 then they will get discount for S2 to S1 journey
     * but they should not get discount again from S1 to S2
     */
    @Test
    public void testNoDiscountAfterDiscount()
    {
        Station s1 = new Station("S1");
        Station s2 = new Station("S2");
        MetroCard metroCard = new MetroCard("MC1", 100);
        metroCard.setLastStation(s2);

        RideBill rideBill = new RideBill(metroCard, s1, new PassengerType("p1", 100));
        ReturnJourneyDiscountPolicy returnJourneyDiscountPolicy = new ReturnJourneyDiscountPolicy();
        returnJourneyDiscountPolicy.applyDiscount(rideBill);

        RideBill rideBill2 = new RideBill(metroCard, s2, new PassengerType("p1", 100));
        returnJourneyDiscountPolicy.applyDiscount(rideBill2);
        assertEquals(rideBill2.getDiscounts().size(), 0);
    }
    @Test
    public void testHalfDiscount()
    {
        Station s1 = new Station("S1");
        Station s2 = new Station("S2");
        MetroCard metroCard = new MetroCard("MC1", 100);
        metroCard.setLastStation(s2);

        RideBill rideBill = new RideBill(metroCard, s1, new PassengerType("p1", 100));
        ReturnJourneyDiscountPolicy returnJourneyDiscountPolicy = new ReturnJourneyDiscountPolicy();
        returnJourneyDiscountPolicy.applyDiscount(rideBill);

        assertEquals(rideBill.getDiscounts().size(), 1);
    }


}
