package com.example.njshoppingservice.api;
   
import java.util.List;
//import java.util.UUID;
import java.util.UUID;

import com.example.njshoppingservice.model.*;
import com.example.njshoppingservice.service.SummaryService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/addOrders")
    public Summary insertLastest(@RequestBody Order order){
        return summaryService.insertLastest(order);
    }

    @GetMapping(path = "/find/{id}")
    public Summary getOrderById(@PathVariable("id")  UUID id){
        return summaryService.getOrderById(id).orElse(null); //custom thrown
    }

    @GetMapping("/findAllOrders")
    public List<Summary> getAllOrders(){
        return summaryService.getAllOrders();
    }

}

