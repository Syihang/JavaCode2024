package ClassTest06;

public interface Biology {

    // 抽象方法
    void run();
    void eat();

    default void Bdefault() {
        System.out.println("这是动物的默认接口");
    }


}
