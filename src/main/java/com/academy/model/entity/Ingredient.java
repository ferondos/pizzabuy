package com.academy.model.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Ingredient {

    private Long id;
    private String name;
    private Double price;
    private Boolean deleted;
    private Boolean visible;
    private Timestamp created;
    private Timestamp changed;
    private Integer weight;

}
