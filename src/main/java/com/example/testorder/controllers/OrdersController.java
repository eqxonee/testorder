package com.example.testorder.controllers;

import com.example.testorder.dtos.OrderRequestDto;
import com.example.testorder.models.Order;
import com.example.testorder.models.OrderDetails;
import com.example.testorder.repositories.OrdersRepository;
import com.example.testorder.service.OrderDetailsService;
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
    //private RestTemplate restTemplate;

    private OrdersRepository ordersRepository;

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

//    @GetMapping("get-all-with-date")
//    public List<Order>getAllWithDate() {
//        return getAllWithNewDate();
//    }

//    @PostMapping("/get-all-with-date")
//    public Date createNewDate(@RequestBody Date ) {
//        return ordersRepository.save(getDate());
//    }

//    @PostMapping("post-date")
//    public Date postDate(@RequestBody Date date) {
//        Date newDate = restTemplate.postForObject("http://localhost:8040/date/get",date,Date.class);
//        return  newDate;
//    }

//    @GetMapping("get-date")
//    public Date getNewDate(){
//        Date date = restTemplate.getForObject("http://localhost:8040/date/get",Date.class);
//        return date;
//    }

//    public List<Order> getAllWithNewDate(){
//        return ordersRepository.findAll().stream().map(
//                order -> Order
//                        .builder()
//                        .id(order.getId())
//                        .customerName(order.getCustomerName())
//                        .customerAddress(order.getCustomerAddress())
//                        .totalPrice(order.getTotalPrice())
//                        .dateTime(restTemplate.getForObject("http://localhost:8040/date/get",Date.class))
//                        .orderDetails(order.getOrderDetails())
//                        .build()
//        ).collect(Collectors.toList());
//
//    }
}
