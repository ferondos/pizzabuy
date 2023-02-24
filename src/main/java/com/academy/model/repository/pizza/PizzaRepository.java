package com.academy.model.repository.pizza;

import com.academy.model.Entity.Pizza;
import com.academy.model.repository.CRUDRepository;

import java.util.List;

public interface PizzaRepository extends CRUDRepository<Long, Pizza> {

    List<Pizza> findByCategory(String category);

    List<Pizza> sortByPriceAsc();

    List<Pizza> sortByPriceDesc();

}
