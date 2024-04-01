package StringTest;

import java.util.Scanner;

public class Nestline {
    public static void main(String[] args) {
        test04();
    }

    public static void test01(){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();//键盘录入123
        System.out.println("此时为字符串" + s);//此时123是字符串
        int i = sc.nextInt(); // 键盘录入123
        System.out.println("此时为整数：" + i);
    }

    public static void test02() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();//键盘录入123
        System.out.println("此时为字符串" + s);//此时123是字符串
        int i = Integer.parseInt(s);//想要整数再进行转换
        System.out.println("此时为整数：" + i);
    }

    public static void test03() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();//键盘录入123
        System.out.println("此时为整数：" + i); // 123
        String s = sc.nextLine();//键盘录入123
        System.out.println("此时为字符串" + s);//字符串为空
    }

    public static void test04() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();//键盘录入123
        System.out.println("此时为字符串" + s);//此时123是字符串
        int i = sc.nextInt();//想要整数再进行转换
        System.out.println("此时为整数：" + i);
    }
}
