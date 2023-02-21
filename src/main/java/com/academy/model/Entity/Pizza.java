package com.academy.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Pizza {

    private Long id;
    private String name;
    private String weight;
    private Float price;
    private Boolean is_deleted;
    private Boolean visible;
    private LocalDateTime created;
    private LocalDateTime changed;
    private List<Ingredient> ingredients;

}
