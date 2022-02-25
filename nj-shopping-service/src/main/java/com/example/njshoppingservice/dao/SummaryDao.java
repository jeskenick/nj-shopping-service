package com.example.njshoppingservice.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.njshoppingservice.model.Summary;


public interface SummaryDao {

    List<Summary> selectAllOrders();
    Optional<Summary> selectOrderById(UUID id);
    int insertOrder(Summary summary);

}
