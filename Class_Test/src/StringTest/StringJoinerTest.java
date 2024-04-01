package StringTest;

import java.util.StringJoiner;

public class StringJoinerTest {
    public static void main(String[] args) {

        StringJoiner sj = new StringJoiner(",","[","]");

        String num = "123456789";

        char[] chs = num.toCharArray();

        for(char ch:chs) {
            sj.add(ch + "");
        }

        System.out.println(sj); // [1,2,3,4,5,6,7,8,9]

        String s = sj.toString();

        System.out.println(s); // [1,2,3,4,5,6,7,8,9]

        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12};
        StringJoiner nsj = new StringJoiner(",","[","]");

        for (int x:nums) {
            nsj.add(x + "");
        }
        System.out.println(nsj);
    }
}
