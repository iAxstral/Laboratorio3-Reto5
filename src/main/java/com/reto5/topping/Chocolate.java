package com.reto5.topping;

import com.reto5.coffee.Coffee;

public class Chocolate extends ToppingDecorator {

    public Chocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee.description() + " + Chocolate";
    }

    @Override
    public double cost() {
        return coffee.cost() + 1500;
    }
}