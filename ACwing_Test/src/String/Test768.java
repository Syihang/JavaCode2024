package String;

import java.util.Scanner;

public class Test768 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int flag = s1.compareToIgnoreCase(s2);

        if (flag == 0) System.out.println("=");
        else if (flag < 0) System.out.println("<");
        else System.out.println(">");

        return;
    }
}
