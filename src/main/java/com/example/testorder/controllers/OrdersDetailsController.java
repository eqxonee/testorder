package com.example.testorder.controllers;

import com.example.testorder.dtos.OrderDetailsRequestDto;
import com.example.testorder.dtos.OrderRequestDto;
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
    public List<OrderDetailsRequestDto> getAll() {
        return orderDetailsService.getAll();
    }

    @PostMapping(value = "add-new-order-details")
    public void addNew(@RequestBody OrderDetailsRequestDto orderDetailsRequestDto) {
        orderDetailsService.addNewOrderDetails(orderDetailsRequestDto);
    }

    @PutMapping(value = "updateById")
    public void updateById(@RequestBody OrderDetailsRequestDto orderDetailsRequestDto) {
        orderDetailsService.updateById(orderDetailsRequestDto);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        orderDetailsService.deleteById(id);
    }

}
