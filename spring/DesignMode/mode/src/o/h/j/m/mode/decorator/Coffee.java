package o.h.j.m.mode.decorator;

public class Coffee extends Drink{
    @Override
    public float cost() {
        return getPrice();
    }
}
