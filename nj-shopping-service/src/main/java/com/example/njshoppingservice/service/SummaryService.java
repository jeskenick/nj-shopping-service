package com.example.njshoppingservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

// public class SummaryService {
    
// }

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Date;


import com.example.njshoppingservice.dao.SummaryDao;
import com.example.njshoppingservice.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SummaryService {

    // private final SummaryDao summaryDao;
    
    // @Autowired
    // public SummaryService(@Qualifier("fakeDao") SummaryDao summaryDao) {
    //     this.summaryDao = summaryDao;
    // }

    public List<Summary> getAllOrders(Order order){
        List<Summary> responseList = new ArrayList<>();
        final Summary response = new Summary(null, null, null, null, null, 0, 0);
        final BigDecimal applePrice = new BigDecimal(0.60);
        final BigDecimal orangePrice = new BigDecimal(0.25);

        response.setId(UUID.randomUUID());
        response.setDate(new Date());
        response.setTotalCostApples(itemPrice(applePrice, order.getNumApples()));
        response.setTotalCostOranges(itemPrice(orangePrice, order.getNumOranges()));
        response.setTotalOrangesOrd(order.getNumOranges());
        response.setTotalApplesOrd(order.getNumApples());
        response.setTotalCost(itemPrice(applePrice, order.getNumApples()).add(itemPrice(orangePrice, order.getNumOranges())));
        responseList.add(response);
        return responseList;
    }

    public BigDecimal itemPrice(BigDecimal itemPrice, int quantity){
        BigDecimal itemTotal = itemPrice.multiply(BigDecimal.valueOf(quantity));
        return itemTotal.setScale(2, RoundingMode.UP);
    }
    
}

