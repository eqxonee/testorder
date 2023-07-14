package com.example.testorder.service;

import com.example.testorder.models.Order;
import com.example.testorder.models.OrderDetails;
import com.example.testorder.repositories.OrdersDetailsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderDetailsService {

    private ModelMapper modelMapper;
    private OrdersDetailsRepository ordersDetailsRepository;


    public List<OrderDetails> getAll(){
        List<OrderDetails> ordersDetails = ordersDetailsRepository.findAll();

        return ordersDetails.stream().map(order -> modelMapper
                        .map(order, OrderDetails.class))
                        .collect(Collectors.toList());
    }

    public void addNewOrderDetails(OrderDetails orderDetails){
        orderDetails.setOrderId(orderDetails.getOrderId());
        ordersDetailsRepository.save(orderDetails);
    }

//    public List<OrderDetails> getByOrderId(int orderId){
//        List<OrderDetails> ordersDetails = ordersDetailsRepository.findAllByOrderId(orderId);
//        return ordersDetails;
//    }

}
