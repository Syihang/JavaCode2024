package Array;

import java.util.Scanner;

public class Test743 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] M =new double[12][12];
        int n = sc.nextInt();
        char ch = sc.next().charAt(0);
        for (int i = 0; i < 12; i ++){
            for (int j = 0; j < 12; j ++){
                M[i][j] = sc.nextDouble();
            }
        }
        double sum = 0.0D;
        for (int i = 0; i < 12; i ++){
            sum += M[n - 1][i];
        }

        if(ch == 'S') System.out.printf("%.1f",sum);
        else System.out.printf("%.1f",sum/12);
    }
}
