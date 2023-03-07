package com.academy;

import com.academy.model.entity.Pizza;
import com.academy.model.repository.pizza.PizzaRepository;
import com.academy.service.PizzaService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.academy");

        PizzaRepository pizzaRepository = applicationContext.getBean("pizzaRepositoryImpl", PizzaRepository.class);
        PizzaService pizzaService = applicationContext.getBean("pizzaServiceImpl", PizzaService.class);
//
//        System.out.println(pizzaService.findById());
//        System.out.println(pizzaService.findAll());
        System.out.println(pizzaService.create(Pizza.builder().name("test pizza").price(33D).category("VEGGIE").build()));
//        System.out.println(pizzaService.update(pizzaService.findById()));
//        pizzaService.delete(pizzaService.findById().getId());
//        System.out.println(pizzaService.findByCategory("CHEESY"));
//        System.out.println(pizzaService.sortByPrice("DESC"));

    }
}
