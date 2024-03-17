package Method;

import java.util.Scanner;

public class Test809_lcm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(lcm(m,n));
    }

    public static int lcm(int m, int n){
        return m * n /gcd(m, n);
    }

    public static int gcd(int m, int n){
        while (m * n != 0){
            if (m > n) m %= n;
            else n %= m;
        }

        return m + n;
    }
}
