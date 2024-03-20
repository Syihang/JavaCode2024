package String;

import java.util.Scanner;

public class Test769 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char ch = sc.next().charAt(0);
        char[] chars = str.toCharArray();

        for (char x:chars) {
            if (x == ch) System.out.print('#');
            else System.out.print(x);
        }
    }
}
