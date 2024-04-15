package Experiment8;

import java.util.*;

class sy8_2 {
    public static void main(String args[]) {
        double d1 = Math.sin(Math.toRadians(30)); // 计算30度角的正弦值
        double d2 = Math.log(Math.E); // 计算E的对数值
        double d3 = Math.pow(2, 3); // 计算2的3次方
        int r = Math.round(33.6F); // 四舍五入
        double area = Math.PI * Math.pow(5, 2); // 计算圆的面积

        System.out.println("30度角的正弦值： " + d1);
        System.out.println("E 的对数值：" + d2);
        System.out.println("2 的3 次方： " + d3);
        System.out.println("33.6F 四舍五入： "+r);
        System.out.println("半径为5的圆的面积是： " + area);
    }

    // 实现输入半径,输出圆的面积
    double getCircleArea(double radius){
        return Math.PI * Math.pow(radius, 2);
    }
}

