package Experiment10;

import java.io.*;

public class sy10_2 {
    public static void main(String[] args) {
        // ����д���ļ�
        File file = new File("D:\\Java\\JavaCode2024\\CourseWork\\src\\Experiment10\\sy10_2.txt");
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("�ļ��Ѵ���");
                }
            } catch (Exception e) {
                System.out.println("�����ļ�ʱ����" + e.getMessage());
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Java\\JavaCode2024\\CourseWork\\src\\Experiment10\\sy10_2.txt"))) {
            String data = "123\nHello, world!";
            writer.write(data);
            System.out.println("������д���ļ�");
        } catch (IOException e) {
            System.out.println("д������ʱ����" + e.getMessage());
        }

        // ���ļ��ж�ȡ����
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Java\\JavaCode2024\\CourseWork\\src\\Experiment10\\sy10_2.txt"))) {
            String line;
            System.out.println("��ȡ�����ݣ�");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("��ȡ����ʱ����" + e.getMessage());
        }
    }
}

