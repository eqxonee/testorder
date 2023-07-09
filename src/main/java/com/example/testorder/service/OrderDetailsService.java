package com.example.testorder.service;

import com.example.testorder.dtos.OrderDetailsResponseDto;
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
                        .map(order, OrderDetailsResponseDto.class))
                        .collect(Collectors.toList());
    }

//    public List<OrderDetails> getByOrderId(int orderId){
//        List<OrderDetails> ordersDetails = ordersDetailsRepository.findAllByOrderId(orderId);
//        return ordersDetails;
//    }

}
