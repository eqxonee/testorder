package com.example.testorder.service;

import com.example.testorder.dtos.OrderResponseDto;
import com.example.testorder.models.Order;
import com.example.testorder.repositories.OrdersRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    private ModelMapper modelMapper;
    private OrdersRepository ordersRepository;


    public List<OrderResponseDto> getAll(){
        List<Order> orders = ordersRepository.findAll();

        return orders.stream().map(order -> modelMapper
                .map(order, OrderResponseDto.class))
                .collect(Collectors.toList());
    }




}
