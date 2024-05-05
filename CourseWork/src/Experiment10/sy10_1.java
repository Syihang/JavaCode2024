package Experiment10;
// �ƿ�22101 ��һ��
import java.io.File;

public class sy10_1 {
    public static void main(String[] args) {
        // �����ļ���
        File folder = new File("D:\\Java\\JavaCode2024\\CourseWork\\src\\Experiment10\\test");
        if (!folder.exists()) {
            folder.mkdir();
            System.out.println("�ļ����Ѵ���");
        }

        // �����ļ�
        File file = new File("D:\\Java\\JavaCode2024\\CourseWork\\src\\Experiment10\\test\\a.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("�ļ��Ѵ���");
            }
        } catch (Exception e) {
            System.out.println("�����ļ�ʱ����" + e.getMessage());
        }

        // �г��ļ����е�����
        File[] files = folder.listFiles();
        System.out.println("�ļ����е����ݣ�");
        if (files != null)
        for (File f : files) {
            System.out.println(f.getName());
        }
        
        deleteAll(folder);
/*
        // ɾ���ļ�
        if (file.delete()) {
            System.out.println("�ļ���ɾ��");
        }

        // ɾ���ļ���
        if (folder.delete()) {
            System.out.println("�ļ�����ɾ��");
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

