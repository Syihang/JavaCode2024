package Experiment8;

import java.util.Scanner;

public class sy8_6 {
    public static void main(String args[]) {
        for (;;) {
            System.out.print("请输入Triangle, Rectangle or Circle，输入End退出:");
            Scanner keyin = new Scanner(System.in);// 输入
            String strxx = keyin.nextLine();

            // 如果输入为空，则继续循环等待输入
            if (strxx.length() == 0) continue;

            // 将输入字符串转换成大写，并取第一个字符赋值给charxx
            char charxx = Character.toUpperCase(strxx.charAt(0));

            switch (charxx) {
                case 'T':
                    System.out.println("你选择的三角形");
                    break;
                case 'R':
                    System.out.println("你选择的矩形");
                    break;
                case 'C':
                    System.out.println("你选择的圆形");
                    break;
                case 'E':
                    System.out.println("程序已退出。");
                    System.exit(0); // 退出程序
                default:
                    System.out.println("错误的选择，请重新输入！");
            } // end switch
        } // end for
    }// end main
}