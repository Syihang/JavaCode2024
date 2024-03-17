package Array;

import java.util.Scanner;

public class Test742 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = 1001, min_index = 0;
        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            if (x < min){
                min_index = i;
                min = x;
            }
        }

        System.out.println("Minimum value: " + min);
        System.out.println("Position: " + min_index);
    }
}
