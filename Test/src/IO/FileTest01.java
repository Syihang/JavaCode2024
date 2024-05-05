package IO;
// 判断文件或文件夹是否存在
import java.io.File;

public class FileTest01 {
    public static void main(String[] args) {

        File f1 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test01.txt");
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        System.out.println(f1.exists());
        System.out.println("-----------------------------------");
        File f2 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files");
        System.out.println(f2.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.exists());
    }
}
