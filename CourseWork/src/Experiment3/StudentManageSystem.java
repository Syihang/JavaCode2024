package Experiment3;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class StudentManageSystem {
    public static final int NUM_STUDENTS = 6; // 学生数量
    public static final int NUM_SUBJECTS = 6; // 课程数量

    static int[][] grades = new int[NUM_STUDENTS][NUM_SUBJECTS]; // 学生成绩
    static double[] averages = new double[NUM_STUDENTS]; // 学生平均分
    static String[] names = new String[NUM_STUDENTS]; // 学生姓名
    static String[] subjects = new String[]{"Java", "高数", "大英", "大物", "Web", "思政"};
    static Scanner sc = new Scanner(System.in);
    // 获取学生信息
    public static void getGrades(){

        for (int i = 0; i < NUM_STUDENTS; i++){
            System.out.println("请输入学生" + (i + 1) + "姓名:");
            names[i] = sc.next();
            for (int j = 0; j < NUM_SUBJECTS; j++){
                System.out.printf("请输入%s的%s成绩:", names[i], subjects[j]);
                grades[i][j] = sc.nextInt();
            }
        }
    }
    public static void autoGetGrades(){
        String[] autoNames = new String[]{"苏一行", "李明杰", "吴煜鹏", "顾秋炜", "高燊", "马星宇"};
        int[][] autoGrades = {
                {100,100,99,98,99,98},
                {89,92,79,98,89,92},
                {87,92,93,95,93,91},
                {90,70,99,88,79,91},
                {87,89,89,91,94,96},
                {60,70,79,91,93,94}
        };
        for (int i = 0; i < NUM_STUDENTS; i ++){
            names[i] = autoNames[i];
        }

        for (int i = 0 ;i < NUM_STUDENTS; i++){
            for (int j = 0; j < NUM_SUBJECTS ;j ++){
                grades[i][j] = autoGrades[i][j];
            }
        }
        System.out.printf("已录入%d位同学的%d门考试成绩\n",NUM_STUDENTS, NUM_SUBJECTS);
    }
    // 输出学生信息
    public static void putGrades(){
        System.out.printf("%-10s","姓名");

        for (int i = 0; i < NUM_SUBJECTS; i++){
            System.out.printf("%-5s\t",subjects[i]);
        }

        System.out.printf("%-5s\n","平均分");

        getAverage();

        for (int i = 0; i <  NUM_STUDENTS; i++){
            System.out.printf("%-10s",names[i]);
            for (int j = 0; j < NUM_SUBJECTS; j++){
                System.out.printf("%-5d\t",grades[i][j]);
            }
            System.out.printf("%-5.1f\n",averages[i]);
        }
    }
    // 获取平均分
    public static void getAverage(){
        for (int i = 0; i < NUM_STUDENTS; i++) {
            double sum = 0;
            for (int j = 0; j < NUM_SUBJECTS; j++){
                sum += grades[i][j];
            }
            averages[i] = sum/NUM_SUBJECTS;
        }
    }
    // 查找学生
    public static int findStudent(String name){
        for (int i = 0 ;i < NUM_STUDENTS; i++){
            if (name.equals(names[i])) return i;
        }
        return -1;
    }
    // 查找科目
    public static int findSubject(String sub){
        for (int i = 0 ;i < NUM_SUBJECTS; i++){
            if (sub.equals(subjects[i])) return i;
        }
        return -1;
    }
    // 获取学生平均分
    public static void getStudentAverage(){
        System.out.print("请输入学生姓名:");
        String name = sc.next();
        int index = findStudent(name);
        getAverage();
        if(index != -1){
            System.out.println("学生" + names[index] + "的平均成绩为:" + String.format("%.2f",averages[index]));
        }
        else{
            System.out.println("班级中没有该学生!");
        }
    }
    // 获取某科目成绩
    public static void getSubjectScore(){
        System.out.print("请输入科目名称:");
        String sub = sc.next();
        int index = findSubject(sub);
        if (index != -1){
            int maxScoreStudentIndex = -1;
            int maxScore = 0;
            int sumScore = 0;
            // 获得平均成绩和最高成绩及学生id
            for (int i = 0 ;i < NUM_STUDENTS; i++){
                sumScore += grades[i][index];
                if (grades[i][index] > maxScore){
                    maxScore = grades[i][index];
                    maxScoreStudentIndex = i;
                }
            }

            System.out.println(subjects[index] + "的班级平均成绩为:" + String.format("%.2f",(float)sumScore/NUM_SUBJECTS));
            System.out.println("最高成绩为" + names[maxScoreStudentIndex] + "考取的" + grades[maxScoreStudentIndex][index]);
        }
        else{
            System.out.println("考试科目没有" + sub + "!");
        }
    }
    // 交换两个学生的全部信息
    public static void swapAll(int i,int j){
        int tempInt;
        double tempDouble;
        String tempString;
        // 交换平均分
        tempDouble = averages[i];
        averages[i] = averages[j];
        averages[j] = tempDouble;
        // 交换姓名
        tempString = names[i];
        names[i] = names[j];
        names[j] = tempString;
        // 交换学科成绩
        for (int t = 0; t < NUM_SUBJECTS; t++){
            tempInt = grades[i][t];
            grades[i][t] = grades[j][t];
            grades[j][t] = tempInt;
        }
    }
    // 按平均分进行排序
    public static void SortbyAverage(){
        getAverage();
        for (int i = 0; i < NUM_STUDENTS; i ++){
            for (int j = 0; j < NUM_STUDENTS; j++){
                if(averages[i] > averages[j]){
                    swapAll(i,j);
                }
            }
        }
        System.out.println("排序已完成!");
    }
    // 判断是否为三好学生
    public static boolean isTreeGoodStudent(int index){
        for (int i = 0; i < NUM_SUBJECTS; i++){
            if (grades[index][i] < 80) return false;
        }
        return true;
    }
    // 判断是否为优秀学生干部
    public static boolean isOutstandingStudentLeader(int index){
        for (int i = 0; i < NUM_SUBJECTS; i++){
            if(grades[index][i] < 80) return false;
        }
        System.out.printf("请输入%s的德育成绩:", names[index]);
        int score = sc.nextInt();
        if (score < 80) return false;
        System.out.printf("%s是否为学生干部(是/否):",names[index]);
        String isLeader = sc.next();
        return isLeader.equals("是");
    }
    // 打印判断结果
    public static void isGood(){
        System.out.print("请输入学生姓名:");
        String name = sc.next();
        int index = findStudent(name);
        if (index != -1){
            System.out.println(names[index] + (isTreeGoodStudent(index) ? "是":"不是") + "三好学生");
            System.out.println(names[index] + (isOutstandingStudentLeader(index) ? "是":"不是") + "优秀学生干部");
        }
        else {
            System.out.println("班级中没有学生" + name);
        }
    }
    // 随机选人
    public static void getRandomStudents() {
        System.out.printf("请输入你要选取的学生个数(1-%d个):",NUM_STUDENTS);
        int n = sc.nextInt();

        Set<Integer> randomNumbers = new HashSet<>();
        Random random = new Random(); // 作用为去重

        if (n > NUM_STUDENTS) {
            System.out.printf("因为学生总数为%d个，因此最大只能随机选取%d个学生\n",NUM_STUDENTS, NUM_STUDENTS);
        }
        while (randomNumbers.size() < Math.min(n, NUM_STUDENTS)) {
            int randomNumber = random.nextInt(NUM_STUDENTS); // 生成0-NUM_STUDENTS范围内的随机数
            randomNumbers.add(randomNumber);
        }

        System.out.printf("随机选取的%d个不同学生为:",Math.min(n, NUM_STUDENTS));
        for (int num : randomNumbers) {
            System.out.print(names[num] + " ");
        }
        System.out.println("");
    }
    // 菜单
    public static void Menu(){

        System.out.println("0. 退出程序         1. 输出所有学生成绩");
        System.out.println("2. 查找某学生成绩    3. 统计某课程成绩");
        System.out.println("4. 按平均分排序      5. 随机选人");
        System.out.println("6. 判断是否为三好学生");
        System.out.print("请输入你想进行的操作:");
    }


    public static void main(String[] args) {
        boolean scFlag = false;

        if (scFlag) getGrades();
        else autoGetGrades();

        while (true){
            Menu();
            int x = sc.nextInt();
            if (x == 0) break;
            switch (x) {
                case 1 -> putGrades();
                case 2 -> getStudentAverage();
                case 3 -> getSubjectScore();
                case 4 -> SortbyAverage();
                case 5 -> getRandomStudents();
                case 6 -> isGood();
                default -> System.out.println("输入有误，请重新输入...");
            }
        }
        System.out.println("感谢您的使用!");
    }
}
