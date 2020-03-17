package o.h.j.m.mode.factory.absfactory;

import o.h.j.m.mode.factory.pizza.LDHJPizza;
import o.h.j.m.mode.factory.pizza.LDNLPizza;
import o.h.j.m.mode.factory.pizza.Pizza;

public class LDPizzaFactory implements AbsPizzaFactory {
    @Override
    public Pizza makePizza(String ptype) {
        Pizza pizza = null;
        if ("LDHJ".equals(ptype)){
            pizza = new LDHJPizza();
        }else if ("LDNL".equals(ptype)){
            pizza = new LDNLPizza();
        }else {
            System.out.println("伦敦没有"+ptype+"类型的披萨");
        }
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
