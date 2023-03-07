package com.academy.model.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PaymentCard {

    private Long id;
    private String number;
    private String expDate;
    private String cvv;
    private String cardHolderName;
    private Long userId;
    private Boolean deleted;
    private Timestamp created;
    private Timestamp changed;

}
