// ��һ�� 2205006224
package Exam.SuYihangTest04;

public class SuYihangTest04 {
    public static void main(String[] args) {
        // ��ȡϵͳ��Ϣ
        System.out.println("����ϵͳ��" + System.getProperty("os.name"));
        System.out.println("����ϵͳ�汾��" + System.getProperty("os.version"));

        // ��ȡJava�������Ϣ
        System.out.println("Java������汾��" + System.getProperty("java.vm.version"));
        System.out.println("Java(JDK)�汾��" + System.getProperty("java.version"));

        // ��ȡ�ڴ���Ϣ
        Runtime runtime = Runtime.getRuntime();
        System.out.println("�ڴ�������" + runtime.totalMemory());
        System.out.println("�����ڴ棺" + runtime.freeMemory());

        // ��ȡ��ǰʱ��
        System.out.println("��ǰʱ�䣺" + System.currentTimeMillis());
    }
}
