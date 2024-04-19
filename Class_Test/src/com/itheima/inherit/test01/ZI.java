package com.itheima.inherit.test01;

public class ZI extends Fu{

    String name = "Zi";

    public void ziShow(){
        String name = "ZiShow";
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }
}
