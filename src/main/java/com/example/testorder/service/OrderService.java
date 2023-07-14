package com.example.testorder.service;

import com.example.testorder.dtos.OrderRequestDto;
import com.example.testorder.models.Order;
import com.example.testorder.models.OrderDetails;
import com.example.testorder.repositories.OrdersRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    private ModelMapper modelMapper;
    private OrdersRepository ordersRepository;
    private RestTemplate restTemplate;

    public List<Order> getAll(){
        List<Order> orders = ordersRepository.findAll();

        return orders.stream().map(order -> modelMapper
                .map(order, Order.class))
                .collect(Collectors.toList());
    }

    public void addNewOrder(OrderRequestDto orderRequestDto){
        Order order = modelMapper.map(orderRequestDto,Order.class);

        order.setDateTime(restTemplate.getForObject("http://localhost:8040/date/get", Date.class));
        ordersRepository.save(order);
    }

    public void updateById(int id, Order order) {
        Order findOrder = ordersRepository.findById(id).get();

        findOrder.setCustomerName(order.getCustomerName());
        findOrder.setCustomerAddress(order.getCustomerAddress());
        findOrder.setTotalPrice(order.getTotalPrice());

        ordersRepository.save(findOrder);
    }





}
