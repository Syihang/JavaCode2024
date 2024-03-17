package Method;

import java.util.Scanner;

public class Test812_PrintArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] a = new int[1005];
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        printArray(a,k);
    }

    public static void printArray(int[] a, int k){
        for (int i = 0; i < k; i ++ ){
            System.out.printf("%d ",a[i]);
        }
    }
}
