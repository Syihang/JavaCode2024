package Experiment7.expe1;

public class sy7_1_3 {
    public static void main(String args[]) {
        int i;
        int a[] = {1, 2, 3, 4};
        System.out.println("********����ʼ************");
        try {
            for (i = 0; i < 5; i++) {
                System.out.println("a[" + i + "]/" + i + "=" + (a[i] / i));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("�����������±�Խ���쳣��" + e);
        } catch (ArithmeticException e) {
            System.out.println("�����������쳣��" + e);
        }
        System.out.println("********�������************");
    } //end main
} // class
