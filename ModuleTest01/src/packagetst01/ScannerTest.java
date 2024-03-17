package packagetst01;

// 1.导包
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        //2.创建对象
        Scanner sc = new Scanner(System.in);

        //3.接收数据
        System.out.println("请输入任意整数:");
        int a = sc.nextInt();

        System.out.println("请输入任意整数:");
        int b = sc.nextInt();

        System.out.println(a + b);
    }
}
