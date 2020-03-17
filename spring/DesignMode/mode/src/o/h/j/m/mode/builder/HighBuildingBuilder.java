package o.h.j.m.mode.builder;

public class HighBuilding extends AbsHouseBuilder{

    @Override
    public void buildBasic() {
        System.out.println("高楼地基50米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼墙体400面");
    }

    @Override
    public void roofed() {
        System.out.println("高楼屋顶玻璃顶");
    }
}
