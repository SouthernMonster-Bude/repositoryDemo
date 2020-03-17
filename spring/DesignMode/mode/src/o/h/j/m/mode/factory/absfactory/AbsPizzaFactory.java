package o.h.j.m.mode.factory.absfactory;

import o.h.j.m.mode.factory.pizza.Pizza;

public interface PizzaFactory {
    Pizza makePizza(String ptype);
}
