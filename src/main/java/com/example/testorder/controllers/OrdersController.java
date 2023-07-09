package com.example.testorder.controllers;


import com.example.testorder.models.Order;
import com.example.testorder.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrdersController {

    private OrderService orderService;

    @GetMapping("get-all")
    public List<Order>getAll() {
        return orderService.getAll();
    }
}
