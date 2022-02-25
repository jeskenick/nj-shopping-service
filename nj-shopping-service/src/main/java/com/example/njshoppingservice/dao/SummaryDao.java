package com.example.njshoppingservice.dao;

import java.util.List;

import com.example.njshoppingservice.model.Summary;


public interface SummaryDao {

    List<Summary> selectAllOrders();

}
