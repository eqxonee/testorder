package com.example.testorder.service;

import com.example.testorder.dtos.OrderDetailsRequestDto;
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


//    public List<OrderDetails> getAll(){
//        List<OrderDetails> ordersDetails = ordersDetailsRepository.findAll();
//
//        return ordersDetails.stream().map(order -> modelMapper
//                        .map(order, OrderDetails.class))
//                        .collect(Collectors.toList());
//    }

        public List<OrderDetailsRequestDto> getAll(){
        List<OrderDetails> ordersDetails = ordersDetailsRepository.findAll();

        return ordersDetails.stream().map(orderDetails -> modelMapper
                        .map(orderDetails, OrderDetailsRequestDto.class))
                        .collect(Collectors.toList());
    }

    public void addNewOrderDetails(OrderDetailsRequestDto orderDetailsRequestDto){
        OrderDetails orderDetails = modelMapper.map(orderDetailsRequestDto, OrderDetails.class);
        orderDetails.setOrderId(orderDetails.getOrderId());
        ordersDetailsRepository.save(orderDetails);
    }

    public void deleteById(int id) {
        ordersDetailsRepository.deleteById(id);
    }


}
