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

    private final SummaryDao summaryDao;
    
    @Autowired
    public SummaryService(@Qualifier("fakeDao") SummaryDao summaryDao) {
        this.summaryDao = summaryDao;
    }

    public Summary addOrders(Order order){
        final Summary response = new Summary(null, null, null, null, null, 0, 0);

        response.setId(UUID.randomUUID());
        response.setDate(new Date());
        response.setTotalCostApples(appleOffers(order.getNumApples()));
        response.setTotalCostOranges(orangeOffers(order.getNumOranges()));
        response.setTotalCost(appleOffers(order.getNumApples()).add(orangeOffers(order.getNumOranges())));
        response.setTotalOrangesOrd(order.getNumOranges());
        response.setTotalApplesOrd(order.getNumApples());

        return response;
    }

    public Summary insertLastest(Order order){
        final Summary response = addOrders(order);
        summaryDao.insertOrder(response);
        return response;
    }

    public List<Summary> getAllOrders(){
        return summaryDao.selectAllOrders();
    }

    public BigDecimal appleOffers(int itemQuantity){
        // • buy one get one free on Apples 
        final BigDecimal applePrice = new BigDecimal(0.60).setScale(2, RoundingMode.UP); 
        BigDecimal offerTotal = new BigDecimal(0).setScale(2, RoundingMode.UP);

        if(itemQuantity == 0){
            return offerTotal;
        }else if(itemQuantity <= 2){
            return offerTotal.add(applePrice);
        }else if(itemQuantity % 2 == 0 && itemQuantity > 2){
            int discountQuantity = 0;
            discountQuantity = itemQuantity / 2;
            return offerTotal.add(applePrice.multiply(BigDecimal.valueOf(discountQuantity))).setScale(2, RoundingMode.UP);
        }else if(itemQuantity % 2 == 1 && itemQuantity > 2){
            int discountQuantity = 0;
            discountQuantity = 1 +(itemQuantity / 2);
            return offerTotal.add(applePrice.multiply(BigDecimal.valueOf(discountQuantity))).setScale(2, RoundingMode.UP);
        }
        return offerTotal.setScale(2, RoundingMode.UP);
    }


    public BigDecimal orangeOffers(int itemQuantity){
        // • 3 for the price of 2 on Oranges  
        final BigDecimal orangePrice = new BigDecimal(0.25).setScale(2, RoundingMode.UP);
        BigDecimal offerTotal = new BigDecimal(0).setScale(2, RoundingMode.UP);

        if(itemQuantity == 0){
            return offerTotal;
        } else if(itemQuantity < 3){
            return offerTotal.add(orangePrice.multiply(BigDecimal.valueOf(itemQuantity))).setScale(2, RoundingMode.UP);
        } else if(itemQuantity % 3 == 0){
            int subDiscountQuantity = 0;
            int discountQuantity = 0;
            subDiscountQuantity = (itemQuantity / 3) + itemQuantity % 3 ;
            discountQuantity = itemQuantity - subDiscountQuantity;
           
            return offerTotal.add(orangePrice.multiply(BigDecimal.valueOf(discountQuantity))).setScale(2, RoundingMode.UP);
        } else if(itemQuantity % 3 > 0) {
            int discountQuantity;
            double disQual;
            disQual = Math.ceil(2.0 * itemQuantity / 3.0);
            discountQuantity = (int) Math.round(disQual);
    
            return offerTotal.add(orangePrice.multiply(BigDecimal.valueOf(discountQuantity))).setScale(2, RoundingMode.UP);
        }
        return offerTotal.setScale(2, RoundingMode.UP);
    }

    public Optional<Summary> getOrderById(UUID id){
        return summaryDao.selectOrderById(id);
    }
    
}

