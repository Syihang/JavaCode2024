package Array;

import java.util.Scanner;

public class Test741 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] Fib = new long[61];
        Fib[0] = 0;
        Fib[1] = 1;
        for (int i = 2; i < 61; i++) Fib[i] = Fib[i-1] + Fib[i-2];
        int n = sc.nextInt();
        while (n-- != 0){
            int x = sc.nextInt();
            System.out.printf("Fib(%d) = %d", x, Fib[x]);
        }
    }
}
