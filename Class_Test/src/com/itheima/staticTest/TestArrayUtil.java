package com.itheima.staticTest;

public class TestArrayUtil {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        String str = ArrayUtil.printArr(arr1);
        System.out.println(str);

        double averiage = ArrayUtil.getAveriage(arr1);
        System.out.println(averiage);
    }
}
