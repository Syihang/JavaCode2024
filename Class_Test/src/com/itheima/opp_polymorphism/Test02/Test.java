package com.itheima.opp_polymorphism.Test02;

public class Test {


    public static void main(String[] args) {
        Dog dog = new Dog(2, "��ɫ");
        Cat cat = new Cat(3,"��ɫ");

        Person p1 = new Person("����", 30);
        p1.keepPet(dog, "��ͷ");

        Person p2 = new Person("����", 40);
        p2.keepPet(cat, "��");

    }

}
