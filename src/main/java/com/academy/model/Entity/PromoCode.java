package com.academy.model.Entity;

import java.sql.Timestamp;

public class PromoCode {

    private Long id;
    private String code;
    private Timestamp exp_date;
    private Integer discount_amount;
    private Timestamp created;
    private Timestamp changed;

}
