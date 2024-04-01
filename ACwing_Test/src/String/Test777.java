package String;

import java.util.Scanner;

public class Test777 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char flag;
        do {
            int[] hash = new int[26];
            String str = sc.next();
            char[] chs = str.toCharArray();
            for (char ch:chs) {
                hash[(int)ch - 'a'] ++;
                int Max = 0;
                for (int x:hash){
                    Max = Math.max(x,Max);
                }
                System.out.println(Max);
            }

            flag = chs[0];
        }while (flag != '.');
    }
}
