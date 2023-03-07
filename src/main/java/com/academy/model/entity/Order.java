package com.academy.model.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Order {

    private Long id;
    private Double price;
    private String status;
    private Integer user_id;
    private Timestamp created;
    private Timestamp changed;

    private String delivery_address;
    private String promo_code;
    private String delivery_time;
    private List<Pizza> pizzas;

}
