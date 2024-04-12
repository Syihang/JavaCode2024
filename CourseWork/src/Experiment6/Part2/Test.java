package Experiment6.Part2;

public class Test {
    public static void main(String[] args) {
        DeepSeaRobot deepSeaRobot = new DeepSeaRobot("2023-05-15", "DSR-2000");
        deepSeaRobot.work();
        deepSeaRobot.charge();
        deepSeaRobot.place();
        deepSeaRobot.printAttributes();
    }
}
