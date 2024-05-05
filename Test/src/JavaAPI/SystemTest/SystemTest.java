package JavaAPI.SystemTest;

public class SystemTest {
    public static void main(String[] args) {

//        System.exit(0);

        // 返回1970年1月1日0点0分距离现在的毫秒数
        long star = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            for(int j = 0; j < 1000;j ++) {Math.pow(200, 1000);};
            System.out.println(System.currentTimeMillis());
        }
        long end = System.currentTimeMillis();
        System.out.println(end - star);


        // 拷贝数组
        int[] arr1 = {1, 2,3,4,5,6,7,8,9,10};
        int[] arr2 = new int[10];

        // 参数1， 数据源， 参数二: 开始索引 参数三: 拷贝到的位置 参数四:目的地数组索引 参数五:拷贝个数
        System.arraycopy(arr1, 3,  arr2, 3, 5);

        for (int x:arr2){
            System.out.print(x + " "); // 0 0 0 4 5 6 7 8 0 0
        }

    }

}
