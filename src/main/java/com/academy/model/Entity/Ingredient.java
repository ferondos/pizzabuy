package com.academy.model.Entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Ingredient {

    private Long id;
    private String name;
    private Double price;
    private Boolean is_deleted;
    private Boolean visible;
    private Timestamp created;
    private Timestamp changed;
    private Integer weight;

}
