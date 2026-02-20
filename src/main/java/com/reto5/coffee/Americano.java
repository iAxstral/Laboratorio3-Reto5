package com.reto5.coffee;

public class Americano implements Coffee {

    @Override
    public String description() {
        return "Café Americano";
    }

    @Override
    public double cost() {
        return 5000;
    }
}