package Experiment8;

//import java.util.*;
//import java.text.*;

public class sy8_1 {
    public static void main(String args[]) {
        // 获取对象信息
        String str = new String("");
        System.out.println("str对象的类名：" + str.getClass().getName());
        System.out.println("str对象的父类名：" + str.getClass().getSuperclass().getName());
        System.out.println("对象的包名：" + str.getClass().getPackage().getName());

        // 获取系统信息
        System.out.println("操作系统：" + System.getProperty("os.name"));
        System.out.println("操作系统版本：" + System.getProperty("os.version"));

        // 获取Java虚拟机信息
        System.out.println("Java虚拟机版本：" + System.getProperty("java.vm.version"));
        System.out.println("Java(JDK)版本：" + System.getProperty("java.version"));

        // 获取内存信息
        Runtime runtime = Runtime.getRuntime();
        System.out.println("内存总量：" + runtime.totalMemory());
        System.out.println("空闲内存：" + runtime.freeMemory());

        // 运行垃圾回收器
        runtime.gc();

        // 获取运行垃圾回收器后的内存信息
        System.out.println("\n运行垃圾回收器后");
        System.out.println("内存总量：" + runtime.totalMemory());
        System.out.println("空闲内存：" + runtime.freeMemory());
    }
}

