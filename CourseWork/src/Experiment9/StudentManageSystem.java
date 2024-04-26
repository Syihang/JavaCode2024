package Experiment9;
// �ƿ�22101�� ��һ��
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class StudentManageSystem {

    static Scanner sc = new Scanner(System.in);

    static HashSet<String> ID = new HashSet<>(); // �����洢ID, �ж��Ƿ��ظ�

    public static void Menu(){
        System.out.println("---��ӭ����ѧ������ϵͳ---");
        System.out.println("1.����ѧ�� 2.����ѧ��");
        System.out.println("3.��ѯѧ�� 4.�޸�ѧ��");
        System.out.println("5.ɾ��ѧ�� 0.�˳�����");
        System.out.println("--------------------");
    }

    public static void init(ArrayList<Student> students){
        students.add(new Student("2205006224", "��һ��", 22, "�ӱ�ʡ������"));
        students.add(new Student("2205006225", "������", 23, "�ӱ�ʡ������"));
        students.add(new Student("2205006226", "�����", 21, "�㽭ʡ������"));
        students.add(new Student("2205006227", "������", 22, "���Ļ���������ʯ��ɽ��"));
        ID.add("2205006224");
        ID.add("2205006225");
        ID.add("2205006226");
        ID.add("2205006227");
    }

    // ����
    public static void printAll(ArrayList<Student> students){
        if (students.isEmpty()) {
            System.out.println("ѧ����ϢΪ�գ�");
            return ;
        }
        System.out.println("ѧ��\t\t    ���� \t ���� ��ͥסַ");
        for (Student x:students){
            System.out.println(x.getId() + "\t" + x.getName() + "\t" + x.getAge() + "\t" + x.getLocation());
        }
    }

    public static boolean isRepeat(String id){
        return ID.add(id);
    }

    // Insert
    public static ArrayList<Student> insertStudent(ArrayList<Student> students){

        System.out.print("������ѧ��:");
        String id = sc.next();
        if(!isRepeat(id)) {
            System.out.println("ѧ���ظ�,����ʧ��!"); // ѧ���ظ�, ����ʧ��
            return students;
        }

        System.out.print("����������:");
        String name = sc.next();

        System.out.print("����������:");
        int age = sc.nextInt();

        System.out.print("������סַ:");
        String loc = sc.next();

        students.add(new Student(id, name, age, loc));

        return students;
    }

    // find
    public static boolean findStudent(ArrayList<Student> students){
        if (students.isEmpty()) {
            System.out.println("ѧ����ϢΪ��,����ʧ��...");
            return false;
        }

        System.out.println("��������ҷ�ʽ��1. ��ѧ�Ų��� 2.���������ң�");
        int flog = sc.nextInt();
        if (flog == 1) return findByStudentID(students);
        else if(flog == 2) return findByStudentName(students);
        else {
            System.out.println("������������������:");
            return findStudent(students);
        }

    }

    public static boolean findByStudentID(ArrayList<Student> students){

        System.out.print("������ѧ��:");
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
        System.out.print("����������:");
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
        System.out.print("������ѧ��ѧ��:");
        String id = sc.next();

        if (!ID.contains(id)){
            System.out.println("ѧ��ѧ�Ų����ڣ��޸�ʧ��...");
            return students;
        }

        int index = findIndexById(students, id);

        System.out.println("��ѧ����Ϣ���£�");

        printStuden(students.get(index));

        ID.remove(id);
        System.out.print("�������޸ĺ��ѧ��:");
        String m_id = sc.next();

        if (!ID.add(m_id)) {
            System.out.println("ѧ���ظ�, ����ʧ��...");
            ID.add(id);
            return students;
        }

        System.out.print("�������޸ĺ������:");
        String m_name = sc.next();

        System.out.print("�������޸ĺ������:");
        int m_age = sc.nextInt();

        System.out.print("�������޸ĺ��סַ:");
        String m_loc = sc.next();

        students.set(index, new Student(m_id, m_name, m_age, m_loc));

        return students;
    }

    public static boolean removeStudent(ArrayList<Student> students){
        System.out.println("������Ҫɾ����ѧ��ѧ��:");
        String id = sc.next();

        int index = findIndexById(students, id);

        System.out.println("��ѧ����Ϣ���£�");

        printStuden(students.get(index));

        System.out.println("�Ƿ�ȷ��ɾ����(yes or no)");

        if ("yes".equals(sc.next())){
            students.remove(index);
            ID.remove(id);
            System.out.println("ɾ���ɹ���");
            return true;
        }
        else {
            System.out.println("ɾ��������ȡ��...");
            return false;
        }
    }

    public static void printStuden(Student x){
        System.out.println("ѧ��:\t" + x.getId());
        System.out.println("����:\t" + x.getName());
        System.out.println("����:\t" + x.getAge());
        System.out.println("סַ:\t" + x.getLocation());
    }
}
