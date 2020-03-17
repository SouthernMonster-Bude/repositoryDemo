package o.h.j.m.mode.decorator;
//具体的调味品
public class Chocolate extends Decorator{
    public Chocolate(Drink drk) {
        super(drk);
        setDes("巧克力");
        setPrice(3);
    }
}
