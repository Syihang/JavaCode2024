package Experiment10;

import java.io.*;

public class sy10_3 {
    public static void main(String[] args) {
        File sourceFile = new File("D:\\Java\\JavaCode2024\\CourseWork\\src\\Experiment10\\sy10_2.txt");
        File destFile = new File("D:\\Java\\JavaCode2024\\CourseWork\\src\\Experiment10\\sy10_3.txt");
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            System.out.println("文件复制完成");
        } catch (IOException e) {
            System.out.println("复制文件时出错：" + e.getMessage());
        }
    }
}

