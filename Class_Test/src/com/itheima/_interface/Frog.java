package com.itheima._interface;

public class Frog extends Animal implements Swim{
    @Override
    public void eat() {
        System.out.println("eat bug");
    }

    @Override
    public void swim() {
        System.out.println("frog swim");
    }

    public Frog(String name, int age) {
        super(name, age);
    }

    public Frog() {
    }
}
