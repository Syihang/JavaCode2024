package com.itheima.abstraction;

public class Sheep extends Animal{
    @Override
    public void eat() {
        System.out.println("³Ô²Ý");
    }

    public Sheep() {
    }

    public Sheep(String name, int age) {
        super(name, age);
    }
}
