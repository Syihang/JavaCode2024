package com.itheima.inherit.test01;

public class Test02 {

}

class Fu_ {
    String name = "Fu";
    String hobby = "∫»≤Ë";

    public void show() {
        System.out.println(123);
    }

}

class Zi_ extends Fu_ {
    String name = "Zi";
    String game = "”Œœ∑";

    @Override
    public void show(){
        System.out.println(name);
        System.out.println(super.name);
        System.out.println(hobby);
        System.out.println(game);
        super.show();
    }

    public static void main(String[] args) {
        Zi_ z = new Zi_();
        z.show();
    }
}