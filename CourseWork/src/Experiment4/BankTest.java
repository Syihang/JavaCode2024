package Experiment4;

import java.util.ArrayList;
import java.util.Scanner;

public class BankTest {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Bank> User = new ArrayList<>();

    public static void openingBank() {  // 开户
        String userName;
        String password;
        String name;
        double balance;

        System.out.print("请输入用户名:");
        userName = sc.next();

        if (isExistUesrName(userName)) {
            System.out.println("开户失败，用户名重复...");
            return;
        }

        System.out.print("请输入密码:");
        password = sc.next();

        System.out.print("请输入客户姓名:");
        name = sc.next();

        System.out.print("请存入一定金额:");
        balance = sc.nextDouble();

        Bank temp = new Bank(userName, password, name, balance);
        User.add(temp);

        System.out.println("开户成功！");

    }

    public static boolean isExistUesrName(String userName){
        if (User.isEmpty()) return false;
        for (Bank x:User) {
            if (x.getUsername().equals(userName)) return true;
        }
        return false;
    }

    public static Bank findUserByUserName(String userName) {
        for (Bank x:User) {
            if (x.getUsername().equals(userName)) return x;
        }
        return null;
    }

    public static void save() {
        System.out.print("请输入用户名:");
        String user = sc.next();
        if (findUserByUserName(user) == null) {
            System.out.println("存款失败,用户名不存在...");
        }
        else {
            findUserByUserName(user).saveMoney();
        }
    }

    public static void draw() {
        System.out.print("请输入用户名:");
        String user = sc.next();
        if (findUserByUserName(user) == null) {
            System.out.println("取款失败,用户名不存在...");
        }
        else {
            findUserByUserName(user).drawMoney();
        }
    }

    public static void queryInformation() {
        System.out.print("请输入用户名:");
        String user = sc.next();
        if (findUserByUserName(user) == null) {
            System.out.println("查询失败,用户名不存在...");
        }
        else {
            findUserByUserName(user).showUser();
        }
    }

    public static void menu() {
        System.out.println("****************");
        System.out.println("欢迎访问银行系统");
        System.out.println("0. 退出程序");
        System.out.println("1. 开户");
        System.out.println("2. 存款");
        System.out.println("3. 取款");
        System.out.println("4. 查询余额");
        System.out.println("5. 显示账号信息");
        System.out.println("****************");
    }

    public static void findBalance() {
        System.out.print("请输入用户名:");
        String user = sc.next();
        if (findUserByUserName(user) == null) {
            System.out.println("查询失败,用户名不存在...");
        }
        else {
            findUserByUserName(user).findBalance();
        }
    }

    public static void main(String[] args) {

        while (true) {
            menu();
            System.out.println("请输你想执行的操作:");
            int n = sc.nextInt();
            if (n == 0) break;
            switch (n) {
                case 1 -> openingBank();
                case 2 -> save();
                case 3 -> draw();
                case 4 -> findBalance();
                case 5 -> queryInformation();
                default -> System.out.println("输入有误,请重新输入...");
            }
        }
    }

}
