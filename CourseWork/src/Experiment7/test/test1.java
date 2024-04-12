package Experiment7.test;

public class test1 {
    public static void main(String[] args) {
        int z;

        try{
            z = dv(7, 0);
            System.out.println(z);
        }
        catch (Exception e){
            System.out.println("´íÎóÀàĞÍ" + e);
        }
        finally {
            System.out.println("111");
        }

    }

    public static int dv(int a, int b){
        int c = a / b;
        return c;
    }
}
