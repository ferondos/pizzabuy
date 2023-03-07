package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String surname;
    private String phone_number;
    private String password;
    private Long role_id;
    private Timestamp created;
    private Timestamp changed;
    private String status;

    private List<PaymentCard> paymentCards;
    private List<Order> orders;
    private List<Address> addresses;

}
