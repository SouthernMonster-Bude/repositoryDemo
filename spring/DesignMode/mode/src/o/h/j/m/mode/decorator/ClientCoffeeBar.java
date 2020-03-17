package o.h.j.m.mode.decorator;

public class ClietCoffeeBar {
    public static void main(String[] args) {
        //1.点一份LongBlack
        Drink order = new LongBlack();
        System.out.println(order.cost());
        //2.添加一份牛奶
        order = new Milk(order);
        System.out.println(order.cost());
    }
}
