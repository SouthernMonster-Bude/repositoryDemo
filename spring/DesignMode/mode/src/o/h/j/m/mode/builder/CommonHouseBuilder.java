package o.h.j.m.mode.builder;

public class CommonHouse extends AbsHouseBuilder{

    @Override
    public void buildBasic() {
        System.out.println("普通房子地基5米");

    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子墙体4面");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子屋顶平顶");
    }
}
