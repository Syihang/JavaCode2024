package Experiment3;

import java.util.Arrays;
import java.util.Random;

public class StudentManageSystemGPT {

    public static class ClassGradeAnalyzer {
        private static final int NUM_STUDENTS = 30; // 学生数量
        private static final int NUM_SUBJECTS = 5; // 课程数量
        private static final int GRADE_RANGE = 101; // 成绩范围（0-100）

        private final int[][] grades; // 成绩数组

        public ClassGradeAnalyzer() {
            grades = new int[NUM_STUDENTS][NUM_SUBJECTS];
            initializeGrades(); // 初始化成绩数组
        }

        // 初始化成绩数组，随机生成学生的成绩
        private void initializeGrades() {
            Random random = new Random();

            for (int i = 0; i < NUM_STUDENTS; i++) {
                for (int j = 0; j < NUM_SUBJECTS; j++) {
                    grades[i][j] = random.nextInt(GRADE_RANGE);
                }
            }
        }

        // 统计某个学生的平均成绩
        public double calculateAverageGrade(int studentIndex) {
            int sum = 0;
            for (int j = 0; j < NUM_SUBJECTS; j++) {
                sum += grades[studentIndex][j];
            }
            return (double)sum / NUM_SUBJECTS;
        }

        // 统计某门课程的最高分
        public int calculateMaxGrade(int subjectIndex) {
            int max = grades[0][subjectIndex];
            for (int i = 1; i < NUM_STUDENTS; i++) {
                if (grades[i][subjectIndex] > max) {
                    max = grades[i][subjectIndex];
                }
            }
            return max;
        }

        // 统计某门课程的平均分
        public double calculateAverageGradeForSubject(int subjectIndex) {
            int sum = 0;
            for (int i = 0; i < NUM_STUDENTS; i++) {
                sum += grades[i][subjectIndex];
            }
            return (double)sum / NUM_STUDENTS;
        }

        // 对班级中每位学生的成绩进行排序
        public void sortGrades() {
            Arrays.sort(grades, (a, b) -> {
                double avgA = Arrays.stream(a).average().orElse(0);
                double avgB = Arrays.stream(b).average().orElse(0);
                return Double.compare(avgB, avgA); // 降序排序
            });
        }

        // 判断学生是否能够被评为三好学生或优秀班干部
        public boolean isExcellentStudent(int studentIndex) {
            int[] studentGrades = grades[studentIndex];
            double average = Arrays.stream(studentGrades).average().orElse(0);
            int numAboveAverage = (int)Arrays.stream(studentGrades).filter(g -> g > average).count();
            return numAboveAverage >= 3;
        }

        // 随机选取5名同学，输出姓名
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
                System.out.println("学生姓名：" + getStudentName(selectedIndexes[i]));
            }
        }

        // 根据学生索引获取学生姓名（示例方法，需要根据实际情况修改）
        private String getStudentName(int studentIndex) {
            // 返回学生姓名
            // 可以从数据库或其他数据源中获取学生姓名信息
            return "学生" + (studentIndex + 1);
        }

        public static void main(String[] args) {
            ClassGradeAnalyzer analyzer = new ClassGradeAnalyzer();

            // 统计某个学生的平均成绩
            int studentIndex = 0; // 假设要统计第一个学生的平均成绩
            double averageGrade = analyzer.calculateAverageGrade(studentIndex);
            System.out.println("学生" + (studentIndex + 1) + "的平均成绩为：" + averageGrade);

            // 统计某门课程的最高分和平均分
            int subjectIndex = 0; // 假设要统计第一门课程的成绩
            int maxGrade = analyzer.calculateMaxGrade(subjectIndex);
            double averageGradeForSubject = analyzer.calculateAverageGradeForSubject(subjectIndex);
            System.out.println("第" + (subjectIndex + 1) + "门课程的最高分为：" + maxGrade);
            System.out.println("第" + (subjectIndex + 1) + "门课程的平均分为：" + averageGradeForSubject);

            // 对班级中每位学生的成绩进行排序
            analyzer.sortGrades();

            // 判断某个学生是否能够被评为三好学生或优秀班干部
            studentIndex = 0; // 假设要判断第一个学生
            boolean isExcellentStudent = analyzer.isExcellentStudent(studentIndex);
            System.out.println("学生" + (studentIndex + 1) + "是否能够被评为三好学生或优秀班干部：" + isExcellentStudent);

            // 随机选取5名同学，输出姓名
            analyzer.randomlySelectStudents();
        }
    }

}
