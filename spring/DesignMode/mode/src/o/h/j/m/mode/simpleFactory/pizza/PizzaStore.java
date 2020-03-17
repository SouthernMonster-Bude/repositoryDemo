package o.h.j.m.mode.simpleFactory.pizza;

public abstract class Pizza {
    private String name;
    public abstract void prepare();
    public void bake(){
        System.out.println(name + " is baking");
    }
    public void cut(){
        System.out.println(name + " is cutting");
    }
    public void box(){
        System.out.println(name + " is boxing");
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
class CheesePizza extends Pizza{
    @Override
    public void prepare() {
        this.setName("CheesePizza");
        System.out.println(this.getName() + " is preparing");
    }
}
class GreekPizza extends Pizza{
    @Override
    public void prepare() {
        this.setName("GreekPizza");
        System.out.println(this.getName() + " is preparing");
    }
}
