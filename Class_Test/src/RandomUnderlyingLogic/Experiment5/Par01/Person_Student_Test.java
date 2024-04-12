package RandomUnderlyingLogic.Experiment5.Par01;

// Person ��
class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public final void printStars() {
        System.out.println("*****************");
    }

    public void fun() {
        System.out.println("������" + name + "�����䣺" + age);
    }
}

// Student ��
class Students extends Person {
    private int num;

    public Students() {
    }

    public Students(int num, String name, int age) {
        super(name, age);
        this.num = num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public void fun() {
        super.fun();
        System.out.println("ѧ�ţ�" + num);
    }
}

public class Person_Student_Test {
    public static void main(String[] args) {
        Students student = new Students(200804201, "����", 23);
        Person person = new Person("����", 30);

        student.fun();
        person.fun();

        person.printStars(); // ʹ�ø��෽��
        // student.printStars(); // �����޷���д final ����������޷�����
    }
}
