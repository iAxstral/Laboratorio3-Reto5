package com.reto5.topping;

import com.reto5.coffee.Coffee;

public class Caramelo extends ToppingDecorator {

    public Caramelo(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee.description() + " + Caramelo";
    }

    @Override
    public double cost() {
        return coffee.cost() + 1200;
    }
}