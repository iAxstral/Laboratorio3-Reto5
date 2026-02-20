package com.reto5.topping;

import com.reto5.coffee.Coffee;

public class Leche extends ToppingDecorator {

    public Leche(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee.description() + " + Leche";
    }

    @Override
    public double cost() {
        return coffee.cost() + 1000;
    }
}