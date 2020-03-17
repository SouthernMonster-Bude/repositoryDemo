package o.h.j.m.mode.simpleFactory.pizza;


public class PizzaStore {
    private String pizzaType;
    private SimpleFactory simpleFactory;
    PizzaStore(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
        Thread t = new Thread(() -> {
            try {
                makePizza();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();

    }
    public void makePizza() throws InterruptedException {
        do{
            Pizza pizza = simpleFactory.makePizza(this.getOrder());
            if(pizza == null){
                System.out.println("现在没有pizza需要制作");
                Thread.sleep(200L);
                continue;
            }

        }while(true);
    }

    private String getOrder() {
        String p = pizzaType;
        pizzaType = null;
        return p;
    }
    public void setOrder(String pt) {
        this.pizzaType = pt;
    }
}

class SimpleFactory{
    public Pizza makePizza(String pType) throws InterruptedException {
        Pizza pizza = null;
        if ("Greek".equals(pType)) {
            pizza = new GreekPizza();
        } else if ("Cheese".equals(pType)) {
            pizza = new CheesePizza();
        } else if ("Pepper".equals(pType)) {
            pizza = new PepperPizza();
        } else {
            return null;
        }
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}


abstract class Pizza {
    private String name;

    public abstract void prepare();

    public void bake() {
        System.out.println(name + " is baking");
    }

    public void cut() {
        System.out.println(name + " is cutting");
    }

    public void box() {
        System.out.println(name + " is boxing");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class CheesePizza extends Pizza {
    CheesePizza(){
        prepare();
    }
    @Override
    public void prepare() {
        this.setName("CheesePizza");
        System.out.println(this.getName() + " is preparing Raw materials");
    }
}

class GreekPizza extends Pizza {
    GreekPizza(){
        prepare();
    }
    @Override
    public void prepare() {
        this.setName("GreekPizza");
        System.out.println(this.getName() + " is preparing Raw materials");
    }
}
class PepperPizza extends Pizza {
    PepperPizza(){
        prepare();
    }
    @Override
    public void prepare() {
        this.setName("PepperPizza");
        System.out.println(this.getName() + " is preparing Raw materials");
    }
}
