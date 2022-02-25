package com.example.njshoppingservice.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.example.njshoppingservice.model.*;

public class SummaryServiceGetAllTest {
    @Test
    void testGetAllOrders() {
        SummaryService service = new SummaryService();
        List<Summary> expected = new ArrayList<>();
        final Summary expectedResponse = new Summary(null, null, null, null, null, 0, 0);
        Order order = new Order(0,0);
        order.setNumApples(2);
        order.setNumOranges(1);


        expectedResponse.setTotalApplesOrd(2);
        expectedResponse.setTotalCostApples(new BigDecimal(0.60).setScale(2, RoundingMode.UP));
        expectedResponse.setTotalOrangesOrd(1);
        expectedResponse.setTotalCostOranges(new BigDecimal(0.25).setScale(2, RoundingMode.UP));
        expectedResponse.setTotalCost(new BigDecimal(0.85).setScale(2, RoundingMode.UP));
        expected.add(expectedResponse);

        List<Summary> actual = service.getAllOrders(order);

        assertEquals(expected.get(0).getTotalApplesOrd(), actual.get(0).getTotalApplesOrd());
        assertEquals(expected.get(0).getTotalOrangesOrd(),actual.get(0).getTotalOrangesOrd());
        assertEquals(expected.get(0).getTotalCostApples(),actual.get(0).getTotalCostApples());
        assertEquals(expected.get(0).getTotalCostOranges(),actual.get(0).getTotalCostOranges());
        assertEquals(expected.get(0).getTotalCost(),actual.get(0).getTotalCost());
    }
}
