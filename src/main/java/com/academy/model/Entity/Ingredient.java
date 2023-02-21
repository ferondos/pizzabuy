package com.academy.model.Entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Ingredient {

    private Long id;
    private String name;
    private Float price;
    private Boolean is_deleted;
    private Boolean visible;
    private LocalDateTime created;
    private LocalDateTime changed;

}
