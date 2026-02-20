package com.reto5.topping;

import com.reto5.coffee.Coffee;

public abstract class ToppingDecorator implements Coffee {
    protected final Coffee coffee;

    protected ToppingDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}