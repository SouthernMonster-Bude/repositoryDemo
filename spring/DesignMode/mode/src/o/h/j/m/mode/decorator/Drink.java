package o.h.j.m.mode.decorator;

public abstract class Drink {
    private String des;
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    //计算此类饮品的抽象方法
    public abstract float cost();
}
