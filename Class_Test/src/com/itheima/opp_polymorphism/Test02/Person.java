package com.itheima.opp_polymorphism.Test02;

public class Person {

    private String name;
    private int age;

//    public void keepPet(Dog dog, String something){
//        System.out.println("����Ϊ" + this.age + "���" + this.name + "����һ�����ﹷ");
//        System.out.println("����Ϊ" + dog.getAge() + "���" + dog.getColor() + "ɫ���ﹷ���ڳ�" + something);
//    }
//
//    public void keepPet(Cat cat, String something){
//        System.out.println("����Ϊ" + this.age + "���" + this.name + "����һ�����ﹷ");
//        System.out.println("����Ϊ" + cat.getAge() + "���" + cat.getColor() + "ɫ����è���ڳ�" + something);
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
            System.out.println("����Ϊ" + this.age + "���" + this.name + "����һ�����ﹷ");
            System.out.println("����Ϊ" + cat.getAge() + "���" + cat.getColor() + "ɫ����è���ڳ�" + something);
        } else if(a instanceof Dog dog){
            System.out.println("����Ϊ" + this.age + "���" + this.name + "����һ�����ﹷ");
            System.out.println("����Ϊ" + dog.getAge() + "���" + dog.getColor() + "ɫ���ﹷ���ڳ�" + something);
        }
        else {
            System.out.println("���Ͳ�����");
        }
    }
}
