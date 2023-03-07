package com.academy.model.rowmapper;

import com.academy.model.Entity.Pizza;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.academy.model.columns.PizzaColumns.*;

public class PizzaRowMapper {
    @Component
    public class UserRowMapper implements RowMapper<Pizza> {
        @Override
        public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
            Pizza pizza;

            try {
                pizza = Pizza.builder().id(rs.getLong(ID))
                        .name(rs.getString(NAME))
                        .price(rs.getDouble(PRICE))
                        .visible(rs.getBoolean(VISIBLE))
                        .created(rs.getTimestamp(CREATED))
                        .changed(rs.getTimestamp(CHANGED))
                        .image_url(rs.getString(IMAGE_URL))
                        .category(rs.getString(CATEGORY))
                        .build();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return pizza;
        }
    }
}
