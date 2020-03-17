package o.h.j.m.mode.simpleFactory.pizza;

public class OrderPizza {
    public static String[] pts = {"Greek","Cheese","Pepper"};
    public static void main(String[] args) throws InterruptedException {
        PizzaStore pizzaStore = new PizzaStore(new SimpleFactory());
        OrderPizza client = new OrderPizza();
        Thread t = new Thread(() -> {
            while (true){
                try {
                    client.order(pizzaStore, pts[(int)(Math.random()*pts.length)]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

    }

    public void order(PizzaStore ps, String pt) throws InterruptedException {
        ps.setOrder(pt);
    }
}
