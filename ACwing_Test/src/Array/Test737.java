package Array;

import java.util.Scanner;

public class Test737 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0 ; i < 10; i++){
           int x = sc.nextInt();
            System.out.println(String.format("X[%d] = %d",i,(x>0?x:1)));
        }
    }
}
