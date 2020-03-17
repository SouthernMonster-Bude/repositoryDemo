package o.h.j.m.mode.builder;

public class Client {

    public static void main(String[] args) {
        CommonHouseBuilder houseBuilder = new CommonHouseBuilder();

        HouseDirector director = new HouseDirector(houseBuilder);

        House house = director.constructHouse();

        System.out.println(house);

        StringBuilder stringBuilder = new StringBuilder("");
    }
}
