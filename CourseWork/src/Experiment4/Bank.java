package Experiment4;

import java.util.Scanner;

public class Bank {

    static String bankName = "中国人民银行";

    private String username;
    private String password;
    private String name;
    private double balance;

    static Scanner sc = new Scanner(System.in);

    public Bank(String username, String password, String name, double balance) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.balance = balance;
    }

    public Bank() {}

    public void saveMoney() {
        System.out.print("请输入存款金额:");
        double num = sc.nextDouble();
        this.balance = this.balance + num;
        System.out.printf("存款成功，账户余额为:%.2f元\n", this.balance);
    }

    public void drawMoney() {

        System.out.print("请输入密码:");
        int i = 3;
        while (i  > 0) {
            i -= 1;
            String pass = sc.next();
            if (this.getPassword().equals(pass)) {
                System.out.println("账户余额为:" + this.getBalance());
                System.out.print("请输入取款金额:");
                int num = sc.nextInt();

                if (num > this.balance) {
                    System.out.println("余额不足,取款失败...");
                    return ;
                }
                else {
                    this.balance = this.balance - num;
                    System.out.printf("取款成功,账户余为: %.2f 元\n", this.balance);
                    return ;
                }
            }

            else {
                if (i != 0)
                System.out.println("密码错误,你还有" + i + "次机会,请重新输入");
            }
        }

        System.out.println("取款失败,账户已被锁定");

    }

    public void findBalance() {
        System.out.println("用户名:" + this.getUsername());
        System.out.println("所剩余额:" + this.getBalance());
    }

    public void showUser() {

        System.out.print("请输入密码:");
        int i = 3;
        while (i  > 0) {
            i -= 1;
            String pass = sc.next();
            if (this.getPassword().equals(pass)) {
                System.out.println("开户行:\t" + bankName);
                System.out.println("用户名:\t" + this.getUsername());
                System.out.println("密码:\t" + this.getPassword());
                System.out.println("客户:\t" + this.getName());
                System.out.println("余额:\t" + String.format("%.2f", this.getBalance()));
                System.out.println();
                return ;
            }

            else {
                if (i != 0)
                System.out.println("密码错误,你还有" + i + "次机会,请重新输入");
            }
        }

        System.out.println("查询失败,账户已被锁定");

    }


    public static String getBankName() {
        return bankName;
    }

    public static void setBankName(String bankName) {
        Bank.bankName = bankName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
