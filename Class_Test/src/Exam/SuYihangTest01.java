// 苏一行 2205006224
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

        System.out.println("请输入" + NUM_PERSON + "名观众的姓名:");
        for(int i = 0; i < NUM_PERSON; i++){
            String na = sc.next();
            name.add(na);
        }

        System.out.println("你输入的观众姓名为:");
        for (String x:name){
            System.out.print(x + " ");
        }

        System.out.println("");

        System.out.println("随机选择一个观众，结果为:");

        System.out.println(name.get(random.nextInt(NUM_PERSON)));
    }
}
