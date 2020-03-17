package o.h.j.m.mode.decorator;

import o.h.j.m.mode.decorator.coffee.LongBlack;
import o.h.j.m.mode.decorator.decr.Chocolate;
import o.h.j.m.mode.decorator.decr.Milk;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ClientCoffeeBar {
    public static void main(String[] args) throws FileNotFoundException {
//        //1.点一份LongBlack
//        Drink order = new LongBlack();
//        System.out.println(order.cost());
//        //2.添加一份牛奶
//        order = new Milk(order);
//        System.out.println(order.cost());
//        //3.再添加一份巧克力
//        order = new Chocolate(order);
//        System.out.println(order.cost());
        DataInputStream dis = new DataInputStream(new FileInputStream("a.txt"));

    }
}
