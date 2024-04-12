package Experiment6.Part1;

public interface Biology {
    void breath();

    default void defaultMethod() {
        System.out.println("This is a default method in the Biology interface.");
    }

    static void staticMethod() {
        System.out.println("This is a static method in the Biology interface.");
    }
}
