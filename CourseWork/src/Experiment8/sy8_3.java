package Experiment8;

import java.util.Random;  //导入包

class sy8_3 {
    public static void main(String[] args) {

        System.out.println(Math.random()); // 输出用Math类中的random产生的[0.0-1.0)之间的随机数

        Random random1 = new Random(12);
        System.out.println(random1.nextInt()); // 输出下一个随机整数
        System.out.println(random1.nextInt(11)); // 输出0-10之间的一个随机整数
        System.out.println(random1.nextDouble()); // 输出下一个随机浮点数
        System.out.println(random1.nextBoolean()); // 输出一个随机布尔值
    }
}