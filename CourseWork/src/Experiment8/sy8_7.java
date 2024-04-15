package Experiment8;

import java.time.Year;
import java.time.YearMonth;
import java.util.Scanner;

public class sy8_7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        //方法一计算结果：
        System.out.println("通过方法一求得" + year + "年的2月有:" + getFebruaryDays01(year) + "天");
        //方法二计算结果：
        System.out.println("通过方法二求得" + year + "年的2月有:" + getFebruaryDays02(year) + "天");
        // 方法三计算结果：
        System.out.println("通过方法三求得" + year + "年的2月有:" + getFebruaryDays03(year) + "天");
    }

//    方法一：使用Java的Year类
    static int getFebruaryDays01(int year){
        return Year.of(year).isLeap() ? 29 : 28;
    }

//    方法二：使用Java 8的YearMonth类
    static int getFebruaryDays02(int year) {
        return YearMonth.of(year, 2).lengthOfMonth();
    }

//    方法三：使用闰年规则计算
    static int getFebruaryDays03(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ? 29 : 28;
    }
}
