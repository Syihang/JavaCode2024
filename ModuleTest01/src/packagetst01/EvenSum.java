package packagetst01;

public class EvenSum {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1;i <= 20; i++){
            if(i % 2 == 0){
                sum += i;
            }
        }

        System.out.println("1-20之间的偶数和为:" + sum);
    }
}
