package Experiment8;

import java.time.Year;
import java.time.YearMonth;
import java.util.Scanner;

public class sy8_7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        //����һ��������
        System.out.println("ͨ������һ���" + year + "���2����:" + getFebruaryDays01(year) + "��");
        //��������������
        System.out.println("ͨ�����������" + year + "���2����:" + getFebruaryDays02(year) + "��");
        // ��������������
        System.out.println("ͨ�����������" + year + "���2����:" + getFebruaryDays03(year) + "��");
    }

//    ����һ��ʹ��Java��Year��
    static int getFebruaryDays01(int year){
        return Year.of(year).isLeap() ? 29 : 28;
    }

//    ��������ʹ��Java 8��YearMonth��
    static int getFebruaryDays02(int year) {
        return YearMonth.of(year, 2).lengthOfMonth();
    }

//    ��������ʹ������������
    static int getFebruaryDays03(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ? 29 : 28;
    }
}
