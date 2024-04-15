package com.itheima.PackagingGroup;

public class PackagingGroup {
    public static void main(String[] args) {

        // 1.利用构造方法获取Integer的对象（JDK5以前的方式）
        Integer i1 = new Integer(1);
        Integer i2 = new Integer("1");
        System.out.println(i1);
        System.out.println(i2);

        // 2.利用静态方法获取Integer的对象（JDK5以前的方式）
        Integer i3 = Integer.valueOf(123);
        Integer i4 = Integer.valueOf("123");
        Integer i5 = Integer.valueOf("123",8); // 八进制下的123
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);

        // 把整数转换为二进制
        String str1 = Integer.toBinaryString(100);
        System.out.println(str1);

        // 把整数转换为八进制
        String str2 = Integer.toOctalString(100);
        System.out.println(str2);

        // 把整数转换为十六进制
        String str3 = Integer.toHexString(100);
        System.out.println(str3);


    }
}
