package o.h.j.m.mode.builder;

//建造者
public abstract class AbsHouseBuilder {
    protected House house = new House();

    //建造流程
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    public House builderHouse(){
        return house;
    }

}
