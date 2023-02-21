package com.academy.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentCard {

    private Long id;
    private String number;
    private String exp_date;
    private String cvv;
    private String card_holder_name;
    private Integer user_id;
    private Boolean is_deleted;
    private LocalDateTime created;
    private LocalDateTime changed;

}
