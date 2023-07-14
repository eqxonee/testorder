package com.example.testorder.controllers;

import com.example.testorder.dtos.OrderRequestDto;
import com.example.testorder.models.Order;
import com.example.testorder.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@RestController
@RequestMapping("orders")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrdersController {

    private OrderService orderService;

    @GetMapping("get-all")
    public List<Order>getAll() {
        return orderService.getAll();
    }

    @PostMapping(value = "add-new")
    public void addNew(@RequestBody OrderRequestDto orderRequestDto) {
        orderService.addNewOrder(orderRequestDto);
    }

    @PutMapping(value = "updateById")
    public void updateById(@RequestBody OrderRequestDto orderRequestDto) {
        orderService.updateById(orderRequestDto);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
    }
}
