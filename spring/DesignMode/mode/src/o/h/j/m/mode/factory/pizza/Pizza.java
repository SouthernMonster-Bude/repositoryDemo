package o.h.j.m.mode.factory.pizza;


public abstract class Pizza {
    private String name;
    public Pizza() {prepare();}
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
