package com.academy.model.Entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Address {

    private Long id;
    private String city;
    private String street;
    private String building;
    private String office;
    private LocalDateTime created;
    private LocalDateTime changed;
    private Boolean id_deleted;
    private List<User> users;

}
