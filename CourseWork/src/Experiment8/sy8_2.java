package Experiment8;

import java.util.*;

class sy8_2 {
    public static void main(String args[]) {
        double d1 = Math.sin(Math.toRadians(30)); // ����30�Ƚǵ�����ֵ
        double d2 = Math.log(Math.E); // ����E�Ķ���ֵ
        double d3 = Math.pow(2, 3); // ����2��3�η�
        int r = Math.round(33.6F); // ��������
        double area = Math.PI * Math.pow(5, 2); // ����Բ�����

        System.out.println("30�Ƚǵ�����ֵ�� " + d1);
        System.out.println("E �Ķ���ֵ��" + d2);
        System.out.println("2 ��3 �η��� " + d3);
        System.out.println("33.6F �������룺 "+r);
        System.out.println("�뾶Ϊ5��Բ������ǣ� " + area);
    }

    // ʵ������뾶,���Բ�����
    double getCircleArea(double radius){
        return Math.PI * Math.pow(radius, 2);
    }
}

