package Experiment3;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class StudentManageSystem {
    public static final int NUM_STUDENTS = 6; // ѧ������
    public static final int NUM_SUBJECTS = 6; // �γ�����

    static int[][] grades = new int[NUM_STUDENTS][NUM_SUBJECTS]; // ѧ���ɼ�
    static double[] averages = new double[NUM_STUDENTS]; // ѧ��ƽ����
    static String[] names = new String[NUM_STUDENTS]; // ѧ������
    static String[] subjects = new String[]{"Java", "����", "��Ӣ", "����", "Web", "˼��"};
    static Scanner sc = new Scanner(System.in);
    // ��ȡѧ����Ϣ
    public static void getGrades(){

        for (int i = 0; i < NUM_STUDENTS; i++){
            System.out.println("������ѧ��" + (i + 1) + "����:");
            names[i] = sc.next();
            for (int j = 0; j < NUM_SUBJECTS; j++){
                System.out.printf("������%s��%s�ɼ�:", names[i], subjects[j]);
                grades[i][j] = sc.nextInt();
            }
        }
    }
    public static void autoGetGrades(){
        String[] autoNames = new String[]{"��һ��", "������", "������", "�����", "�ߟ�", "������"};
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
        System.out.printf("��¼��%dλͬѧ��%d�ſ��Գɼ�\n",NUM_STUDENTS, NUM_SUBJECTS);
    }
    // ���ѧ����Ϣ
    public static void putGrades(){
        System.out.printf("%-10s","����");

        for (int i = 0; i < NUM_SUBJECTS; i++){
            System.out.printf("%-5s\t",subjects[i]);
        }

        System.out.printf("%-5s\n","ƽ����");

        getAverage();

        for (int i = 0; i <  NUM_STUDENTS; i++){
            System.out.printf("%-10s",names[i]);
            for (int j = 0; j < NUM_SUBJECTS; j++){
                System.out.printf("%-5d\t",grades[i][j]);
            }
            System.out.printf("%-5.1f\n",averages[i]);
        }
    }
    // ��ȡƽ����
    public static void getAverage(){
        for (int i = 0; i < NUM_STUDENTS; i++) {
            double sum = 0;
            for (int j = 0; j < NUM_SUBJECTS; j++){
                sum += grades[i][j];
            }
            averages[i] = sum/NUM_SUBJECTS;
        }
    }
    // ����ѧ��
    public static int findStudent(String name){
        for (int i = 0 ;i < NUM_STUDENTS; i++){
            if (name.equals(names[i])) return i;
        }
        return -1;
    }
    // ���ҿ�Ŀ
    public static int findSubject(String sub){
        for (int i = 0 ;i < NUM_SUBJECTS; i++){
            if (sub.equals(subjects[i])) return i;
        }
        return -1;
    }
    // ��ȡѧ��ƽ����
    public static void getStudentAverage(){
        System.out.print("������ѧ������:");
        String name = sc.next();
        int index = findStudent(name);
        getAverage();
        if(index != -1){
            System.out.println("ѧ��" + names[index] + "��ƽ���ɼ�Ϊ:" + String.format("%.2f",averages[index]));
        }
        else{
            System.out.println("�༶��û�и�ѧ��!");
        }
    }
    // ��ȡĳ��Ŀ�ɼ�
    public static void getSubjectScore(){
        System.out.print("�������Ŀ����:");
        String sub = sc.next();
        int index = findSubject(sub);
        if (index != -1){
            int maxScoreStudentIndex = -1;
            int maxScore = 0;
            int sumScore = 0;
            // ���ƽ���ɼ�����߳ɼ���ѧ��id
            for (int i = 0 ;i < NUM_STUDENTS; i++){
                sumScore += grades[i][index];
                if (grades[i][index] > maxScore){
                    maxScore = grades[i][index];
                    maxScoreStudentIndex = i;
                }
            }

            System.out.println(subjects[index] + "�İ༶ƽ���ɼ�Ϊ:" + String.format("%.2f",(float)sumScore/NUM_SUBJECTS));
            System.out.println("��߳ɼ�Ϊ" + names[maxScoreStudentIndex] + "��ȡ��" + grades[maxScoreStudentIndex][index]);
        }
        else{
            System.out.println("���Կ�Ŀû��" + sub + "!");
        }
    }
    // ��������ѧ����ȫ����Ϣ
    public static void swapAll(int i,int j){
        int tempInt;
        double tempDouble;
        String tempString;
        // ����ƽ����
        tempDouble = averages[i];
        averages[i] = averages[j];
        averages[j] = tempDouble;
        // ��������
        tempString = names[i];
        names[i] = names[j];
        names[j] = tempString;
        // ����ѧ�Ƴɼ�
        for (int t = 0; t < NUM_SUBJECTS; t++){
            tempInt = grades[i][t];
            grades[i][t] = grades[j][t];
            grades[j][t] = tempInt;
        }
    }
    // ��ƽ���ֽ�������
    public static void SortbyAverage(){
        getAverage();
        for (int i = 0; i < NUM_STUDENTS; i ++){
            for (int j = 0; j < NUM_STUDENTS; j++){
                if(averages[i] > averages[j]){
                    swapAll(i,j);
                }
            }
        }
        System.out.println("���������!");
    }
    // �ж��Ƿ�Ϊ����ѧ��
    public static boolean isTreeGoodStudent(int index){
        for (int i = 0; i < NUM_SUBJECTS; i++){
            if (grades[index][i] < 80) return false;
        }
        return true;
    }
    // �ж��Ƿ�Ϊ����ѧ���ɲ�
    public static boolean isOutstandingStudentLeader(int index){
        for (int i = 0; i < NUM_SUBJECTS; i++){
            if(grades[index][i] < 80) return false;
        }
        System.out.printf("������%s�ĵ����ɼ�:", names[index]);
        int score = sc.nextInt();
        if (score < 80) return false;
        System.out.printf("%s�Ƿ�Ϊѧ���ɲ�(��/��):",names[index]);
        String isLeader = sc.next();
        return isLeader.equals("��");
    }
    // ��ӡ�жϽ��
    public static void isGood(){
        System.out.print("������ѧ������:");
        String name = sc.next();
        int index = findStudent(name);
        if (index != -1){
            System.out.println(names[index] + (isTreeGoodStudent(index) ? "��":"����") + "����ѧ��");
            System.out.println(names[index] + (isOutstandingStudentLeader(index) ? "��":"����") + "����ѧ���ɲ�");
        }
        else {
            System.out.println("�༶��û��ѧ��" + name);
        }
    }
    // ���ѡ��
    public static void getRandomStudents() {
        System.out.printf("��������Ҫѡȡ��ѧ������(1-%d��):",NUM_STUDENTS);
        int n = sc.nextInt();

        Set<Integer> randomNumbers = new HashSet<>();
        Random random = new Random(); // ����Ϊȥ��

        if (n > NUM_STUDENTS) {
            System.out.printf("��Ϊѧ������Ϊ%d����������ֻ�����ѡȡ%d��ѧ��\n",NUM_STUDENTS, NUM_STUDENTS);
        }
        while (randomNumbers.size() < Math.min(n, NUM_STUDENTS)) {
            int randomNumber = random.nextInt(NUM_STUDENTS); // ����0-NUM_STUDENTS��Χ�ڵ������
            randomNumbers.add(randomNumber);
        }

        System.out.printf("���ѡȡ��%d����ͬѧ��Ϊ:",Math.min(n, NUM_STUDENTS));
        for (int num : randomNumbers) {
            System.out.print(names[num] + " ");
        }
        System.out.println("");
    }
    // �˵�
    public static void Menu(){

        System.out.println("0. �˳�����         1. �������ѧ���ɼ�");
        System.out.println("2. ����ĳѧ���ɼ�    3. ͳ��ĳ�γ̳ɼ�");
        System.out.println("4. ��ƽ��������      5. ���ѡ��");
        System.out.println("6. �ж��Ƿ�Ϊ����ѧ��");
        System.out.print("������������еĲ���:");
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
                default -> System.out.println("������������������...");
            }
        }
        System.out.println("��л����ʹ��!");
    }
}
