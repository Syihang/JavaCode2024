package IO;

import java.io.File;

public class deleteFile {
    public static void main(String[] args) {


        File f1 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test");
        boolean b1 = f1.delete();
        System.out.println(b1);

        File f2 = new File("D:\\Java\\JavaCode2024\\Test\\src\\IO\\Files\\test1\\test\\test\\test");
        boolean b2 = f2.delete();
        System.out.println(b2);
    }
}
