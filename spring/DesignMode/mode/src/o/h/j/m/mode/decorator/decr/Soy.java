package o.h.j.m.mode.decorator;
//具体的调味品
public class Soy extends Decorator{
    public Soy(Drink drk) {
        super(drk);
        setDes("豆浆");
        setPrice(1);
    }
}
