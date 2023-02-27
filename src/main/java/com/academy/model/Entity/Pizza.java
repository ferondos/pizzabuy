package com.academy.model.Entity;

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
public class Pizza {

    private Long id;
    private String name;
    private Integer weight;
    private Double price;
    private Boolean visible;
    private Timestamp created;
    private Timestamp changed;
    private String image_url;
    private String category;
    private List<Ingredient> ingredients;

}
