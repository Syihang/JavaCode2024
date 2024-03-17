package Experiment2;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber0 {
    public static void main(String[] args){

        int times = 3;     // 比赛次数
        Scanner sc = new Scanner(System.in);

        int winCount = 0;   // 获胜次数
        int loseCount = 0;  // 失败次数
        int tieCount = 0;   // 平局次数
        String[] choices = {"石头", "剪刀", "布"};

        System.out.println("游戏开始!");
        while (times != 0){
            System.out.println("请输入你的选择(石头\\剪刀\\布):");
            String userChoise = sc.nextLine().trim();

            int userIdenx = -1;
            for(int i = 0; i <= 2; i++){
                if(userChoise.equals(choices[i])) userIdenx = i;
            }
//            System.out.println(userChoise + " " + userIdenx);
            if(userIdenx == -1){
                System.out.println("输入无效,请重新输入...");
                continue;
            }

            int computerIdenx = numberRandom(0,2);
            String computerChoise = choices[computerIdenx];

            System.out.print("你选择了" + userChoise + ",计算机选择了" + computerChoise + ",结果是:");
            if(userIdenx == computerIdenx){
                System.out.println("平局!");
                tieCount ++;
            }
            else if(userIdenx == 0 && computerIdenx == 1 ||
                    userIdenx == 1 && computerIdenx == 2 ||
                    userIdenx == 2 && computerIdenx == 0){
                System.out.println("你赢了!");
                winCount ++;
            }
            else{
                System.out.println("你输了!");
                loseCount ++;
            }

            times --;
        }

        System.out.println("游戏结束,共进行了" + (winCount + loseCount + tieCount) + "次游戏");
        System.out.println("你获胜了 " + winCount + " 次");
        System.out.println("你失败了 " + loseCount + " 次");
        System.out.println("你平局了 " + tieCount + " 次");
    }

    // 生成min到max之间的随机数.
    private static int numberRandom(int min,int max){
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}
