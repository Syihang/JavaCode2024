package Experiment5.Part02;

public class TransportTest {
    public static void main(String[] args) {
        Transport bike = new Bicycle();
        Transport car = new Car();

        bike.run();
        bike.FllowRules();

        car.run();
        car.FllowRules();

        // bike.ringBell(); // 报错，父类引用不能调用子类独有的方法
        // car.honk(); // 报错，父类引用不能调用子类独有的方法

        Bicycle bike2 = new Bicycle();
        Car car2 = new Car();

        bike2.ringBell();
        car2.honk();
    }
}