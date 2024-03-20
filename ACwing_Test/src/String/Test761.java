package String;

import java.util.Scanner;

public class Test761 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str.toCharArray();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') cnt++;
        }
        System.out.println(cnt);
    }
}
