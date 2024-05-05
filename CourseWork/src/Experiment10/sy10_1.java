package Experiment10;
// 计科22101 苏一行
import java.io.File;

public class sy10_1 {
    public static void main(String[] args) {
        // 创建文件夹
        File folder = new File("D:\\Java\\JavaCode2024\\CourseWork\\src\\Experiment10\\test");
        if (!folder.exists()) {
            folder.mkdir();
            System.out.println("文件夹已创建");
        }

        // 创建文件
        File file = new File("D:\\Java\\JavaCode2024\\CourseWork\\src\\Experiment10\\test\\a.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("文件已创建");
            }
        } catch (Exception e) {
            System.out.println("创建文件时出错：" + e.getMessage());
        }

        // 列出文件夹中的内容
        File[] files = folder.listFiles();
        System.out.println("文件夹中的内容：");
        if (files != null)
        for (File f : files) {
            System.out.println(f.getName());
        }
        
        deleteAll(folder);
/*
        // 删除文件
        if (file.delete()) {
            System.out.println("文件已删除");
        }

        // 删除文件夹
        if (folder.delete()) {
            System.out.println("文件夹已删除");
        }
 */

    }



    public static void deleteAll(File file){
        if (file.isFile()) file.delete();

        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files != null){
                for (File f:files){
                    deleteAll(f);
                }
            }
            file.delete();
        }
    }
}

