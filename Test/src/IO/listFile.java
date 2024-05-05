package IO;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class listFile {
    public static void main(String[] args) {

        // public File[] listFiles() 获取当前路径下的所有内容(路径)

        File f1 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files");
        File[] files = f1.listFiles();

        System.out.println(files.length);
        System.out.println(files);
        for (File file:files){
            System.out.println(file);
        }


        // listRoots 获取系统中所有的盘符
        File[] arr = File.listRoots();
        System.out.println(Arrays.toString(arr));

        // list() 获取该路径下所有的内容（名字）
        File f2 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files");
        String[] arr2 = f2.list();
        for (String s : arr2) {
            System.out.println(s);
        }

//      文件名过滤器
        System.out.println("-----------list----------------");
        File f3 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files");
        String[] arr3 = f3.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File src = new File(dir, name);
                if (src.isFile() && name.endsWith(".txt")){
                    return true;
                }
                return false;
            }
        });

        System.out.println(Arrays.toString(arr3));


        System.out.println("--------------------listFiles(FileFilter filter)--------------------------");
        File f4 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files");
        File[] arr4 = f4.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {

                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        System.out.println(Arrays.toString(arr4));


        System.out.println("--------------------listFiles(FilenameFilter filter)--------------------------");
        File f5 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files");
        File[] arr5 = f5.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File src = new File(dir, name);

                return src.isFile() && name.endsWith(".txt");
            }
        });

        System.out.println(Arrays.toString(arr5));
    }
}
