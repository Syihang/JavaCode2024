package Experiment8;

public class sy8_4 {
    public static void main(String args[]) {
        Integer a = new Integer("123"); //声明并实例化Integer类的对象a，给a赋值为“123”,JDK5之前的方法
        int b = a + 2;
        System.out.println(a + "+2=" + b);

        //思考，可否将此句改为int a=new Integer("123");

        // 不可以，虽然在Java中，自动装箱（Autoboxing）和拆箱（Unboxing）
        // 能够让基本数据类型和其对应的包装类之间进行隐式转换，
        // 试图将一个 Integer 对象直接赋值给一个 int 类型的变量是行不通的。

        // 包装类的其他功能
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
