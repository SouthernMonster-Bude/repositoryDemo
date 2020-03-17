package o.h.j.m.mode.builder;
//指挥者 指挥建造流程
public class HouseDirector {
    private AbsHouseBuilder houseBuilder;

    public HouseDirector(AbsHouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(AbsHouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //如何建筑房子 流程控制由指挥者控制
    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.builderHouse();
    }

}
