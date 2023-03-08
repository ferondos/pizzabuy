package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Timestamp;
import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    private Long id;

    private String name;

    private Double price;

    private Boolean visible;

    private Timestamp created;

    private Timestamp changed;

    private String imageUrl;

    private String category;

    private List<Ingredient> ingredients;

}
