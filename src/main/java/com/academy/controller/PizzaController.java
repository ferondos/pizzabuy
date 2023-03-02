package com.academy.controller;

import com.academy.configuration.DatabaseProperties;
import com.academy.model.Entity.Pizza;
import com.academy.model.repository.pizza.PizzaRepositoryImpl;
import com.academy.service.PizzaService;
import com.academy.service.PizzaServiceImpl;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class PizzaController extends HttpServlet {
    private final PizzaService pizzaService = new PizzaServiceImpl(new PizzaRepositoryImpl(new DatabaseProperties()));


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }


    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pizza");
        if (dispatcher != null) {

            List<Pizza> pizzas = pizzaService.findAll();

            String collect = pizzas.stream().map(Pizza::getName).collect(Collectors.joining(","));

            req.setAttribute("pizzaName", collect);
            req.setAttribute("pizzas", pizzas);

            dispatcher.forward(req, resp);
        }
    }
}
