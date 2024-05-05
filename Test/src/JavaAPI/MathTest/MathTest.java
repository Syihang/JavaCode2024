package JavaAPI.MathTest;

public class MathTest {
    public static void main(String[] args) {
        // ceil() 向上取整
        System.out.println(Math.ceil(12.34));
        System.out.println(Math.ceil(-12.34));

        // floor() 向下取整
        System.out.println(Math.floor(12.34));
        System.out.println(Math.floor(-12.34));

        // round() 四舍五入
        System.out.println(Math.round(12.34));
        System.out.println(Math.round(12.56));
        System.out.println(Math.round(-12.34));
        System.out.println(Math.round(-12.56));

        // max() 获取最大值
        System.out.println(Math.max(12, 13));
        System.out.println(Math.max(-12, -13));

        // pow() 求幂
        System.out.println(Math.pow(4, 0.5));
        System.out.println(Math.pow(2, -2));

        // sqrt() 开平方, cbrt() 立方
        System.out.println(Math.sqrt(4));
        System.out.println(Math.cbrt(9));

        int cnt = 0;
        // random() 获取[0, 1) 之间的随机数
        for (int i = 0; i < 1000; i++) {
            int num = (int)(Math.random() * 100 + 1);
//            System.out.println(num); // 1 - 100 之间的随机数
            cnt += num;
        }
        System.out.println(cnt / 1000);
    }
}
