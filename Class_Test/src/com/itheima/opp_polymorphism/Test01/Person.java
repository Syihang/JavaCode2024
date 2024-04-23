package com.itheima.opp_polymorphism.Test01;

public class Person {
    private System name;
    private int age;

    public Person(System name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public System getName() {
        return name;
    }

    public void setName(System name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println(name + " " + age);
    }
}
