package com.itheima._interface;

public class Test {

    public static void main(String[] args) {
        Animal dog = new Dog("gou01", 3);

        Animal frog = new Frog("qingwa01", 1);

        Animal rabbit = new Rabbit();

        rabbit.setName("tuzi");
        rabbit.setAge(2);

        dog.show(dog);

        frog.show(frog);

        rabbit.show(rabbit);

    }
}
