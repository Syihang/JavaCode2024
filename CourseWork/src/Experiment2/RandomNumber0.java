package Experiment2;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber0 {
    public static void main(String[] args){

        int times = 3;     // ��������
        Scanner sc = new Scanner(System.in);

        int winCount = 0;   // ��ʤ����
        int loseCount = 0;  // ʧ�ܴ���
        int tieCount = 0;   // ƽ�ִ���
        String[] choices = {"ʯͷ", "����", "��"};

        System.out.println("��Ϸ��ʼ!");
        while (times != 0){
            System.out.println("���������ѡ��(ʯͷ\\����\\��):");
            String userChoise = sc.nextLine().trim();

            int userIdenx = -1;
            for(int i = 0; i <= 2; i++){
                if(userChoise.equals(choices[i])) userIdenx = i;
            }
//            System.out.println(userChoise + " " + userIdenx);
            if(userIdenx == -1){
                System.out.println("������Ч,����������...");
                continue;
            }

            int computerIdenx = numberRandom(0,2);
            String computerChoise = choices[computerIdenx];

            System.out.print("��ѡ����" + userChoise + ",�����ѡ����" + computerChoise + ",�����:");
            if(userIdenx == computerIdenx){
                System.out.println("ƽ��!");
                tieCount ++;
            }
            else if(userIdenx == 0 && computerIdenx == 1 ||
                    userIdenx == 1 && computerIdenx == 2 ||
                    userIdenx == 2 && computerIdenx == 0){
                System.out.println("��Ӯ��!");
                winCount ++;
            }
            else{
                System.out.println("������!");
                loseCount ++;
            }

            times --;
        }

        System.out.println("��Ϸ����,��������" + (winCount + loseCount + tieCount) + "����Ϸ");
        System.out.println("���ʤ�� " + winCount + " ��");
        System.out.println("��ʧ���� " + loseCount + " ��");
        System.out.println("��ƽ���� " + tieCount + " ��");
    }

    // ����min��max֮��������.
    private static int numberRandom(int min,int max){
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}
