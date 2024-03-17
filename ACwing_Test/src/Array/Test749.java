package Array;

import java.util.Scanner;

public class Test749 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ch = sc.next();
        double temp;
        int cnt = 0;
        double sum = 0.0D;
        for (int i = 0; i < 12; i++){
            for (int j = 0; j < 12; j++){
                temp = sc.nextDouble();
                if (j > i && i + j < 12-1) {
                    sum += temp;
                    cnt ++;
                }
            }
        }

        if(ch.equals("S")) System.out.println(String.format("%.1f", sum));
        else System.out.println(String.format("%.1f", sum / cnt));
    }
}
