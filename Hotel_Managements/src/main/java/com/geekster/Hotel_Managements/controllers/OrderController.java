package com.geekster.Hotel_Managements.controllers;

import com.geekster.Hotel_Managements.model.OrderFood;
import com.geekster.Hotel_Managements.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/getAllOrder")
    public Iterable<OrderFood> getAllOrder(){
        return orderService.getAllOrderdFood();
    }
}
