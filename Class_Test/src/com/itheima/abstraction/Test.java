package com.itheima.abstraction;

public class Test {

    public static void main(String[] args) {
        Frog f = new Frog("xiaolv", 1);

        System.out.println(f.getName() + ", " + f.getAge());

        f.drink();

        f.eat();
    }
}
