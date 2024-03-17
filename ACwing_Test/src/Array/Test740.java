package Array;

import java.util.Scanner;

// 异或运算符交换数组间的元素
public class Test740 {
    public static void main(String[] args) {
        int[] N = new int[20];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 20; i++) N[i] = sc.nextInt();

        for (int i = 0, j = 19; i < j; i++, j--){
            N[i] = N[i] ^ N[j];
            N[j] = N[i] ^ N[j];
            N[i] = N[i] ^ N[j];
        }

        for (int i = 0; i < 20 ;i++) System.out.printf("N[%d] = %d", i, N[i]);
    }
}
