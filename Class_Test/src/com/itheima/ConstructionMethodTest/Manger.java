package com.itheima.ConstructionMethodTest;

public class Manger extends Employee{

    private int mangerSalary;

    public Manger() { }

    public Manger(String id, String name, int salary, int mangerSalary) {
        super(id, name, salary);
        this.mangerSalary = mangerSalary;
    }

    @Override
    public void work(){
        System.out.println("管理他人");
    }

    public int getMangerSalary() {
        return mangerSalary;
    }

    public void setMangerSalary(int mangerSalary) {
        this.mangerSalary = mangerSalary;
    }
}
