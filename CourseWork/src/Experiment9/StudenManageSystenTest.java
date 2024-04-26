package Experiment9;

import java.util.ArrayList;

public class StudenManageSystenTest extends StudentManageSystem {


    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        init(students);
        while (true){
            Menu();
            int x = sc.nextInt();
            if (x == 0) break;
            switch (x){
                case 1 -> printAll(students);
                case 2 -> insertStudent(students);
                case 3 -> findStudent(students);
                case 4 -> modifyStudent(students);
                case 5 -> removeStudent(students);
            }
        }

    }


}
