package o.h.j.m.mode.builder;

public class CommonHouseBuilder extends AbsHouseBuilder{

    @Override
    public void buildBasic() {
        this.house.setBaise("普通房子地基5米");
        System.out.println("普通房子地基5米");

    }

    @Override
    public void buildWalls() {
        this.house.setWall("普通房子墙体4面");
        System.out.println("普通房子墙体4面");
    }

    @Override
    public void roofed() {
        this.house.setRoot("普通房子屋顶平顶");
        System.out.println("普通房子屋顶平顶");
    }
}
