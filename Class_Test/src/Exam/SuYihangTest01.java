// ��һ�� 2205006224
package Exam;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SuYihangTest01 {

    public static void main(String[] args) {
        final int NUM_PERSON = 3;

        ArrayList<String> name = new ArrayList<>();
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("������" + NUM_PERSON + "�����ڵ�����:");
        for(int i = 0; i < NUM_PERSON; i++){
            String na = sc.next();
            name.add(na);
        }

        System.out.println("������Ĺ�������Ϊ:");
        for (String x:name){
            System.out.print(x + " ");
        }

        System.out.println("");

        System.out.println("���ѡ��һ�����ڣ����Ϊ:");

        System.out.println(name.get(random.nextInt(NUM_PERSON)));
    }
}
