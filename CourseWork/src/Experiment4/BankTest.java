package Experiment4;

import java.util.ArrayList;
import java.util.Scanner;

public class BankTest {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Bank> User = new ArrayList<>();

    public static void openingBank() {  // ����
        String userName;
        String password;
        String name;
        double balance;

        System.out.print("�������û���:");
        userName = sc.next();

        if (isExistUesrName(userName)) {
            System.out.println("����ʧ�ܣ��û����ظ�...");
            return;
        }

        System.out.print("����������:");
        password = sc.next();

        System.out.print("������ͻ�����:");
        name = sc.next();

        System.out.print("�����һ�����:");
        balance = sc.nextDouble();

        Bank temp = new Bank(userName, password, name, balance);
        User.add(temp);

        System.out.println("�����ɹ���");

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
        System.out.print("�������û���:");
        String user = sc.next();
        if (findUserByUserName(user) == null) {
            System.out.println("���ʧ��,�û���������...");
        }
        else {
            findUserByUserName(user).saveMoney();
        }
    }

    public static void draw() {
        System.out.print("�������û���:");
        String user = sc.next();
        if (findUserByUserName(user) == null) {
            System.out.println("ȡ��ʧ��,�û���������...");
        }
        else {
            findUserByUserName(user).drawMoney();
        }
    }

    public static void queryInformation() {
        System.out.print("�������û���:");
        String user = sc.next();
        if (findUserByUserName(user) == null) {
            System.out.println("��ѯʧ��,�û���������...");
        }
        else {
            findUserByUserName(user).showUser();
        }
    }

    public static void menu() {
        System.out.println("****************");
        System.out.println("��ӭ��������ϵͳ");
        System.out.println("0. �˳�����");
        System.out.println("1. ����");
        System.out.println("2. ���");
        System.out.println("3. ȡ��");
        System.out.println("4. ��ѯ���");
        System.out.println("5. ��ʾ�˺���Ϣ");
        System.out.println("****************");
    }

    public static void findBalance() {
        System.out.print("�������û���:");
        String user = sc.next();
        if (findUserByUserName(user) == null) {
            System.out.println("��ѯʧ��,�û���������...");
        }
        else {
            findUserByUserName(user).findBalance();
        }
    }

    public static void main(String[] args) {

        while (true) {
            menu();
            System.out.println("��������ִ�еĲ���:");
            int n = sc.nextInt();
            if (n == 0) break;
            switch (n) {
                case 1 -> openingBank();
                case 2 -> save();
                case 3 -> draw();
                case 4 -> findBalance();
                case 5 -> queryInformation();
                default -> System.out.println("��������,����������...");
            }
        }
    }

}
