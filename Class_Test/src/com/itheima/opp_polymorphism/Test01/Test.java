package com.itheima.opp_polymorphism.Test01;

public class Test {
    public static void main(String[] args) {

        Student s = new Student();

        Teacher t = new Teacher();

        Administrator a = new Administrator();

        register(s);
        register(t);
        register(a);
    }

    public static void register(Person p) {
        p.show();
    }
}
