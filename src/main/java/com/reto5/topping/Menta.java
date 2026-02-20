package com.reto5.topping;

import com.reto5.coffee.Coffee;

public class Menta extends ToppingDecorator {

    public Menta(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee.description() + " + Menta";
    }

    @Override
    public double cost() {
        return coffee.cost() + 1300;
    }
}