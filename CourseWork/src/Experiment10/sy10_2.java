package Experiment10;

import java.io.*;

public class sy10_2 {
    public static void main(String[] args) {
        // 数据写入文件
        File file = new File("D:\\Java\\JavaCode2024\\CourseWork\\src\\Experiment10\\sy10_2.txt");
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("文件已创建");
                }
            } catch (Exception e) {
                System.out.println("创建文件时出错：" + e.getMessage());
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Java\\JavaCode2024\\CourseWork\\src\\Experiment10\\sy10_2.txt"))) {
            String data = "123\nHello, world!";
            writer.write(data);
            System.out.println("数据已写入文件");
        } catch (IOException e) {
            System.out.println("写入数据时出错：" + e.getMessage());
        }

        // 从文件中读取数据
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Java\\JavaCode2024\\CourseWork\\src\\Experiment10\\sy10_2.txt"))) {
            String line;
            System.out.println("读取的数据：");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("读取数据时出错：" + e.getMessage());
        }
    }
}

