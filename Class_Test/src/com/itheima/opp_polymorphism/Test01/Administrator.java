package com.itheima.opp_polymorphism.Test01;

public class Administrator extends Person{
    @Override
    public void show(){
        System.out.println("管理员信息为:" + getName() + " " + getAge());
    }
}
