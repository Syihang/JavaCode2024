package Exam.SuYihangTest02;
// 苏一行2204006224
// 定义接口Person
interface Person {
    void work();
}

// 定义接口Machine
interface Machine {
    void charge();
}

// 定义接口Robot，继承Person和Machine接口，并添加抽象方法place()
interface Robot extends Person, Machine {
    void place();
}

// 定义类DeepSeaRobot，实现Robot接口
class DeepSeaRobot implements Robot {
    private String manufactureDate;
    private String brandModel;

    // 构造方法
    public DeepSeaRobot(String manufactureDate, String brandModel) {
        this.manufactureDate = manufactureDate;
        this.brandModel = brandModel;
    }

    // 实现抽象方法work()
    public void work() {
        System.out.println("Performing deep sea operations.");
    }

    // 实现抽象方法charge()
    public void charge() {
        System.out.println("Charging via induction.");
    }

    // 实现抽象方法place()
    public void place() {
        System.out.println("Placing the robot at a designated location.");
    }

    // 打印属性的方法
    public void printAttributes() {
        System.out.println("Manufacture Date: " + manufactureDate);
        System.out.println("Brand Model: " + brandModel);
    }
}

// 测试Demo类
public class SuYihangTest02Demo {
    public static void main(String[] args) {
        // 创建DeepSeaRobot对象
        DeepSeaRobot robot = new DeepSeaRobot("2024-04-19", "NUM-2205006224");
        // 调用方法
        robot.printAttributes();
        robot.work();
        robot.charge();
        robot.place();
    }
}
