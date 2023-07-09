package com.example.testorder.repositories;

import com.example.testorder.models.Order;
import com.example.testorder.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDetailsRepository extends JpaRepository<OrderDetails,Integer> {
    List<OrderDetails> findAllByOrderId(int orderId);
}
