package Experiment8;

//import java.util.*;
//import java.text.*;

public class sy8_1 {
    public static void main(String args[]) {
        // ��ȡ������Ϣ
        String str = new String("");
        System.out.println("str�����������" + str.getClass().getName());
        System.out.println("str����ĸ�������" + str.getClass().getSuperclass().getName());
        System.out.println("����İ�����" + str.getClass().getPackage().getName());

        // ��ȡϵͳ��Ϣ
        System.out.println("����ϵͳ��" + System.getProperty("os.name"));
        System.out.println("����ϵͳ�汾��" + System.getProperty("os.version"));

        // ��ȡJava�������Ϣ
        System.out.println("Java������汾��" + System.getProperty("java.vm.version"));
        System.out.println("Java(JDK)�汾��" + System.getProperty("java.version"));

        // ��ȡ�ڴ���Ϣ
        Runtime runtime = Runtime.getRuntime();
        System.out.println("�ڴ�������" + runtime.totalMemory());
        System.out.println("�����ڴ棺" + runtime.freeMemory());

        // ��������������
        runtime.gc();

        // ��ȡ������������������ڴ���Ϣ
        System.out.println("\n����������������");
        System.out.println("�ڴ�������" + runtime.totalMemory());
        System.out.println("�����ڴ棺" + runtime.freeMemory());
    }
}

