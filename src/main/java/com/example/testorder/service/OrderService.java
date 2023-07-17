package com.example.testorder.service;

import com.example.testorder.dtos.OrderGetAllDto;
import com.example.testorder.dtos.OrderRequestDto;
import com.example.testorder.models.Order;
import com.example.testorder.repositories.OrdersRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    private ModelMapper modelMapper;
    private OrdersRepository ordersRepository;
    private RestTemplate restTemplate;

//    public List<Order> getAll() {
//        List<Order> orders = ordersRepository.findAll();
//
//        return orders.stream().map(order -> modelMapper
//                        .map(order, Order.class))
//                .collect(Collectors.toList());
//    }

    public List<OrderGetAllDto> getAll() {
        List<Order> orders = ordersRepository.findAll();

        return orders.stream().map(order -> modelMapper
                        .map(order, OrderGetAllDto.class))
                .collect(Collectors.toList());
    }

    public Date dateService(){
        Date newDate = restTemplate.getForObject("http://localhost:8040/date/get", Date.class);
        return newDate;
    }

    public void addNewOrder(OrderRequestDto orderRequestDto) {
        Order order = modelMapper.map(orderRequestDto, Order.class);

        order.setDateTime(dateService());
        ordersRepository.save(order);
    }

    public void updateById(OrderRequestDto orderRequestDto) {
        if (orderRequestDto.getId() == null) {
            throw new RuntimeException("ID заказа не может быть пустым");
        }

        Optional<Order> findOrder = ordersRepository.findById(orderRequestDto.getId());
        if (findOrder.isEmpty()) {
            throw new RuntimeException("Заказа с указанным ID не существет -" + orderRequestDto.getId());
        }

        findOrder.map(m -> {
            m.setCustomerName(orderRequestDto.getCustomerName());
            m.setCustomerAddress(orderRequestDto.getCustomerAddress());
            m.setTotalPrice(orderRequestDto.getTotalPrice());

            return m;
        });

        ordersRepository.save(findOrder.get());
    }

    public void deleteById(Long id) {
        ordersRepository.deleteById(id);
    }


}
