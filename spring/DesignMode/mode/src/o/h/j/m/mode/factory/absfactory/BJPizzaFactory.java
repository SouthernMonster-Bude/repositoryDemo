package o.h.j.m.mode.factory.factory;

import o.h.j.m.mode.factory.factory.PizzaFactory;
import o.h.j.m.mode.factory.pizza.BLHJPizza;
import o.h.j.m.mode.factory.pizza.BLNLPizza;
import o.h.j.m.mode.factory.pizza.Pizza;

public class BJPizzaFactory extends PizzaFactory {
    @Override
    public Pizza makePizza(String ptype) {
        Pizza pizza = null;
        if ("BJHJ".equals(ptype)){
            pizza = new BLHJPizza();
        }else if ("BJNL".equals(ptype)){
            pizza = new BLNLPizza();
        }else {
            System.out.println("北京没有"+ptype+"类型的披萨");
        }
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
