package com.itheima.opp_polymorphism.Test02;

public class Dog extends Animal{

    public void lookHome(){
        System.out.println("¹·ÔÚ¿´¼Ò");
    }

    public Dog() {}

    public Dog(int age, String color) {
        super(age, color);
    }
}
