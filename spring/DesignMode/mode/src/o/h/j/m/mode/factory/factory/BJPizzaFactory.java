package o.h.j.m.mode.factory.pizza;

public class BJPizzaFactory extends PizzaFactory{
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
