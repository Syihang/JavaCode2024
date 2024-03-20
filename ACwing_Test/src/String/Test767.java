package String;

import java.util.Scanner;

public class Test767 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = sc.nextLine();

        char[] chs= str.toCharArray();

        for (char x:chs) {
            if (x <= 'z' && x >= 'a') System.out.print((char) ((x - 'a' + 1) % 26 + 'a'));
            else if (x <= 'Z' && x >= 'A') System.out.print((char)((x - 'A' + 1) % 26 + 'A'));
            else System.out.print(x);
        }
    }
}
