package o.h.j.m.mode.decorator.decr;

import o.h.j.m.mode.decorator.Decorator;
import o.h.j.m.mode.decorator.Drink;

//具体的调味品
public class Soy extends Decorator {
    public Soy(Drink drk) {
        super(drk);
        setDes("豆浆");
        setPrice(1);
    }
}
