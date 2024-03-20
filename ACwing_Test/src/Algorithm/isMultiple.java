package Algorithm;

import java.util.Scanner;

public class isMultiple {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        test02();
    }

    public static void test02() {
        for (int i = -100 ; i < 10000; i++) {
            if ((i & -i) == i) System.out.println(i);
        }
    }

    public static void test01() {
        int n = sc.nextInt();

        if ((n & -n) == n) {
            System.out.println(n + "是二的整数次幂");
        }
        else {
            System.out.println(n + "不是二的整数次幂");
        }
    }

}
