package Experiment5.Part03;

public class TeacherTest {

    public static void main(String[] args) {
        UniversityTeacher U_teacher = new UniversityTeacher("ฝฬสฺ");

        PrimarySchoolTeacher P_teacher = new PrimarySchoolTeacher("สýัง");

        U_teacher.title();
        U_teacher.teach();
        U_teacher.research();

        P_teacher.title();
        P_teacher.teach();
        P_teacher.manageClass();
    }


}
