package Exam.SuYihangTest03;
// 苏一行 2205006224
class Book{
    // 属性
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

    // 获取书号
    public String getNo() {
        return no;
    }

    // 设置书号
    public void setNo(String no) {
        this.no = no;
    }

    // 获取书名
    public String getName() {
        return name;
    }

    // 设置书名
    public void setName(String name) {
        this.name = name;
    }

    // 获取作者
    public String getAuthor() {
        return author;
    }

    // 设置作者
    public void setAuthor(String author) {
        this.author = author;
    }

    // 输出书的信息
    public void show() {
        System.out.println("书籍信息:");
        System.out.println("序号: " + no);
        System.out.println("书名: " + name);
        System.out.println("作者: " + author);
    }
}

public class SuYihangTest03 {

    public static void main(String[] args) {

        Book book1 = new Book("001", "Java 基础", "黑马程序员");
        Book book2 = new Book(); // 使用无参构造方法创建对象

        // 输出对象1的信息
        System.out.println("Object 1:");
        book1.show();

        // 输出对象2的信息（未初始化）
        System.out.println("\nObject 2(未初始化):");
        book2.show();

        // 修改对象2的姓名和书号
        book2.setName("算法竞赛入门");
        book2.setNo("002");
        book2.setAuthor("刘汝佳");

        // 输出修改后对象2的信息
        System.out.println("\nObject 2:");
        book2.show();
    }
}
