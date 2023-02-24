package com.academy.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Pizza {

    private Long id;
    private String name;
    private Integer weight;
    private Double price;
    private Boolean visible;
    private Timestamp created;
    private Timestamp changed;
    private List<Ingredient> ingredients;

}
