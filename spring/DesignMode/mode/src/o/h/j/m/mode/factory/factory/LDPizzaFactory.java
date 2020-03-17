package o.h.j.m.mode.factory.pizza;

public class LDPizzaFactory extends PizzaFactory{
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
