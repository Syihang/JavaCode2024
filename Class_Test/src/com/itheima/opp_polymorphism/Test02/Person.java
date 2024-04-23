package com.itheima.opp_polymorphism.Test02;

public class Person {

    private String name;
    private int age;

//    public void keepPet(Dog dog, String something){
//        System.out.println("年龄为" + this.age + "岁的" + this.name + "养了一条宠物狗");
//        System.out.println("年龄为" + dog.getAge() + "岁的" + dog.getColor() + "色宠物狗正在吃" + something);
//    }
//
//    public void keepPet(Cat cat, String something){
//        System.out.println("年龄为" + this.age + "岁的" + this.name + "养了一条宠物狗");
//        System.out.println("年龄为" + cat.getAge() + "岁的" + cat.getColor() + "色宠物猫正在吃" + something);
//    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
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

    public void keepPet(Animal a, String something){
        if (a instanceof Cat cat)
        {
            System.out.println("年龄为" + this.age + "岁的" + this.name + "养了一条宠物狗");
            System.out.println("年龄为" + cat.getAge() + "岁的" + cat.getColor() + "色宠物猫正在吃" + something);
        } else if(a instanceof Dog dog){
            System.out.println("年龄为" + this.age + "岁的" + this.name + "养了一条宠物狗");
            System.out.println("年龄为" + dog.getAge() + "岁的" + dog.getColor() + "色宠物狗正在吃" + something);
        }
        else {
            System.out.println("类型不存在");
        }
    }
}
