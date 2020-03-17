package o.h.j.m.mode.factory.pizza;

import o.h.j.m.mode.factory.absfactory.AbsPizzaFactory;
import o.h.j.m.mode.factory.factory.BJPizzaFactory;
import o.h.j.m.mode.factory.factory.LDPizzaFactory;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class PizzaStote {
    AbsPizzaFactory pizzaFactory;

    public void setPizzaFactory(AbsPizzaFactory pizzaFactory){
        this.pizzaFactory = pizzaFactory;

    }

    public static void main(String[] args) {
        Calendar.getInstance(TimeZone.getDefault(), Locale.CANADA);
    }
//    public static void main(String[] args) {
//        //工厂模式
//        //北京店
//        new BJPizzaFactory().makePizza("BJHJ");
//        //伦敦店
//        new LDPizzaFactory().makePizza("LDHJ");
//
//        //抽象工厂模式
//        String pyType = "BJNL";
//        AbsPizzaFactory pizzaFactory = null;
//        if(pyType.startsWith("BJ")){
//            pizzaFactory = new o.h.j.m.mode.factory.absfactory.BJPizzaFactory();
//        }else if(pyType.startsWith("LD")){
//            pizzaFactory = new o.h.j.m.mode.factory.absfactory.LDPizzaFactory();
//        }else {
//
//        }
//        pizzaFactory.makePizza(pyType);
//    }
}
