package com.example.njshoppingservice.api;
   
import java.util.List;
//import java.util.UUID;

import com.example.njshoppingservice.model.*;
import com.example.njshoppingservice.service.SummaryService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummaryController {
    private final SummaryService summaryService;

    @Autowired
    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping("/findAllOrders")
    public List<Summary> getAllOrders(@RequestBody Order order){
        return summaryService.getAllOrders(order);
    }

}

