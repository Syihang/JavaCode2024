package Experiment3;

import java.util.Arrays;
import java.util.Random;

public class StudentManageSystemGPT {

    public static class ClassGradeAnalyzer {
        private static final int NUM_STUDENTS = 30; // ѧ������
        private static final int NUM_SUBJECTS = 5; // �γ�����
        private static final int GRADE_RANGE = 101; // �ɼ���Χ��0-100��

        private final int[][] grades; // �ɼ�����

        public ClassGradeAnalyzer() {
            grades = new int[NUM_STUDENTS][NUM_SUBJECTS];
            initializeGrades(); // ��ʼ���ɼ�����
        }

        // ��ʼ���ɼ����飬�������ѧ���ĳɼ�
        private void initializeGrades() {
            Random random = new Random();

            for (int i = 0; i < NUM_STUDENTS; i++) {
                for (int j = 0; j < NUM_SUBJECTS; j++) {
                    grades[i][j] = random.nextInt(GRADE_RANGE);
                }
            }
        }

        // ͳ��ĳ��ѧ����ƽ���ɼ�
        public double calculateAverageGrade(int studentIndex) {
            int sum = 0;
            for (int j = 0; j < NUM_SUBJECTS; j++) {
                sum += grades[studentIndex][j];
            }
            return (double)sum / NUM_SUBJECTS;
        }

        // ͳ��ĳ�ſγ̵���߷�
        public int calculateMaxGrade(int subjectIndex) {
            int max = grades[0][subjectIndex];
            for (int i = 1; i < NUM_STUDENTS; i++) {
                if (grades[i][subjectIndex] > max) {
                    max = grades[i][subjectIndex];
                }
            }
            return max;
        }

        // ͳ��ĳ�ſγ̵�ƽ����
        public double calculateAverageGradeForSubject(int subjectIndex) {
            int sum = 0;
            for (int i = 0; i < NUM_STUDENTS; i++) {
                sum += grades[i][subjectIndex];
            }
            return (double)sum / NUM_STUDENTS;
        }

        // �԰༶��ÿλѧ���ĳɼ���������
        public void sortGrades() {
            Arrays.sort(grades, (a, b) -> {
                double avgA = Arrays.stream(a).average().orElse(0);
                double avgB = Arrays.stream(b).average().orElse(0);
                return Double.compare(avgB, avgA); // ��������
            });
        }

        // �ж�ѧ���Ƿ��ܹ�����Ϊ����ѧ���������ɲ�
        public boolean isExcellentStudent(int studentIndex) {
            int[] studentGrades = grades[studentIndex];
            double average = Arrays.stream(studentGrades).average().orElse(0);
            int numAboveAverage = (int)Arrays.stream(studentGrades).filter(g -> g > average).count();
            return numAboveAverage >= 3;
        }

        // ���ѡȡ5��ͬѧ���������
        public void randomlySelectStudents() {
            Random random = new Random();
            int[] selectedIndexes = new int[5];
            boolean[] visited = new boolean[NUM_STUDENTS];

            for (int i = 0; i < 5; i++) {
                int index = random.nextInt(NUM_STUDENTS);
                while (visited[index]) {
                    index = random.nextInt(NUM_STUDENTS);
                }
                selectedIndexes[i] = index;
                visited[index] = true;
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("ѧ��������" + getStudentName(selectedIndexes[i]));
            }
        }

        // ����ѧ��������ȡѧ��������ʾ����������Ҫ����ʵ������޸ģ�
        private String getStudentName(int studentIndex) {
            // ����ѧ������
            // ���Դ����ݿ����������Դ�л�ȡѧ��������Ϣ
            return "ѧ��" + (studentIndex + 1);
        }

        public static void main(String[] args) {
            ClassGradeAnalyzer analyzer = new ClassGradeAnalyzer();

            // ͳ��ĳ��ѧ����ƽ���ɼ�
            int studentIndex = 0; // ����Ҫͳ�Ƶ�һ��ѧ����ƽ���ɼ�
            double averageGrade = analyzer.calculateAverageGrade(studentIndex);
            System.out.println("ѧ��" + (studentIndex + 1) + "��ƽ���ɼ�Ϊ��" + averageGrade);

            // ͳ��ĳ�ſγ̵���߷ֺ�ƽ����
            int subjectIndex = 0; // ����Ҫͳ�Ƶ�һ�ſγ̵ĳɼ�
            int maxGrade = analyzer.calculateMaxGrade(subjectIndex);
            double averageGradeForSubject = analyzer.calculateAverageGradeForSubject(subjectIndex);
            System.out.println("��" + (subjectIndex + 1) + "�ſγ̵���߷�Ϊ��" + maxGrade);
            System.out.println("��" + (subjectIndex + 1) + "�ſγ̵�ƽ����Ϊ��" + averageGradeForSubject);

            // �԰༶��ÿλѧ���ĳɼ���������
            analyzer.sortGrades();

            // �ж�ĳ��ѧ���Ƿ��ܹ�����Ϊ����ѧ���������ɲ�
            studentIndex = 0; // ����Ҫ�жϵ�һ��ѧ��
            boolean isExcellentStudent = analyzer.isExcellentStudent(studentIndex);
            System.out.println("ѧ��" + (studentIndex + 1) + "�Ƿ��ܹ�����Ϊ����ѧ���������ɲ���" + isExcellentStudent);

            // ���ѡȡ5��ͬѧ���������
            analyzer.randomlySelectStudents();
        }
    }

}
