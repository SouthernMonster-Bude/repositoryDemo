package o.h.j.m.mode.factory.factory;

import o.h.j.m.mode.factory.pizza.Pizza;

public abstract class PizzaFactory {
    public abstract Pizza makePizza(String ptype);
}
