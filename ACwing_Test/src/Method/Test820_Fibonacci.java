package Method;

import java.util.Scanner;

public class Test820_Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(Fibonacci(n));
    }

    public static int Fibonacci(int n){
        if(n == 0 || n == 1) return n;
        else return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
