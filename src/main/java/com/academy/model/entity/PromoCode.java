package com.academy.model.entity;

import java.sql.Timestamp;

public class PromoCode {

    private Long id;
    private String code;
    private Timestamp exp_date;
    private Integer discount_amount;
    private Timestamp created;
    private Timestamp changed;

}
