package packagetst01;

import java.util.Random;
import java.util.Scanner;

public class Arithmetical {
    public class Main {
        public static void main(String[] args) {
            int numQuestions = 3;
            int correctCount = 0;
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < numQuestions; i++) {
                // 生成两个随机数
                int num1 = generateRandomNumber(10, 99);
                int num2 = generateRandomNumber(10, 99);

                // 输出问题并获取学生答案
                System.out.print(num1 + " + " + num2 + " = ");
                int studentAnswer = scanner.nextInt();

                // 检查答案是否正确
                int correctAnswer = num1 + num2;
                if (studentAnswer == correctAnswer) {
                    System.out.println("回答正确！");
                    correctCount++;
                } else {
                    System.out.println("回答错误！");
                }
            }

            // 计算正确率并输出结果
            double accuracy = (double) correctCount / numQuestions * 100;
            System.out.println("正确率: " + accuracy + "%");

            // 关闭输入流
            scanner.close();
        }

        // 生成指定范围内的随机数
        private static int generateRandomNumber(int min, int max) {
            Random random = new Random();
            return random.nextInt(max - min + 1) + min;
        }
    }
}
