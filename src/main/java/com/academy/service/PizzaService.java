package com.academy.service;

import com.academy.model.entity.Pizza;

import java.util.List;

public interface PizzaService {
    Pizza findById(Long id);

    List<Pizza> findAll();

    Pizza create(Pizza object);

    Pizza update(Pizza object);

    void delete(Long id);

    List<Pizza> findByCategory(String category);


    public List<Pizza> sortByPrice(String param);

}
