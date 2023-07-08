package com.example.testorder.controllers;

import com.example.testorder.dtos.OrderDetailsResponseDto;
import com.example.testorder.service.OrderDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ordersDetails")
@AllArgsConstructor
public class OrdersDetailsController {

    private OrderDetailsService orderDetailsService;

    @GetMapping("get-all")
    public List<OrderDetailsResponseDto> getAll() {
        return orderDetailsService.getAll();
    }
}
