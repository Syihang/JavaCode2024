package Experiment8;

import java.util.Scanner;

public class sy8_6 {
    public static void main(String args[]) {
        for (;;) {
            System.out.print("������Triangle, Rectangle or Circle������End�˳�:");
            Scanner keyin = new Scanner(System.in);// ����
            String strxx = keyin.nextLine();

            // �������Ϊ�գ������ѭ���ȴ�����
            if (strxx.length() == 0) continue;

            // �������ַ���ת���ɴ�д����ȡ��һ���ַ���ֵ��charxx
            char charxx = Character.toUpperCase(strxx.charAt(0));

            switch (charxx) {
                case 'T':
                    System.out.println("��ѡ���������");
                    break;
                case 'R':
                    System.out.println("��ѡ��ľ���");
                    break;
                case 'C':
                    System.out.println("��ѡ���Բ��");
                    break;
                case 'E':
                    System.out.println("�������˳���");
                    System.exit(0); // �˳�����
                default:
                    System.out.println("�����ѡ�����������룡");
            } // end switch
        } // end for
    }// end main
}