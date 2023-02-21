package com.academy.model.Entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {

    private Long id;
    private Float price; /*WWWWWWWWWWWWWWWWWWWW*/
    private String status;
    private Integer user_id;
    private LocalDateTime created; /*WWWWWWWWWWWWWWWWW*/
    private LocalDateTime changed;
    private Boolean is_deleted;
    private List<Pizza> pizzas;

}
