package com.academy.model.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Order {

    private Long id;
    private Double price;
    private String status;
    private Integer userId;
    private Timestamp created;
    private Timestamp changed;

    private String deliveryAddress;
    private String promoCode;
    private String deliveryTime;
    private List<Pizza> pizzas;

}
