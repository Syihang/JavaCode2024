package packagetst01;

public class Method_Load {
    public static void main(String[] args) {
        int a = 2, b = 3;
        System.out.println(mul(a, b));
        int c = 5;
        System.out.println(mul(a, b, c));
        double x = 11.7, y = 23.4;
        System.out.println(mul(3.4D, 4.2D));

    }

    public static int mul(int i1, int i2){
        return i1 * i2;
    }

    public static int mul(int a, int b, int c){
        return a * b * c;
    }

    public static double mul(double d1, double d2){
        return d1 * d2;
    }
}
