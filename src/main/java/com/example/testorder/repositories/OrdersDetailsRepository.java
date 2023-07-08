package com.example.testorder.repositories;

import com.example.testorder.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDetailsRepository extends JpaRepository<OrderDetails,Integer> {
}
