package com.reto5.topping;

import com.reto5.coffee.Coffee;

public class CremaBatida extends ToppingDecorator {

    public CremaBatida(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee.description() + " + Crema Batida";
    }

    @Override
    public double cost() {
        return coffee.cost() + 2000;
    }
}