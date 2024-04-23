package com.itheima._interface;

public class Rabbit extends Animal{

    @Override
    public void eat() {
        System.out.println("eat carrot");
    }

    public Rabbit(String name, int age) {
        super(name, age);
    }

    public Rabbit() {
    }
}
