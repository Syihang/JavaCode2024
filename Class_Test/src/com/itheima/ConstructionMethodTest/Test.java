package com.itheima.ConstructionMethodTest;

public class Test {
    public static void main(String[] args) {
        Manger m = new Manger("test001", "����1", 123, 123);
        Cook c = new Cook("test002", "��ʦ1", 123);

        m.work();
        m.eat();

        c.work();
        c.eat();

        System.out.println(m.getMangerSalary() + " " + c.getName());
    }
}
