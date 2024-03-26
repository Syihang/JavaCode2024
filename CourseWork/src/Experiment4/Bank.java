package Experiment4;

import java.util.Scanner;

public class Bank {

    static String bankName = "�й���������";

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
        System.out.print("����������:");
        double num = sc.nextDouble();
        this.balance = this.balance + num;
        System.out.printf("���ɹ����˻����Ϊ:%.2fԪ\n", this.balance);
    }

    public void drawMoney() {

        System.out.print("����������:");
        int i = 3;
        while (i  > 0) {
            i -= 1;
            String pass = sc.next();
            if (this.getPassword().equals(pass)) {
                System.out.println("�˻����Ϊ:" + this.getBalance());
                System.out.print("������ȡ����:");
                int num = sc.nextInt();

                if (num > this.balance) {
                    System.out.println("����,ȡ��ʧ��...");
                    return ;
                }
                else {
                    this.balance = this.balance - num;
                    System.out.printf("ȡ��ɹ�,�˻���Ϊ: %.2f Ԫ\n", this.balance);
                    return ;
                }
            }

            else {
                if (i != 0)
                System.out.println("�������,�㻹��" + i + "�λ���,����������");
            }
        }

        System.out.println("ȡ��ʧ��,�˻��ѱ�����");

    }

    public void findBalance() {
        System.out.println("�û���:" + this.getUsername());
        System.out.println("��ʣ���:" + this.getBalance());
    }

    public void showUser() {

        System.out.print("����������:");
        int i = 3;
        while (i  > 0) {
            i -= 1;
            String pass = sc.next();
            if (this.getPassword().equals(pass)) {
                System.out.println("������:\t" + bankName);
                System.out.println("�û���:\t" + this.getUsername());
                System.out.println("����:\t" + this.getPassword());
                System.out.println("�ͻ�:\t" + this.getName());
                System.out.println("���:\t" + String.format("%.2f", this.getBalance()));
                System.out.println();
                return ;
            }

            else {
                if (i != 0)
                System.out.println("�������,�㻹��" + i + "�λ���,����������");
            }
        }

        System.out.println("��ѯʧ��,�˻��ѱ�����");

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
