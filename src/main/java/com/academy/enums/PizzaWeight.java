package com.academy.enums;

public enum PizzaWeight {
    SMALL("200"),
    MEDIUM("400"),
    LARGE("1000");

    public final String val;

    PizzaWeight(String val) {
        this.val = val;
    }

}
