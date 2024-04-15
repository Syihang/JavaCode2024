package Experiment8;

public class sy8_5 {
    public static void main(String args[]) {
        String n1 = "aaa";
        String n2 = "ccc", n3 = "a";

        System.out.println("获取字符串n1的长度：" + n1.length());
        System.out.println("获取字符串n1中下标位置为2的字符：" + n1.charAt(2));
        System.out.println("从n1下表为1的位置开始获取n1的子串：" + n1.substring(1));
        System.out.println("比较字符串n1与n2是否相同：" + n1.equals(n2));
        // 依据字典序顺序比较两个字符串中第一个不相同位置字符的大小，并返回其差值，若两字符串相等则返回0
        System.out.println("字符串比较结果：" + n1.compareTo(n2));
        System.out.println("字符串比较结果：" + n1.compareTo(n3));
    }
}
