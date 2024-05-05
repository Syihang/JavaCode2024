package IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class creatFile {
    public static void main(String[] args) throws IOException {

        // 若文件不存在则创建文件返回true, 若文件存在则返回false
        File f1 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test02.txt");
        boolean b1 = f1.createNewFile();
        System.out.println(b1);

//        // IOException: 系统找不到指定的路径
//        File f2 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test\\test02.txt");
//        boolean b2 = f2.createNewFile();
//        System.out.println(b2);

        // 创建一个没有后缀的文件，不是文件夹
        File f3 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test");
        boolean b3 = f3.createNewFile();
        System.out.println(b3);

//        mkdir 创建文件夹
        System.out.println("-------创建文件夹----------");
        File f4 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test1");
        boolean b4 = f4.mkdir();
        System.out.println(b4);

        // mkdirs 创建多级文件夹
        System.out.println("----------创建多级文件夹--------------");
        File f5 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test1\\test\\test\\test");
        boolean b5 = f5.mkdirs();
        System.out.println(b5);
    }
}
