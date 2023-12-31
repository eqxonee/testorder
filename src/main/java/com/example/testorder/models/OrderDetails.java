package com.example.testorder.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name =  "order_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "product_name")
    private String productName;

    @Column (name = "order_id")
    private int orderId;

    @Column(name = "quantity")
    private int quantity;
}
