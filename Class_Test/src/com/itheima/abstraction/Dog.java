package com.itheima.abstraction;

public class Dog extends Animal{

    @Override
    public void eat() {
        System.out.println("�Թ�ͷ");
    }

    Dog(){}

    Dog(String name, int age){
        super(name, age);
    }

}
