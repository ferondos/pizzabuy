package com.academy.model.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Address {

    private Long id;
    private String city;
    private String street;
    private String building;
    private String office;
    private Timestamp created;
    private Timestamp changed;
    private Boolean deleted;
    private List<User> users;

}
