package com.itheima._interface;

public class Dog extends Animal implements Swim{
    @Override
    public void eat() {
        System.out.println("eat bone");
    }

    @Override
    public void swim() {
        System.out.println("dog swim");
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public Dog() {
    }
}
