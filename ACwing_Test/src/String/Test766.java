package String;

import java.util.Scanner;

public class Test766 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = sc.nextLine();
        char[] chs = str.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            boolean flag = false;
            while(chs[i] == ' ' && i < chs.length - 1) {
                i ++;
                flag = true;
            }
            if (flag) System.out.print(' ');
            System.out.print(chs[i]);
        }
    }
}
