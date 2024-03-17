package Method;

import java.util.Scanner;

public class Test805_max {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(max(a,b));
    }

    public static int max(int a, int b){
        return a>b?a:b;
    }
}
