package com.itheima.staticTest;

public class ArrayUtil {

    private ArrayUtil(){}

    public static String printArr(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {

            if (i == arr.length - 1) sb.append(arr[i]);

            else sb.append(arr[i]).append(",");

        }
        sb.append("]");
        return sb.toString();
    }

    public static double getAveriage(int[] arr){
        double sum = 0;
        for (double x : arr){
            sum += x;
        }

        return sum / arr.length;
    }
}
