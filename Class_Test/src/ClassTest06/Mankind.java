package ClassTest06;

public interface Mankind extends Biology, Animal{

    void study();
    void think();

    default void Mdefault() {
        System.out.println("这是人类的默认接口");
    }

    static void Mstatic() {
        System.out.println("这是人类的静态接口");
    }
}
