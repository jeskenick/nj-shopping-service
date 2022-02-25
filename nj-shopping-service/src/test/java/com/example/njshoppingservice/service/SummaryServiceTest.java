package com.example.njshoppingservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

public class SummaryServiceTest {
    @Test
    void testItemPrice() {
        SummaryService service = new SummaryService();
        BigDecimal expected = new BigDecimal(1.20).setScale(2, RoundingMode.UP);
        BigDecimal itemPrice = new BigDecimal(.60);
        int quantity = 2;


        BigDecimal actual = service.itemPrice(itemPrice, quantity);
        assertEquals(expected, actual);
    }
}
