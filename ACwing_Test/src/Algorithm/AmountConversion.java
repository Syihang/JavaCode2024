package Algorithm;

import java.util.Scanner;

public class AmountConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(amountConversion(num));
    }

    public static String amountConversion (int num) {
        String str = "零壹贰叁肆伍陆柒扒玖拾";
        char[] upperCase = str.toCharArray();
        String[] capitalUnit = {"元", "拾", "佰", "仟", "萬", "拾", "佰", "仟", "亿"};
        String ans = "";
//        int n = (int)(Math.log10(num) + 1);
        while (num != 0) {
            int flag = num%10;
            num = num/10;
            ans = upperCase[flag] + ans;
        }

        char[] ansChar = ans.toCharArray();
        int n = ansChar.length;
        String newAns = "";
        for (int i = 0; i < n; i++){
            int t = 0;
            while (i < n && ansChar[i] == '零'){
                i ++;
                t = 1;
                if (n-i-1 == 4 && ansChar[i] == '零') newAns = newAns + "萬";
                if (i == n-1) break;
            }
            if (t == 1){
                t = 0;
                newAns = newAns + '零';
            }
            if (i == n) i -= 1;
            newAns = newAns + ansChar[i];
            newAns = newAns + capitalUnit[n-i-1];
        }
        return newAns;
    }
}
