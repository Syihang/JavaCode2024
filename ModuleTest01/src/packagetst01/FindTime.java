//计科22101 苏一行 2205006224

package packagetst01;
import java.util.Scanner;

public class FindTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入速度:");
        float v = sc.nextFloat();
        System.out.println("请输入路程:");
        float s = sc.nextFloat();

        System.out.println("时间为:" + String.format("%.2f",s/v));
    }
}
