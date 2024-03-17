package Method;

import java.util.Scanner;

public class Test811_swap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[] a = {x, y};

        System.out.println(a[0] + " " + a[1]);
    }

    public static void swap(int a[]){
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;
    }
}
