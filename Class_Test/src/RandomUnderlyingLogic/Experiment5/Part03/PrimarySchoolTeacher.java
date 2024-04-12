package RandomUnderlyingLogic.Experiment5.Part03;

public class PrimarySchoolTeacher extends Teacher{
    public String course;

    public PrimarySchoolTeacher(String course) {
        this.course = course;
    }

    @Override
    public void title() {
        System.out.println("科目：" + course);
    }

    public void manageClass() {
        System.out.println("班级管理");
    }
}
