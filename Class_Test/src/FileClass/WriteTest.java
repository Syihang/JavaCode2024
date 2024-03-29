package FileClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class WriteTest {

    public static void main(String[] args) {
        Module module = WriteTest.class.getModule();
        String moduleName = module.getName();
        String packageName = WriteTest.class.getPackage().getName();
        String filePath ="Class_Test" + "/src/" + packageName.replace(".", "/") + "/a.txt";
        File file = new File(filePath);

//        String className = Thread.currentThread().getStackTrace()[1].getClassName();
//        System.out.println("当前类的名称是：" + className);

        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("文件a.txt不存在，已创建该文件。");
            } else {
                FileInputStream fis = new FileInputStream(file);
                byte[] data = new byte[(int) file.length()];
                fis.read(data);
                fis.close();

                String content = new String(data, "UTF-8");
                System.out.println("文件内容：");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
