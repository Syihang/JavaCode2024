package com.itheima._interface;

import java.util.Random;

public abstract class Animal {

    private String name;
    private int age;

    public abstract void eat();

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(Animal a){
        if (a instanceof Dog dog){
            System.out.println("The dog name is " + dog.getName() + ", age is " + getAge());
        }
        else if (a instanceof Frog frog){
            System.out.println("The frog name is " + frog.getName() + ",  and age is " + getAge());
        }
        else if (a instanceof Rabbit rabbit){
            System.out.println("The rabbit name is " + rabbit.getName() + ",  and age is " + getAge());
        }
        else{
            System.out.println("The class is not found");
        }
    }
}
