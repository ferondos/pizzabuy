package com.academy.model.repository.pizza;

import com.academy.configuration.DatabaseProperties;
import com.academy.model.Entity.Pizza;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.academy.model.columns.PizzaColumns.*;

@RequiredArgsConstructor
@Repository
public class PizzaRepositoryImpl implements PizzaRepository {
    private final DatabaseProperties properties;


    private void registerDriver() {
        try {
            Class.forName(properties.getDriverName());
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver Cannot be loaded!");
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }
    }

    private Connection getConnection() {
        String jdbcURL = StringUtils.join(properties.getUrl(), properties.getPort(), properties.getName());
        try {
            return DriverManager.getConnection(jdbcURL, properties.getLogin(), properties.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pizza findById(Long id) {
        driverReg();
        Pizza pizza = null;
        try (Connection connection = getConnection(); PreparedStatement pstm = connection.prepareStatement("select * from pizza.pizzas where id=?");) {
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                pizza = parseResultSet(rs);
            }
            return pizza;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }

    @Override
    public List<Pizza> findAll() {
        final String findAllQuery = "select * from pizza.pizzas order by id asc ";

        List<Pizza> result = new ArrayList<>();

        driverReg();
        try (Connection connection = getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(findAllQuery)) {

            while (rs.next()) {
                result.add(parseResultSet(rs));
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }

    private Pizza parseResultSet(ResultSet rs) {
        Pizza pizza;
        try {
            pizza = Pizza.builder().id(rs.getLong(ID)).name(rs.getString(NAME)).price(rs.getDouble(PRICE)).visible(rs.getBoolean(VISIBLE)).created(rs.getTimestamp(CREATED)).changed(rs.getTimestamp(CHANGED)).image_url(rs.getString(IMAGE_URL)).category(rs.getString(CATEGORY)).build();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pizza;
    }

    @Override
    public Pizza create(Pizza object) {
        final String name = object.getName();
        final Double price = object.getPrice();
        final String category = object.getCategory();
        driverReg();
        try (Connection connection = getConnection(); PreparedStatement pstm = connection.prepareStatement("INSERT INTO pizza.pizzas (name, price, category) VALUES (?,?,?)");


        ) {
            pstm.setString(1, name);
            pstm.setDouble(2, price);
            pstm.setString(3, category);
            pstm.executeUpdate();
            try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    object.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
        return findById(object.getId());
    }

    private void driverReg() {
        registerDriver();
    }

    @Override
    public Pizza update(Pizza object) {
        driverReg();
        final Long id = object.getId();
        try (Connection connection = getConnection(); PreparedStatement pstm = connection.prepareStatement("update pizza.pizzas set name='updateTest', price=420,category='testCat' where id=?");) {

            pstm.setLong(1, id);
            pstm.executeUpdate();
            return findById(object.getId());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }

    }

    @Override
    public void delete(Long id) {
        driverReg();
        try (Connection connection = getConnection(); PreparedStatement pstm = connection.prepareStatement("delete from pizza.pizzas where id=?");) {
            pstm.setLong(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }

    @Override
    public List<Pizza> findByCategory(String category) {
        List<Pizza> pizzas = new ArrayList<>();
        driverReg();
        try (Connection connection = getConnection(); PreparedStatement pstm = connection.prepareStatement("select * from pizza.pizzas where category=? order by id asc");) {
            pstm.setString(1, category);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                pizzas.add(parseResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
        return pizzas;
    }

    @Override
    public List<Pizza> sortByPrice(String sortingQuery) {
        List<Pizza> pizzas = new ArrayList<>();
        driverReg();
        try (Connection connection = getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sortingQuery)) {
            while (rs.next()) {
                pizzas.add(Pizza.builder().name(rs.getString("name")).price(rs.getDouble("price")).build());
            }
            return pizzas;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }


}
