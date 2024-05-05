package IO;

import java.io.File;
import java.nio.file.Files;

public class FileTest02 {

    public static void main(String[] args) {

        File f1 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test01.txt");
        long len = f1.length();
        System.out.println(len);
        // 返回单位是字节，如果想得到M,G 可以不断地除以1024

        File f2 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files");
        long len2 = f2.length();
        System.out.println(len2);
        // 无法获取文件夹的大小


        // getAbsolutePath()获取文件的绝对路径
        File f3 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test01.txt");
        String path1 = f3.getAbsolutePath();
        System.out.println(path1);

        File f4 = new File("Test\\src\\IO\\Files\\test01.txt");
        System.out.println(f4.exists());
        System.out.println(f4.getAbsolutePath());

        System.out.println("---------------获取定义时的路径-------------");
        // getPath() 获取定义时候的路径
        File f5 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test01.txt");
        String path2 = f3.getPath();
        System.out.println(path2);

        File f6 = new File("Test\\src\\IO\\Files\\test01.txt");
        System.out.println(f4.exists());
        System.out.println(f4.getPath());

        // getName() 获取名字
        System.out.println("--------获取名字--------------");
        File f7 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test01.txt");
        System.out.println(f7.getName());

        File f8 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files");
        System.out.println(f8.getName());


        // lastModified()返回最后修改时间
        System.out.println("------返回最后修改时间(毫秒值)-----------");
        File f9 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test01.txt");
        long time = f9.lastModified();
        System.out.println(time);


    }



}
