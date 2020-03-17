package o.h.j.m.mode.decorator;

public class Decorator extends Drink{
    private Drink drk;

    public Decorator(Drink drk) {
        this.drk = drk;
    }

    @Override
    public float cost() {
        return this.getPrice()+drk.cost();
    }

    @Override
    public String getDes() {
        return super.getDes()+" "+getPrice()+" && "+drk.getDes();
    }
}
