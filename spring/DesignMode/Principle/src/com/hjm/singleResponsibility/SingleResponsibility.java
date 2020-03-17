package com.hjm;

public class SingleResponsibility {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        //此处就暴露了Vehicle职责单一问题
        vehicle.run("汽车");
        vehicle.run("飞机");
        vehicle.run("轮船");
        //解决办法就是讲各个对象的职责抽离 单一实现 但是开销太大
        System.out.println("修正之后");
        new VehicleCar().run("汽车");
        new VehiclePlane().run("飞机");
        new VehicleShip().run("轮船");
        // 方案2 就是方法层次对单一职责的实现
        System.out.println("方案2 修正之后");
        vehicle.runRoad("汽车");
        vehicle.runAir("飞机");
        vehicle.runWater("轮船");
    }
}

class Vehicle{
    public void run(String name){
        System.out.println(name + "在路上跑....");
    }
    public void runRoad(String name){
        System.out.println(name + "在路上跑....");
    }
    public void runWater(String name){
        System.out.println(name + "在水里跑....");
    }
    public void runAir(String name){
        System.out.println(name + "在天上跑....");
    }
}
class VehicleCar{
    public void run(String name){
        System.out.println(name + "在路上跑....");
    }
}
class VehiclePlane{
    public void run(String name){
        System.out.println(name + "在天上跑....");
    }
}
class VehicleShip{
    public void run(String name){
        System.out.println(name + "在水里跑....");
    }
}
