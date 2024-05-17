package JavaAPI.RuntimeTest;

import java.io.IOException;

public class RuntimeTest {

    public static void main(String[] args) throws IOException {

        // 1.获取Runtime对象
        Runtime r1 = Runtime.getRuntime();

        Runtime r2 = Runtime.getRuntime();

        System.out.println(r1 == r2);

        // 2. 停止虚拟机
//        Runtime.getRuntime().exit(0);

        // 3. 获取CPU的线程数
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 4.获取总内存大小 （byte）
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);

        // 5.已经获取的内存大小
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);

        // 6.剩余内存大小
        System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);

        // 7.运行cmd命令
//        for(int i = 0; i < 10;i++)

        // shutdown : 关机
        // -s:默认在1一分钟后关机
        // -s -t 指定关机时间
        // -a : 取消关机操作
        // -r: 关机并重启
        Runtime.getRuntime().exec("");
        // shutdown -s -t 一分钟后关机
        // shutdown -a 取消关机

    }

}
