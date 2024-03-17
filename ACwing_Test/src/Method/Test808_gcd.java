package Method;

import java.util.Scanner;

public class Test808_gcd {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(gct(a, b));
    }

    public static int gct(int a, int b){
        while(a * b != 0){
            if (a > b) a = a % b;
            else b = b % a;
        }
        return a + b;
    }
}
