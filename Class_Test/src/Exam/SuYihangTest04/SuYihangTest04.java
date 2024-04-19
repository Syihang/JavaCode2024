// 苏一行 2205006224
package Exam.SuYihangTest04;

public class SuYihangTest04 {
    public static void main(String[] args) {
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

        // 获取当前时间
        System.out.println("当前时间：" + System.currentTimeMillis());
    }
}
