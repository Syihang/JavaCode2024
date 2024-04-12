package Experiment6.Part1;

public class Test {
    public static void main(String[] args) {
        NormalMan man = new NormalMan("Tom");
        man.breath();
        man.move();
        man.eat();
        man.study();
        man.think();

        man.defaultMethod();
        Biology.staticMethod();
    }
}