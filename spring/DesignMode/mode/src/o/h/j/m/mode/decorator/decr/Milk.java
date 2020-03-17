package o.h.j.m.mode.decorator;
//具体的调味品
public class Milk extends Decorator{
    public Milk(Drink drk) {
        super(drk);
        setDes("牛奶");
        setPrice(1.5f);
    }
}
