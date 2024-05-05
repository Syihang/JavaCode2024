package FileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class test01 {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Java\\JavaCode2024\\Class_Test\\src\\FileTest\\test01.txt";

        File file = new File(filePath);

        if (file.exists()) {
            System.out.println(file);
        }
        else {
            file.createNewFile();
        }

        FileInputStream fin = new FileInputStream(file);

        int b = fin.read();
        System.out.println(b + " " + (char)fin.read());
    }
}
