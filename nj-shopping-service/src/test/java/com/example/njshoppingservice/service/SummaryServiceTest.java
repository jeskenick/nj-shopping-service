package com.example.njshoppingservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

public class SummaryServiceTest {
    @Test
    void testAppleItemPrice() {
        SummaryService service = new SummaryService();
        BigDecimal expected = new BigDecimal(0.60).setScale(2, RoundingMode.UP);
        int quantity = 2;


        BigDecimal actual = service.appleOffers(quantity);
        assertEquals(expected, actual);
        //repetitive would rather us a parameterized test and pass actaul and expected in to the test method.
        //this would allow me to test all cases in a cleaner fashion.
    }

    @Test
    void testOrangeItemPrice() {
        SummaryService service = new SummaryService();
        BigDecimal expected = new BigDecimal(0.50).setScale(2, RoundingMode.UP);
        int quantity = 2;


        BigDecimal actual = service.orangeOffers(quantity);
        assertEquals(expected, actual);
    }
}
