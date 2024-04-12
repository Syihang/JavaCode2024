package Experiment7.expe1;

public class sy7_1_3 {
    public static void main(String args[]) {
        int i;
        int a[] = {1, 2, 3, 4};
        System.out.println("********程序开始************");
        try {
            for (i = 0; i < 5; i++) {
                System.out.println("a[" + i + "]/" + i + "=" + (a[i] / i));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获到了数组下标越界异常：" + e);
        } catch (ArithmeticException e) {
            System.out.println("捕获到了算术异常：" + e);
        }
        System.out.println("********程序结束************");
    } //end main
} // class
