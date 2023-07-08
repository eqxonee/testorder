package com.example.testorder.service;

import com.example.testorder.dtos.OrderDetailsResponseDto;
import com.example.testorder.dtos.OrderResponseDto;
import com.example.testorder.models.Order;
import com.example.testorder.models.OrderDetails;
import com.example.testorder.repositories.OrdersDetailsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderDetailsService {

    private ModelMapper modelMapper;
    private OrdersDetailsRepository ordersDetailsRepository;


    public List<OrderDetailsResponseDto> getAll(){
        List<OrderDetails> ordersDetails = ordersDetailsRepository.findAll();

        return ordersDetails.stream().map(order -> modelMapper
                        .map(ordersDetails, OrderDetailsResponseDto.class))
                        .collect(Collectors.toList());
    }
}
