package com.itheima.abstraction;

public class Frog extends Animal{

    @Override
    public void eat() {
        System.out.println("�Գ���");
    }

    public Frog() {
    }

    public Frog(String name, int age) {
        super(name, age);
    }
}
