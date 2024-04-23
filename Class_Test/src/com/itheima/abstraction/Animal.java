package com.itheima.abstraction;

public abstract class Animal {

    private String name;
    private int age;

    public abstract void eat();

    public void drink(){
        System.out.println("ºÈË®");
    }

    Animal(){}

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
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

}
