package com.example.testorder.controllers;

import com.example.testorder.models.OrderDetails;
import com.example.testorder.service.OrderDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ordersDetails")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrdersDetailsController {

    private OrderDetailsService orderDetailsService;

    @GetMapping("get-all")
    public List<OrderDetails> getAll() {
        return orderDetailsService.getAll();
    }

    @PostMapping(value = "add-new-order-details")
    public void addNew(@RequestBody OrderDetails orderDetails) {
        orderDetailsService.addNewOrderDetails(orderDetails);
    }

//    @GetMapping("get-by-id/{orderId}")
//    public List<OrderDetails> getByOrderId(@PathVariable int orderId){
//        return orderDetailsService.getByOrderId(orderId);
//
//    }
}
