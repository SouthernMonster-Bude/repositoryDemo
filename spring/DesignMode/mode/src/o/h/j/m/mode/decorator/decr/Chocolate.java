package o.h.j.m.mode.decorator.decr;

import o.h.j.m.mode.decorator.Decorator;
import o.h.j.m.mode.decorator.Drink;

//具体的调味品
public class Chocolate extends Decorator {
    public Chocolate(Drink drk) {
        super(drk);
        setDes("巧克力");
        setPrice(3);
    }
}
