package com.academy.service;

import com.academy.model.entity.Pizza;
import com.academy.model.repository.pizza.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;


    @Override
    public Pizza findById(Long id) {
        return pizzaRepository.findById(id);
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza create(Pizza object) {
        return pizzaRepository.create(object);
    }

    @Override
    public Pizza update(Pizza object) {
        return pizzaRepository.update(object);
    }

    @Override
    public void delete(Long id) {
        pizzaRepository.delete(id);
    }

    @Override
    public List<Pizza> findByCategory(String category) {
        return pizzaRepository.findByCategory(category);
    }

    @Override
    public List<Pizza> sortByPrice(String param) {
        String sortingQuery;
        if (param.equals("ASC")) {
            sortingQuery = "select name, price from pizza.pizzas order by price asc";
        } else if (param.equals("DESC")) {
            sortingQuery = "select name, price from pizza.pizzas order by price desc";
        } else return null;
        return pizzaRepository.sortByPrice(sortingQuery);
    }

}
