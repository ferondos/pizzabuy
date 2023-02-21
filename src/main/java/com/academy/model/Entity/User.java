package com.academy.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String phone_number;
    private Integer role_id;
    private Boolean is_deleted;
    private LocalDateTime created;
    private LocalDateTime changed;
    private String status;
    private List<PaymentCard> paymentCards;
    private List<Order> orders;
    private List<Address> addresses;

}
