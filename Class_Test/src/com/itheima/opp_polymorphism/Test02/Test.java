package com.itheima.opp_polymorphism.Test02;

public class Test {


    public static void main(String[] args) {
        Dog dog = new Dog(2, "黑色");
        Cat cat = new Cat(3,"白色");

        Person p1 = new Person("老王", 30);
        p1.keepPet(dog, "骨头");

        Person p2 = new Person("老赵", 40);
        p2.keepPet(cat, "鱼");

    }

}
