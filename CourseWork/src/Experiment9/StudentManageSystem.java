package Experiment9;
// 计科22101班 苏一行
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class StudentManageSystem {

    static Scanner sc = new Scanner(System.in);

    static HashSet<String> ID = new HashSet<>(); // 用来存储ID, 判断是否重复

    public static void Menu(){
        System.out.println("---欢迎来到学生管理系统---");
        System.out.println("1.遍历学生 2.插入学生");
        System.out.println("3.查询学生 4.修改学生");
        System.out.println("5.删除学生 0.退出程序");
        System.out.println("--------------------");
    }

    public static void init(ArrayList<Student> students){
        students.add(new Student("2205006224", "苏一行", 22, "河北省保定市"));
        students.add(new Student("2205006225", "李明杰", 23, "河北省保定市"));
        students.add(new Student("2205006226", "顾秋炜", 21, "浙江省绍兴市"));
        students.add(new Student("2205006227", "吴煜鹏", 22, "宁夏回族自治区石嘴山市"));
        ID.add("2205006224");
        ID.add("2205006225");
        ID.add("2205006226");
        ID.add("2205006227");
    }

    // 遍历
    public static void printAll(ArrayList<Student> students){
        if (students.isEmpty()) {
            System.out.println("学生信息为空！");
            return ;
        }
        System.out.println("学号\t\t    姓名 \t 年龄 家庭住址");
        for (Student x:students){
            System.out.println(x.getId() + "\t" + x.getName() + "\t" + x.getAge() + "\t" + x.getLocation());
        }
    }

    public static boolean isRepeat(String id){
        return ID.add(id);
    }

    // Insert
    public static ArrayList<Student> insertStudent(ArrayList<Student> students){

        System.out.print("请输入学号:");
        String id = sc.next();
        if(!isRepeat(id)) {
            System.out.println("学号重复,插入失败!"); // 学号重复, 插入失败
            return students;
        }

        System.out.print("请输入姓名:");
        String name = sc.next();

        System.out.print("请输入年龄:");
        int age = sc.nextInt();

        System.out.print("请输入住址:");
        String loc = sc.next();

        students.add(new Student(id, name, age, loc));

        return students;
    }

    // find
    public static boolean findStudent(ArrayList<Student> students){
        if (students.isEmpty()) {
            System.out.println("学生信息为空,查找失败...");
            return false;
        }

        System.out.println("请输入查找方式（1. 按学号查找 2.按姓名查找）");
        int flog = sc.nextInt();
        if (flog == 1) return findByStudentID(students);
        else if(flog == 2) return findByStudentName(students);
        else {
            System.out.println("输入有误，请重新输入:");
            return findStudent(students);
        }

    }

    public static boolean findByStudentID(ArrayList<Student> students){

        System.out.print("请输入学号:");
        String id = sc.next();

        for (Student x:students){
            if (id.equals(x.getId())) {
                printStuden(x);
                return true;
            }
        }
        return false;
    }

    public static boolean findByStudentName(ArrayList<Student> students){
        System.out.print("请输入姓名:");
        String id = sc.next();

        for (Student x:students){
            if (id.equals(x.getName())) {
                printStuden(x);
                System.out.println("");
            }
        }
        return false;
    }

    public static int findIndexById(ArrayList<Student> students, String id){
        for (int i = 0; i < students.size(); i++){
            if (id.equals(students.get(i).getId())) return i;
        }
        return -1;
    }

    public static ArrayList<Student> modifyStudent(ArrayList<Student> students){
        System.out.print("请输入学生学号:");
        String id = sc.next();

        if (!ID.contains(id)){
            System.out.println("学生学号不存在，修改失败...");
            return students;
        }

        int index = findIndexById(students, id);

        System.out.println("该学生信息如下：");

        printStuden(students.get(index));

        ID.remove(id);
        System.out.print("请输入修改后的学号:");
        String m_id = sc.next();

        if (!ID.add(m_id)) {
            System.out.println("学号重复, 插入失败...");
            ID.add(id);
            return students;
        }

        System.out.print("请输入修改后的姓名:");
        String m_name = sc.next();

        System.out.print("请输入修改后的年龄:");
        int m_age = sc.nextInt();

        System.out.print("请输入修改后的住址:");
        String m_loc = sc.next();

        students.set(index, new Student(m_id, m_name, m_age, m_loc));

        return students;
    }

    public static boolean removeStudent(ArrayList<Student> students){
        System.out.println("请输入要删除的学生学号:");
        String id = sc.next();

        int index = findIndexById(students, id);

        System.out.println("该学生信息如下：");

        printStuden(students.get(index));

        System.out.println("是否确认删除？(yes or no)");

        if ("yes".equals(sc.next())){
            students.remove(index);
            ID.remove(id);
            System.out.println("删除成功！");
            return true;
        }
        else {
            System.out.println("删除操作已取消...");
            return false;
        }
    }

    public static void printStuden(Student x){
        System.out.println("学号:\t" + x.getId());
        System.out.println("姓名:\t" + x.getName());
        System.out.println("年龄:\t" + x.getAge());
        System.out.println("住址:\t" + x.getLocation());
    }
}
