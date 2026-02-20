package com.reto5.coffee;

public class Espresso implements Coffee {

    @Override
    public String description() {
        return "Café Espresso";
    }

    @Override
    public double cost() {
        return 4500;
    }
}