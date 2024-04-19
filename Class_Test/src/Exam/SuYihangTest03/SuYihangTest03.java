package Exam.SuYihangTest03;
// ��һ�� 2205006224
class Book{
    // ����
    private String no;
    private String name;
    private String author;


    public Book() {}

    public Book(String no) {
        this.no = no;
    }

    public Book(String no, String name) {
        this.no = no;
        this.name = name;
    }

    public Book(String no, String name, String author) {
        this.no = no;
        this.name = name;
        this.author = author;
    }

    // ��ȡ���
    public String getNo() {
        return no;
    }

    // �������
    public void setNo(String no) {
        this.no = no;
    }

    // ��ȡ����
    public String getName() {
        return name;
    }

    // ��������
    public void setName(String name) {
        this.name = name;
    }

    // ��ȡ����
    public String getAuthor() {
        return author;
    }

    // ��������
    public void setAuthor(String author) {
        this.author = author;
    }

    // ��������Ϣ
    public void show() {
        System.out.println("�鼮��Ϣ:");
        System.out.println("���: " + no);
        System.out.println("����: " + name);
        System.out.println("����: " + author);
    }
}

public class SuYihangTest03 {

    public static void main(String[] args) {

        Book book1 = new Book("001", "Java ����", "�������Ա");
        Book book2 = new Book(); // ʹ���޲ι��췽����������

        // �������1����Ϣ
        System.out.println("Object 1:");
        book1.show();

        // �������2����Ϣ��δ��ʼ����
        System.out.println("\nObject 2(δ��ʼ��):");
        book2.show();

        // �޸Ķ���2�����������
        book2.setName("�㷨��������");
        book2.setNo("002");
        book2.setAuthor("�����");

        // ����޸ĺ����2����Ϣ
        System.out.println("\nObject 2:");
        book2.show();
    }
}
